package com.onji.repository;

import com.onji.entity.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleUserRepository extends JpaRepository<RoleUser, Integer> {
}
