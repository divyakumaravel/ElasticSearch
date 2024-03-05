package com.elastic.escompensationdemo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "compensation")
@Builder
public class Compensation {
    @Id
    private String id;
    @Field(type = FieldType.Text, name = "country")
    private String country;
    @Field(type = FieldType.Text, name = "education")
    private String education;
    @Field(type = FieldType.Text, name = "city")
    private String city;
    @Field(type = FieldType.Text, name = "companyName")
    private String companyName;
    @Field(type = FieldType.Text, name = "jobTitle")
    private String jobTitle;
    @Field(type = FieldType.Text, name = "jobTitle")
    private String stockOrEquity;
    @Field(type = FieldType.Text, name = "Gender")
    private String gender;
    @Field(type = FieldType.Text, name = "actualHours")
    private String actualHours;
    @Field(type = FieldType.Text, name = "resignationPlans")
    private String resignationPlan;
    @Field(type = FieldType.Text, name = "happiness")
    private String happiness;
    @Field(type = FieldType.Text, name = "healthInsuranceOffered")
    private String healthInsuranceOffered;
    @Field(type = FieldType.Text, name = "annualVacationInWeeks")
    private Integer annualVacationInWeeks;
    @Field(type = FieldType.Text, name = "experienceIncurrentJob")
    private String experienceInCurrentJob;
    @Field(type = FieldType.Double, name = "totalCompensation")
    private Double totalCompensation;
    @Field(type = FieldType.Text, name = "industryInCompany")
    private String industryInCompany;
    @Field(type = FieldType.Text, name = "employmentType")
    private String employmentType;
    @Field(type = FieldType.Text, name = "companyType")
    private String companyType;
    @Field(type = FieldType.Text, name = "experienceInIndustry")
    private String experienceInIndustry;
    @Field(type = FieldType.Text, name = "bonusPay")
    private String bonusPay;
    @Field(type = FieldType.Text, name = "companySize")
    private String companySize;
    @Field(type = FieldType.Text, name = "jobLadder")
    private String jobLadder;
    @Field(type = FieldType.Text, name = "jobLevel")
    private String jobLevel;
    @Field(type = FieldType.Date, name = "timeStamp")
    private String timeStamp;
    @Field(type = FieldType.Text, name = "requiredHoursPerWeek")
    private String requiredHoursPerWeek;
    @Field(type = FieldType.Integer, name = "basePay")
    private Integer basePay;
}
