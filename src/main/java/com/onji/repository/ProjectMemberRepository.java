package com.onji.repository;

import com.onji.entity.ProjectMember;
import com.onji.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Integer> {
    List<ProjectMember> findByRole(Role role);
    List<ProjectMember> findByUserId(Integer userId);
}
