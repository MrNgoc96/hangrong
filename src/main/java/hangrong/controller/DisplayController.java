package hangrong.controller;


import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import hangrong.pojo.Product;
import hangrong.services.DisplayService;

@Controller
public class DisplayController {
	
	@Autowired
	private DisplayService displayService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected String home(HttpServletRequest request) {
		return "redirect:trang-chu";
	}

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	protected String home(ModelMap model) {
		ArrayList<Product> listMatHang = displayService.getAllProduct();
		model.addAttribute("listMatHang", listMatHang);
		return "index";
	}

	@RequestMapping(value = "/chi-tiet", method = RequestMethod.GET)
	protected String matHangDetail(@RequestParam String maHang, ModelMap model) {
		Product matHang = displayService.getProduct(maHang);
		String capGanhHang = displayService.getCapGanhHang(matHang.getNguoiban().getUsername());
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
		ArrayList<Product> list = displayService.getProductFromType(loai);
		model.addAttribute("listMatHang",displayService.divisionPage(list, page));
		model.addAttribute("totalPage", displayService.totalPage(list.size()));
		model.addAttribute("loai", loai);
		model.addAttribute("page", page);
		return "product";
	}
	
	@RequestMapping(value = "/trang-ca-nhan", method = RequestMethod.GET)
	protected String showProfile(@RequestParam String userId, Model model) {
		String capGanhHang = displayService.getCapGanhHang(userId);
		model.addAttribute("capGanhHang",capGanhHang);
		return "profile";
	}
	@RequestMapping(value = "/trang-ca-nhan", method = RequestMethod.POST)
	protected String editProfile(@RequestParam String userId, Model model) {
		String capGanhHang = displayService.getCapGanhHang(userId);
		model.addAttribute("capGanhHang",capGanhHang);
		return "profile";
	}
	
	

}
