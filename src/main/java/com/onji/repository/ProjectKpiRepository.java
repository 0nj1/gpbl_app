package com.onji.repository;

import com.onji.entity.ProjectKpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectKpiRepository extends JpaRepository<ProjectKpi, Integer> {
}
