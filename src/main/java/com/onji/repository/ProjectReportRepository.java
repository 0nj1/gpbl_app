package com.onji.repository;

import com.onji.entity.ProjectReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectReportRepository extends JpaRepository<ProjectReport, Integer> {
}
