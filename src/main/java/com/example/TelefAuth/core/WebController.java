package com.example.TelefAuth.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	
	 @GetMapping({"/","index"})
	  public String inicio() {
	    return "index";
	  }

	 @GetMapping("/webprivado")
	  public String privado() {
	    return "privado";
	  }
	 @GetMapping("/webpublico")
	  public String loginpub() {
	    return "publico";
	  }
	 @GetMapping("/webadmin")
	  public String admin() {
	    return "admin";
	  }
	 @GetMapping("/login")
	  public String login() {
	    return "login";
	  }
}
