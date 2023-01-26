package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @MockBean
    private DepartmentService departmentService;

    @Autowired
    private MockMvc mockMvc;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Hyderabad")
                .departmentCode("IT01")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("IT")
                .departmentAddress("Hyderabad")
                .departmentCode("IT01")
                .build();
        Mockito.when(departmentService.saveDepartment((inputDepartment)))
                .thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"departmentName\":\"IT\",\"departmentAddress\":\"Hyderabad\",\"departmentCode\":\"IT01\"}")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk()
        ).andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));


    }
}