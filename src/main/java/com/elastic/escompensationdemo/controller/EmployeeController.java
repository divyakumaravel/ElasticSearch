package com.elastic.escompensationdemo.controller;

import com.elastic.escompensationdemo.dto.EmployeeResponse;
import com.elastic.escompensationdemo.enumerators.SortField;
import com.elastic.escompensationdemo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<EmployeeResponse> findByCityAndCompensation(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "2") int sizePerPage,
                                                            @RequestParam Double compensation,
                                                            @RequestParam String city) {
        log.info("Fetching compensation data by total compensation and city");
        Pageable pageable = PageRequest.of(page, sizePerPage);
        return employeeService.findByCityAndCompensation(pageable, city, compensation);
    }

    @GetMapping("/sortedCompensations")
    public List<EmployeeResponse> findAll(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "2") int sizePerPage,
                                          @RequestParam(defaultValue = "TIMESTAMP") SortField sortField,
                                          @RequestParam(defaultValue = "ASC") Sort.Direction sortDirection) {
        log.info("Fetching compensation data sorted by timestamp");
        Pageable pageable = PageRequest.of(page, sizePerPage, Sort.by(sortDirection, sortField.getDatabaseFieldName()));
        return employeeService.findAllByPage(pageable);
    }
}
