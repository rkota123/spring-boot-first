package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   Department saveDepartment(Department department);

   List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department);

    Department fetchDepartmentByDepartmentName(String departmentName);
}
