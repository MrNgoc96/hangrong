package hangrong.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected String home(HttpServletRequest request) {
		request.getSession().setAttribute("currentUser", null);
		return "index";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	protected String home() {
		return "index";
	}
   
}
