package hangrong.model;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hangrong.pojo.ThanhVien;

@Service
public class UploadService {

	public String uploadAvatar(HttpServletRequest request,MultipartFile file,String username) {
		String path = request.getServletContext().getRealPath("/resources/images");
		String avatar = "avatar_"+username;
		try {
			String filePath = path+"\\"+avatar;
			BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(filePath));
			buffer.write(file.getBytes());
			buffer.close();
			String imagePath = "resources/images/"+avatar;
			ThanhVien thanhVien = ThanhVienDAO.getThanhVien(username);
			thanhVien.setAnh(imagePath);
			ThanhVienDAO.updateThanhVien(thanhVien);
			return  imagePath;
		} catch (Exception e) {
			return null;
		}
	}

}
