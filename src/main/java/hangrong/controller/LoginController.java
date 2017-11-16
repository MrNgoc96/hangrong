package hangrong.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;

import hangrong.dao.AccountDAO;
import hangrong.pojo.Account;
import hangrong.services.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	protected String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	protected String login(@RequestParam String username, @RequestParam String password,ModelMap model,
			HttpSession session) {
		Account thanhVien;
		if (loginService.checkLogin(username, password)) {
			thanhVien = loginService.getAccount(username);
			session.setAttribute("currentUser", thanhVien);
			model.addAttribute("loginSuccess", true);
			return "index";
		} else {
			model.addAttribute("message", "Tài khoản hoặc mật khẩu không chính xác, xin mời bạn hãy nhập lại !");
			return "login";
		}
	}

	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	protected String logout(HttpSession session) {
		session.setAttribute("currentUser", null);
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
	
	@RequestMapping(value = "/google-sign-in", method = RequestMethod.POST)
	protected String googleSignIn(@RequestParam String idToken,HttpSession session) {
		Payload payload = loginService.getGoogleUser(idToken);
		String id = payload.getSubject();
		String name = (String) payload.get("name");
		String image = (String) payload.get("picture");
		Account thanhVien = loginService.getAccount(id);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		if (thanhVien == null) {
			thanhVien = new Account(id, "", name, "", "", image, "GoogleUser", format.format(new Date()));
			loginService.addAccount(thanhVien);
		}
		session.setAttribute("currentUser", thanhVien);
		session.setAttribute("googleLogin", true);
		return "login";
	}
	
	@RequestMapping(value = "/google-sign-out", method = RequestMethod.GET)
	protected String googleSignOut(HttpSession session) {
		session.setAttribute("googleLogin", null);
		session.setAttribute("currentUser", null);
		return "redirect:trang-chu";
	}

}
