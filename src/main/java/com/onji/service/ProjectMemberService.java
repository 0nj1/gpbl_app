package com.onji.service;

import com.onji.entity.User;
import com.onji.form.ProjectMemberForm;
import com.onji.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@RequiredArgsConstructor
@Service
public class ProjectMemberService {
    private final UserRepository userRepository;

    public Page<User> searchProjectMembers(ProjectMemberForm projectMemberForm, Pageable pageable) {
        
    }
}
