package com.onji.service;

import com.onji.dto.Employee;
import com.onji.dto.Project;
import com.onji.entity.Entry;
import com.onji.entity.ProjectMember;
import com.onji.entity.Role;
import com.onji.enumration.EmployeeAssessment;
import com.onji.form.ProjectMemberForm;
import com.onji.repository.EntryRepository;
import com.onji.repository.ProjectMemberRepository;
import com.onji.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectMemberService {
    private final ProjectMemberRepository projectMemberRepository;
    private final RoleRepository roleRepository;
    private final EntryRepository entryRepository;
    private final UserRuntimeService userRuntimeService;

    public List<Employee> searchEmployees(ProjectMemberForm projectMemberForm) {
        Role role = roleRepository.getByName(projectMemberForm.getRole());
        return projectMemberRepository.findByRole(role).stream()
                .map(ProjectMember::getUser)
                .distinct()
                .map(x -> {
                    List<Entry> entries = entryRepository.findByUserId(x.getId());
                    Integer totalTime = entries.size() == 0 ? -1 : entries.stream()
                            .mapToInt(Entry::getActualHour)
                            .sum();

                    Map<Integer, Integer> totalTimes = entries.stream()
                            .collect(Collectors.groupingBy(Entry::getProjectId))
                            .entrySet().stream()
                            .collect(Collectors.toMap(Map.Entry::getKey, y -> y.getValue().size() == 0 ? -1 : y.getValue().stream()
                                    .mapToInt(Entry::getActualHour).sum()));

                    List<ProjectMember> projectMembers = projectMemberRepository.findByUserId(x.getId());
                    List<Project> projects = projectMembers.stream()
                            .map(y -> new Project(
                                    y.getProject().getName(),
                                    totalTimes.get(y.getProject().getId()),
                                    y.getProject().getPlantStartDate().toLocalDateTime(),
                                    y.getProject().getPlantEndDate().toLocalDateTime(),
                                    EmployeeAssessment.A))
                            .collect(Collectors.toList());

                    UserRuntimeService.ExtendedUser extendedUser = userRuntimeService.getExtendedEmployee(x);
                    Integer year = -1;
                    String location = "";
                    if (extendedUser != null) {
                        year = extendedUser.getBirth() == null ? -1 : Period.between(extendedUser.getBirth().toLocalDate(), LocalDateTime.now().toLocalDate()).getYears();
                        location = extendedUser.getLocation() == null ? "" : extendedUser.getLocation();
                    }
                    return new Employee(x.getUserName(), year, totalTime, location, projects);
                })
                .collect(Collectors.toList());
    }
}
