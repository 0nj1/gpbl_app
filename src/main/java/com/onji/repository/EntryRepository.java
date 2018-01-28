package com.onji.repository;

import com.onji.entity.Entry;
import com.onji.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Integer> {
    List<Entry> findByUserId(Integer userId);
    List<Entry> findByProjectIdAndUserId(Integer projectId, Integer userId);
}
