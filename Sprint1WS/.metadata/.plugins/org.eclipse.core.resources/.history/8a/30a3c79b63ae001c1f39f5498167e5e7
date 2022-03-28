package com.capgemini.cab.management.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.capgemini.cab.management.application.service.CabService;

@Controller
public class CabController {

	private CabService cabService;

	public CabController(CabService cabService) {
		super();
		this.cabService = cabService;
	}
	
	// handle method to handle list of cabs and return mode and view
	@GetMapping("/cabs")
	public String listCabs(Model model) {
		model.addAttribute("cars", cabService.getAllCabs());
		return "cabs";
	}
}
