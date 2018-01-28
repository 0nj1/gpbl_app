package com.onji.service;

import com.onji.entity.BugsWeight;
import com.onji.entity.Entry;
import com.onji.entity.Project;
import com.onji.entity.Ticket;
import com.onji.enumration.EmployeeAssessment;
import com.onji.repository.EntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeAssessmentService {

    private final EntryRepository entryRepository;

    // calculate for rating of employee(ultimate tekitou ver.)
    // ave = 3.25
    // threshold -> 1.5, 3.0, 4.0

    public EmployeeAssessment calculate(Project project, Integer userId) {
        List<Entry> entries = entryRepository.findByProjectIdAndUserId(project.getId(), userId);
        if (entries.size() == 0) return null;

        try {
            double average = entries.stream()
                    .mapToInt(Entry::getActualHour)
                    .average().getAsDouble();

            double bugAve = entries.stream()
                    .map(Entry::getTicket)
                    .map(Ticket::getBugsWeight)
                    .mapToInt(BugsWeight::getRelatedId)
                    .average().getAsDouble();

            double criterion = average / bugAve;

            if (criterion < 1.5) return EmployeeAssessment.S;
            else if (criterion < 2.5) return EmployeeAssessment.A;
            else if (criterion < 3.75) return EmployeeAssessment.B;
            else return EmployeeAssessment.C;

        } catch (EntityNotFoundException e) {
            return null;
        }

    }
}
