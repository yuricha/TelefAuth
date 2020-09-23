package com.example.TelefAuth.core;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableResourceServer
@RestController
public class ControllerServer extends ResourceServerConfigurerAdapter {

	  @GetMapping("/publica")
	  public String publico() {
	    return "Pagina Publica";
	  }
	  @GetMapping("/privada")
	  public String privada() {
	    return "Pagina Privada";
	  }
	  @GetMapping("/admin")
	  public String admin() {
	    return "Pagina Administrador";
	  }
	  @Override
		public void configure(HttpSecurity http) throws Exception {
			http
			.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**", "/publica").permitAll();
//			 .anyRequest().authenticated();
			http.requestMatchers().antMatchers("/privada")
			.and().authorizeRequests()
			.antMatchers("/privada").access("hasRole('USER')")
			.and().requestMatchers().antMatchers("/admin")
			.and().authorizeRequests()
			.antMatchers("/admin").access("hasRole('ADMIN')");
		}   
}
