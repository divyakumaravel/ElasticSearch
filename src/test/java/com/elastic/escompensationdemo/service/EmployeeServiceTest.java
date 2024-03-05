package com.elastic.escompensationdemo.service;

import com.elastic.escompensationdemo.dto.EmployeeResponse;
import com.elastic.escompensationdemo.model.Compensation;
import com.elastic.escompensationdemo.repository.CompensationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    EmployeeService employeeService;
    @Mock
    private CompensationRepository compensationRepository;

    @BeforeEach
    void init() {
        employeeService = new EmployeeService(compensationRepository);
    }

    @Test
    void testFindAllByPage() {

        Pageable pageable = PageRequest.of(0, 10);

        List<Compensation> compensations = List.of(
                Compensation.builder()
                        .id("1")
                        .city("City")
                        .build()
        );

        Page<Compensation> mockPage = new PageImpl<>(compensations);

        when(compensationRepository.findAll(pageable)).thenReturn(mockPage);

        List<EmployeeResponse> result = employeeService.findAllByPage(pageable);

        assertThat(result).isNotNull();
        assertThat(result).hasSize(1);
    }
}
