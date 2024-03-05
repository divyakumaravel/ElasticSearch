package com.elastic.escompensationdemo.controller;

import com.elastic.escompensationdemo.dto.EmployeeResponse;
import com.elastic.escompensationdemo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
@AutoConfigureMockMvc(addFilters = false)
class EmployeeControllerTest {

    @MockBean
    EmployeeService employeeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnCompensationByCityAndTotalCompensation() throws Exception {
        List<EmployeeResponse> employeeResponses = List.of(
                EmployeeResponse.builder().id("1").build(),
                EmployeeResponse.builder().id("2").build());

        when(employeeService.findByCityAndCompensation(any(Pageable.class),
                eq("Manhattan"), eq(1000.0))).thenReturn(employeeResponses);

        mockMvc.perform(get("/employee?compensation=220000&city=Manhattan&sizePerPage=10")
                        .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void shouldReturnCompensationDetailsSortedByTimeStamp() throws Exception {
        List<EmployeeResponse> employeeResponses = List.of(
                EmployeeResponse.builder().id("1").build(),
                EmployeeResponse.builder().id("2").build());

        when(employeeService.findAllByPage(any(Pageable.class))).thenReturn(employeeResponses);

        mockMvc.perform(get("/sortedCompensations")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}