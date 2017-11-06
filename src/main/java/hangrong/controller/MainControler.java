package hangrong.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;

import hangrong.model.GoogleService;
import hangrong.model.MatHangDAO;
import hangrong.model.ThanhVienDAO;
import hangrong.model.UploadService;
import hangrong.pojo.MatHang;
import hangrong.pojo.ThanhVien;

@Controller
public class MainControler {

	@Autowired
	UploadService upload;
	@Autowired
	GoogleService googleService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected String home(HttpServletRequest request) {
		return "redirect:trang-chu";
	}

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	protected String home(ModelMap model) {
		ArrayList<MatHang> listMatHang = MatHangDAO.getListMatHang("");
		model.addAttribute("listMatHang", listMatHang);
		return "index";
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	protected String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	protected ModelAndView login(@RequestParam String username, @RequestParam String password, Model model,
			HttpSession session) {
		ThanhVien thanhVien;
		ModelAndView modelAndView;
		if (ThanhVienDAO.checkLogin(username, password)) {
			thanhVien = ThanhVienDAO.getThanhVien(username);
			session.setAttribute("currentUser", thanhVien);
			modelAndView = new ModelAndView("redirect:trang-chu");
		} else {
			model.addAttribute("message", "Tài khoản hoặc mật khẩu không chính xác, xin mời bạn hãy nhập lại !");
			modelAndView = new ModelAndView("login");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	protected String logout(HttpServletRequest request) {
		request.getSession().setAttribute("currentUser", null);
		return "redirect:trang-chu";
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	protected String showRegisterPage() {
		return "register";
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	protected String register() {
		return "register";
	}

	@RequestMapping(value = "/chi-tiet", method = RequestMethod.GET)
	protected String matHangDetail(@RequestParam String maHang, ModelMap model) {
		MatHang matHang = MatHangDAO.getMatHang(maHang);
		String capGanhHang = ThanhVienDAO.getCapGanhHang(matHang.getNguoiban().getUsername());
		model.addAttribute("matHang", matHang);
		model.addAttribute("capGanhHang", capGanhHang);
		return "detail";
	}
	
	@RequestMapping(value = "/dang-tin", method = RequestMethod.GET)
	protected String showDangTinPage() {
		return "new-product";
	}
	
	@RequestMapping(value = "/dang-tin", method = RequestMethod.POST)
	protected String addNewProduct() {
		return "new-product";
	}
	
	@RequestMapping(value = "/danh-muc", method = RequestMethod.GET)
	protected String showPageMathang(@RequestParam String loai,@RequestParam(defaultValue="1") int page, ModelMap model) {
		ArrayList<MatHang> list = MatHangDAO.getListMatHang("");
		model.addAttribute("listMatHang",MatHangDAO.divisionPage(list, page));
		model.addAttribute("totalPage", MatHangDAO.totalPage(list.size()));
		model.addAttribute("loai", loai);
		model.addAttribute("page", page);
		return "product";
	}
	
	@RequestMapping(value = "/trang-ca-nhan", method = RequestMethod.GET)
	protected String showProfile(@RequestParam String userId, Model model) {
		String capGanhHang = ThanhVienDAO.getCapGanhHang(userId);
		model.addAttribute("capGanhHang",capGanhHang);
		return "profile";
	}
	
	@RequestMapping(value = "/google-sign-in", method = RequestMethod.POST)
	protected String googleSignIn(@RequestParam String idToken,HttpSession session) {
		Payload payload = googleService.getGoogleUser(idToken);
		String id = payload.getSubject();
		String name = (String) payload.get("name");
		String image = (String) payload.get("picture");
		ThanhVien thanhVien = ThanhVienDAO.getThanhVien(id);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		if (thanhVien == null) {
			thanhVien = new ThanhVien(id, "", name, "", "", image, "Thành Viên", format.format(new Date()));
			ThanhVienDAO.addThanhVien(thanhVien);
		}
		session.setAttribute("currentUser", thanhVien);
		return "login";
	}

}
