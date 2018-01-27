package com.onji.repository;

import com.onji.entity.RootCause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RootCauseRepository extends JpaRepository<RootCause, Integer> {
}
