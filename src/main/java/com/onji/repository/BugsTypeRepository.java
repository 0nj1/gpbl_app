package com.onji.repository;

import com.onji.entity.BugsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugsTypeRepository extends JpaRepository<BugsType, Integer> {
}
