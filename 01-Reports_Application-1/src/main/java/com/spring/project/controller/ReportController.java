package com.spring.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.project.entity.CitizenPlan;
import com.spring.project.request.SearchRequest;
import com.spring.project.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {
	@Autowired
	private ReportService service;

	@GetMapping("/excel")
	public void exportExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment; filename=planes.xls");
		service.exportExcel(response);
	}

	@GetMapping("/pdf")
	public void exportPdf(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=planes.pdf");
		service.exportPdf(response);
	}

	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchRequest request, Model model) {

		System.out.println(request);

		List<CitizenPlan> plans = service.search(request);
		model.addAttribute("plans", plans);
		init(model);
		return "index";
	}

	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("search", new SearchRequest());
		init(model);
		return "index";
	}

	private void init(Model model) {
		// model.addAttribute("search", new SearchRequest());
		model.addAttribute("name", service.getPlanNames());
		model.addAttribute("status", service.getPlanStatuses());
	}

}
