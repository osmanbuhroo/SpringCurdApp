package com.CurdApp.service;

import com.CurdApp.entity.Department;
import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartment();

    Department fetchDepatmentById(Long departmentid);

    void deleteDepartmentById(Long departmentid);

    Department updateDepartment(Long departmentid, Department department);
}
