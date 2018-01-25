package com.onji.repository;

import com.onji.entity.BugsWeight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugsWeightRepository extends JpaRepository<BugsWeight, Integer> {
}
