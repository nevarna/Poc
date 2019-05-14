package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageControler {

	//@GetMapping({"pages","/message/info"})
	@GetMapping("pages")
	public String get() {
		System.out.println("here");
		return "page" ;
	}
	
}
