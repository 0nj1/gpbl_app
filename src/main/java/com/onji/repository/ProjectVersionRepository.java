package com.onji.repository;

import com.onji.entity.ProjectVersion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectVersionRepository extends JpaRepository<ProjectVersion, Integer> {
}
