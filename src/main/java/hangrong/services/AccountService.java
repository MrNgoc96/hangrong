package hangrong.services;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hangrong.dao.AccountDAO;
import hangrong.pojo.Account;

@Service
public class AccountService {
	@Autowired
	private AccountDAO accountDAO;

	public String uploadAvatar(HttpServletRequest request, MultipartFile file, String username) {
		String path = request.getServletContext().getRealPath("/resources/images");
		String avatar = "avatar_" + username;
		try {
			String filePath = path + "\\" + avatar;
			BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(filePath));
			buffer.write(file.getBytes());
			buffer.close();
			String imagePath = "resources/images/" + avatar;
			Account thanhVien = accountDAO.getAccount(username);
			thanhVien.setAnh(imagePath);
			accountDAO.updateAccount(thanhVien);
			return imagePath;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean updateAccount(Account account) {
		return accountDAO.updateAccount(account);
	}

	public boolean deleteAccount(String username) {
		return accountDAO.deleteAccount(username);
	}
	
	public boolean addAccount(Account account) {
		return accountDAO.addAccount(account);
		
	}

}
