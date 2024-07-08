package com.spring.project.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.spring.project.entity.CitizenPlan;
import com.spring.project.repository.CitizenInfoRepo;
import com.spring.project.request.SearchRequest;
import com.spring.project.utlity.EmailUtils;
import com.spring.project.utlity.ExcelGenerater;
import com.spring.project.utlity.PdfGenerater;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImp implements ReportService {

	@Autowired
	private CitizenInfoRepo citizenInfoRepo;

	@Autowired
	private ExcelGenerater excelGenerater;

	@Autowired
	private PdfGenerater pdfGenerater;

	@Autowired
	private EmailUtils emailUtils;

	@Override
	public List<String> getPlanNames() {

		return citizenInfoRepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatuses() {

		return citizenInfoRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {

		CitizenPlan entity = new CitizenPlan();

		if (null != request.getPlaneName() && !"".equals(request.getPlaneName())) {
			entity.setPlanName(request.getPlaneName());
		}

		if (null != request.getPlaneStatus() && !"".equals(request.getPlaneStatus())) {
			entity.setPlanStatus(request.getPlaneStatus());
		}

		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}

		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(startDate, ofPattern);

			entity.setPlaneStartDate(localDate);
		}

		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String startDate = request.getEndDate();
			DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(startDate, ofPattern);

			entity.setPlaneEndDate(localDate);
		}

		return citizenInfoRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		File f = new File("planes.xls");
		List<CitizenPlan> all = citizenInfoRepo.findAll();
		excelGenerater.excelGenerate(response, all, f);

		String subject = "Test mail subject";
		String body = "<h1>Test mail body</h1>";
		String to = "kundankumar960507@gmail.com";
		emailUtils.sendEmail(subject, body, to, f);
		f.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		File f = new File("planes.pdf");
		List<CitizenPlan> all = citizenInfoRepo.findAll();
		pdfGenerater.pdfGenerate(response, all, f);

		String subject = "Test mail subject";
		String body = "<h1>Test mail body</h1>";
		String to = "kundankumar960507@gmail.com";
		emailUtils.sendEmail(subject, body, to, f);
		f.delete();
		return true;
	}

}
