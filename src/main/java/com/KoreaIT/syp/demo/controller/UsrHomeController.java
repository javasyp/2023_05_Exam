package com.KoreaIT.syp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.KoreaIT.syp.demo.vo.Rq;

@Controller
public class UsrHomeController {
	private Rq rq;

	public UsrHomeController(Rq rq) {
		this.rq = rq;
	}
	
	@RequestMapping("/usr/home/main")
	public String showMain() {
		return "usr/home/main";
	}
	
	@RequestMapping("/")
	public String showRoot() {
		return "redirect:/usr/home/main";
	}
}