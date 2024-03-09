package com.elastic.escompensationdemo.service;

import com.elastic.escompensationdemo.dto.EmployeeResponse;
import com.elastic.escompensationdemo.model.Compensation;
import com.elastic.escompensationdemo.repository.CompensationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeService {
    private final CompensationRepository compensationRepository;

    @Autowired
    public EmployeeService(CompensationRepository compensationRepository) {
        this.compensationRepository = compensationRepository;
    }

    public List<EmployeeResponse> findAllByPage(Pageable pageable, Sort.Direction direction) {
        try {
            Page<Compensation> compensations = compensationRepository.findAll(pageable);
            List<Compensation> content = new ArrayList<>(compensations.getContent());
            if (direction.equals(Sort.Direction.DESC)) {
                content.sort((obj1, obj2) -> {
                    return Double.compare(obj2.getTotalCompensation(), obj1.getTotalCompensation());
                });
                return getEmployeeResponses(content);
            }
            content.sort(Comparator.comparingDouble(Compensation::getTotalCompensation));
            return getEmployeeResponses(content);
        } catch (Exception ex) {
            log.error("Exception occurred " + ex.getMessage());
            throw ex;
        }
    }

    public List<EmployeeResponse> findByCityAndCompensation(Pageable pageable, String city, Double totalCompensation) {
        try {
            Page<Compensation> compensations = compensationRepository.findByTotalCompensationAndCity(totalCompensation, city, pageable);
            return getEmployeeResponses(compensations.getContent());
        } catch (Exception ex) {
            log.error("Exception occurred " + ex.getMessage());
            throw ex;
        }
    }

    private List<EmployeeResponse> getEmployeeResponses(List<Compensation> compensations) {
        log.info("Mapping compensation model to employee response");
        return compensations.stream().map(compensation -> EmployeeResponse.builder()
                .id(compensation.getId())
                .primaryLocation(compensation.getCity().equals("Other") ? "" : compensation.getCity()
                        + "," + compensation.getCountry())
                .education(compensation.getEducation())
                .companyName(compensation.getCity())
                .jobTitle(compensation.getJobTitle())
                .gender(compensation.getGender())
                .actualHours(compensation.getActualHours())
                .resignationPlan(compensation.getResignationPlan())
                .happiness(compensation.getHappiness())
                .healthInsuranceOffered(compensation.getHealthInsuranceOffered())
                .annualVacationInWeeks(compensation.getAnnualVacationInWeeks())
                .experienceInCurrentJob(compensation.getExperienceInCurrentJob())
                .totalCompensation(compensation.getTotalCompensation())
                .industryInCompany(compensation.getIndustryInCompany())
                .employmentType(compensation.getEmploymentType())
                .companyType(compensation.getCompanyType())
                .experienceInIndustry(compensation.getExperienceInIndustry())
                .companySize(compensation.getCompanySize())
                .jobLadder(compensation.getJobLadder())
                .jobLevel(compensation.getJobLevel())
                .timeStamp(compensation.getTimeStamp())
                .build()).collect(Collectors.toList());
    }
}
