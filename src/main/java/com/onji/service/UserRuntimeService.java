package com.onji.service;

import com.onji.entity.User;
import com.onji.util.DateUtil;
import com.opencsv.CSVReader;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserRuntimeService {
    @RequiredArgsConstructor
    @Getter
    static public class ExtendedUser {
        private final LocalDateTime birth;
        private final String location;
    }

    private Map<String, ExtendedUser> userHashMap = new HashMap<>();

    @PostConstruct
    public void readDataOnMemory() {
        Resource resource = new ClassPathResource("/data/employee_personaldata.csv", getClass());
        try (Reader reader = new InputStreamReader(resource.getInputStream())) {
            CSVReader csvReader = new CSVReader(reader);
            String[] lines;
            Integer n = 0;
            while ((lines = csvReader.readNext()) != null) {
                n++;
                if (lines.length == 0 || n == 1) {
                    continue;
                }
                LocalDateTime birth = lines.length >= 2 ? DateUtil.format(lines[1]) : null;
                String location = lines.length >= 3 ? lines[2] : null;
                userHashMap.put(lines[0], new ExtendedUser(birth, location));
            }
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ExtendedUser getExtendedEmployee(User user) {
        return userHashMap.get(user.getMemberCode());
    }
}
