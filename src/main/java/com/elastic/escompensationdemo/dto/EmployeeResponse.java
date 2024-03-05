package com.elastic.escompensationdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {
    private String id;
    private String country;
    private String education;
    private String primaryLocation;
    private String companyName;
    private String jobTitle;
    private String stockOrEquity;
    private String gender;
    private String actualHours;
    private String resignationPlan;
    private String happiness;
    private String healthInsuranceOffered;
    private Integer annualVacationInWeeks;
    private String experienceInCurrentJob;
    private Double totalCompensation;
    private String industryInCompany;
    private String employmentType;
    private String companyType;
    private String experienceInIndustry;
    private String bonusPay;
    private String companySize;
    private String jobLadder;
    private String jobLevel;
    private String timeStamp;
    private String requiredHoursPerWeek;
    private String basePay;
}
