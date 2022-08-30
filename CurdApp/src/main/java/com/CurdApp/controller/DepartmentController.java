package com.CurdApp.controller;

import com.CurdApp.entity.Department;
import com.CurdApp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "helloworld";
    }

    @PostMapping("/savedepartments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/fetchdepartment")
    public List<Department> fetchDepartment() {
        return departmentService.fetchDepartment();
    }

    @GetMapping("/fetchdepartmentbyId/{id}")
    public Department fetchDepatmentById(@PathVariable("id") Long departmentid) {
        return departmentService.fetchDepatmentById(departmentid);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentid) {
        departmentService.deleteDepartmentById(departmentid);
        return "deleted sucessfully............!";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentid, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentid, department);
    }
}
