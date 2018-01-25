package com.onji.repository;

import com.onji.entity.MembersReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersReportRepository extends JpaRepository<MembersReport, Integer> {
}
