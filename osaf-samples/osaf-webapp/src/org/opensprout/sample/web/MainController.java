package org.opensprout.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*.do")
public class MainController {
	@RequestMapping
	public void main() {
	}
	
	@RequestMapping
	public void login() {
	}
	
	@RequestMapping
	public void logout() {
	}
}
