package com.CurdApp.service;

import com.CurdApp.entity.Department;
import com.CurdApp.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartment();

    Department fetchDepatmentById(Long departmentid) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentid);

    Department updateDepartment(Long departmentid, Department department);

    Department fetchDepartmentByName(String departmentName);
}
