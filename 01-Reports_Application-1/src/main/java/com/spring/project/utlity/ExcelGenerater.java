package com.spring.project.utlity;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.spring.project.entity.CitizenPlan;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerater {

	public void excelGenerate(HttpServletResponse response, List<CitizenPlan> record,File file) throws Exception {

		// Workbook workbook = new XSSFWorkbook();
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("plans-data");
		Row row = sheet.createRow(0);

		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Citizen Name");
		row.createCell(2).setCellValue("Plane Name");
		row.createCell(3).setCellValue("Plane Status");
		row.createCell(4).setCellValue("Plane Start Date");
		row.createCell(5).setCellValue("Plane End Date");
		row.createCell(6).setCellValue("Benifit Amt");

		int dataRowIndex = 1;
		for (CitizenPlan plane : record) {

			Row data = sheet.createRow(dataRowIndex);
			data.createCell(0).setCellValue(plane.getCitizenId());
			data.createCell(1).setCellValue(plane.getCitizenName());
			data.createCell(2).setCellValue(plane.getPlanName());
			data.createCell(3).setCellValue(plane.getPlanStatus());

			if (null != plane.getPlaneStartDate()) {
				data.createCell(4).setCellValue(plane.getPlaneStartDate() + "");
			} else {
				data.createCell(4).setCellValue("N/A");
			}

			if (null != plane.getPlaneEndDate()) {
				data.createCell(5).setCellValue(plane.getPlaneEndDate());
			} else {
				data.createCell(5).setCellValue("N/A");
			}

			if (null != plane.getBenefitAmt()) {
				data.createCell(6).setCellValue(plane.getBenefitAmt() + "");
			} else {
				data.createCell(6).setCellValue("N/A");
			}

			dataRowIndex++;
		}
		FileOutputStream out=new FileOutputStream(file);
		workbook.write(out);
		out.close();
		
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
	}

}
