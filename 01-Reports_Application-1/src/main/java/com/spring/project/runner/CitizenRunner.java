package com.spring.project.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.spring.project.entity.CitizenPlan;
import com.spring.project.repository.CitizenInfoRepo;

@Component
public class CitizenRunner implements ApplicationRunner {

	@Autowired
	private CitizenInfoRepo citizenInfo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		citizenInfo.deleteAll();

		// Cash Plan Data
		CitizenPlan c1 = new CitizenPlan();
		
		c1.setCitizenName("John");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlaneStartDate(LocalDate.now());
		c1.setPlaneEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmt(6000.00);

		// Cash Plan Data

		CitizenPlan c2 = new CitizenPlan();
		
		c2.setCitizenName("Smith");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialReason("Rental Income");

		// Cash Plan Data
		CitizenPlan c3 = new CitizenPlan();
		
		c3.setCitizenName("Puja");
		c3.setGender("Female");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlaneStartDate(LocalDate.now().minusMonths(4));
		c3.setPlaneEndDate(LocalDate.now().plusMonths(6));
		c3.setBenefitAmt(6000.00);
		c3.setTerminatedDate(LocalDate.now());
		c3.setTerminationRsn("Employed");

		// Food Plan Data
		CitizenPlan c4 = new CitizenPlan();
		
		c4.setCitizenName("David");
		c4.setGender("Male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlaneStartDate(LocalDate.now());
		c4.setPlaneEndDate(LocalDate.now().plusMonths(6));
		c4.setBenefitAmt(5000.00);

		// Food Plan Data

		CitizenPlan c5 = new CitizenPlan();
		
		c5.setCitizenName("Gitika");
		c5.setGender("Female");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setDenialReason("Property Income");

		// Food Plan Data
		CitizenPlan c6 = new CitizenPlan();
		
		c6.setCitizenName("Kalyani");
		c6.setGender("Female");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlaneStartDate(LocalDate.now().minusMonths(4));
		c6.setPlaneEndDate(LocalDate.now().plusMonths(6));
		c6.setBenefitAmt(6000.00);
		c6.setTerminatedDate(LocalDate.now());
		c6.setTerminationRsn("Employed");

		// Medical Plan Data
		CitizenPlan c7 = new CitizenPlan();
	
		c7.setCitizenName("Ram");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setPlaneStartDate(LocalDate.now());
		c7.setPlaneEndDate(LocalDate.now().plusMonths(6));
		c7.setBenefitAmt(7000.00);

		// Medical Plan Data

		CitizenPlan c8 = new CitizenPlan();
		
		c8.setCitizenName("Ramesh");
		c8.setGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
       c8.setDenialReason("Medical Income");

		// Medical Plan Data
		CitizenPlan c9 = new CitizenPlan();
		
		c9.setCitizenName("Punam");
		c9.setGender("Female");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setPlaneStartDate(LocalDate.now().minusMonths(4));
		c9.setPlaneEndDate(LocalDate.now().plusMonths(6));
		c9.setBenefitAmt(6000.00);
		c9.setTerminatedDate(LocalDate.now());
		c9.setTerminationRsn("Gov Job");

		// Employment Plan Data
		CitizenPlan c10 = new CitizenPlan();
		
		c10.setCitizenName("Ayush");
		c10.setGender("Male");
		c10.setPlanName("Employment");
		c10.setPlanStatus("Approved");
		c10.setPlaneStartDate(LocalDate.now());
		c10.setPlaneEndDate(LocalDate.now().plusMonths(6));
		c10.setBenefitAmt(6000.00);

		// Employment Plan Data

		CitizenPlan c11 = new CitizenPlan();
		
		c11.setCitizenName("Kundan");
		c11.setGender("Male");
		c11.setPlanName("Employment");
		c11.setPlanStatus("Denied");
        c11.setDenialReason("Employment Income");

		// Employment Plan Data
		CitizenPlan c12 = new CitizenPlan();
		
		c12.setCitizenName("Nanadani");
		c12.setGender("Female");
		c12.setPlanName("Employment");
		c12.setPlanStatus("Terminated");
		c12.setPlaneStartDate(LocalDate.now().minusMonths(4));
		c12.setPlaneEndDate(LocalDate.now().plusMonths(6));
		c12.setBenefitAmt(6000.00);
		c12.setTerminatedDate(LocalDate.now());
		c12.setTerminationRsn("Employed");

		List<CitizenPlan> data = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12);
		citizenInfo.saveAll(data);

	}

}
