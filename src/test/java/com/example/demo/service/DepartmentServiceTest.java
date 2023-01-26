package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentId(1L)
                .departmentCode("IT-01")
                .departmentAddress("Hyderabad")
                .departmentName("IT")
                .build();

        Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);
    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShoouldFound(){
        String departmentName = "IT";

        Department found = departmentService.fetchDepartmentByDepartmentName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());

    }
}