package com.spring.project.utlity;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.spring.project.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerater {

	public void pdfGenerate(HttpServletResponse response, List<CitizenPlan> record, File file) throws Exception {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		Paragraph par = new Paragraph("Citizen Plane Info");
		par.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(par);
		PdfPTable table = new PdfPTable(7);
		table.setWidthPercentage(100f);
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plane Name");
		table.addCell("Plane Status");
		table.addCell("Plane Start Date");
		table.addCell("Plane End Date");
		table.addCell("Benifit Amt");

		for (CitizenPlan plane : record) {
			table.addCell(String.valueOf(plane.getCitizenId()));
			table.addCell(plane.getCitizenName());
			table.addCell(plane.getPlanName());
			table.addCell(plane.getPlanStatus());
			table.addCell(plane.getPlaneStartDate() + "");
			table.addCell(plane.getPlaneEndDate() + "");
			table.addCell(String.valueOf(plane.getBenefitAmt()));

		}

		document.add(table);
		document.close();
	}

}
