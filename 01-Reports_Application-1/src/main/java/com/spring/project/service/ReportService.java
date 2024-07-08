package com.spring.project.service;

import java.util.List;

import com.spring.project.entity.CitizenPlan;
import com.spring.project.request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {
	
	public List<String> getPlanNames();
	public List<String> getPlanStatuses();
	public List<CitizenPlan> search(SearchRequest request);
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	public boolean exportPdf(HttpServletResponse response) throws Exception;
	
	
	

}
