package hangrong.controller;




import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;



@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected String home(Model model) {
		return "index";
	}
   
}
