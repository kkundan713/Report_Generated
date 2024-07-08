package com.spring.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spring.project.entity.CitizenPlan;
@EnableJpaRepositories
public interface CitizenInfoRepo extends JpaRepository<CitizenPlan, Integer> {
	
	@Query("SELECT  DISTINCT(planName) from CitizenPlan")
	public List<String> getPlanNames();
	@Query("SELECT  DISTINCT(planStatus) from CitizenPlan")
	public List<String> getPlanStatus();

}
