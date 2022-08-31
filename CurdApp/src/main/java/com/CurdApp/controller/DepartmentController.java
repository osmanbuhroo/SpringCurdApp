package com.CurdApp.controller;

import com.CurdApp.entity.Department;
import com.CurdApp.exception.DepartmentNotFoundException;
import com.CurdApp.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController

public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
  private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "helloworld";
    }

    @PostMapping("/savedepartments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        logger.info("Inside saveDepartment of Department Controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/fetchdepartment")
    public List<Department> fetchDepartment() {
        logger.info("Inside fetchdepartment of Department Controller");
        return departmentService.fetchDepartment();
    }

    @GetMapping("/fetchdepartmentbyId/{id}")
    public Department fetchDepatmentById(@PathVariable("id") Long departmentid) throws DepartmentNotFoundException {
        logger.info("Inside fetchdepartmentbyId of Department Controller");
        return departmentService.fetchDepatmentById(departmentid);
    }

    @DeleteMapping("/deletedepartmentsbyid/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentid) {
        logger.info("Inside deletedepartmentsbyid of Department Controller");
        departmentService.deleteDepartmentById(departmentid);
        return "deleted sucessfully............!";
    }

    @PutMapping("/updatedepartmentbyid/{id}")
    public Department updateDepartment(@Valid @PathVariable("id") Long departmentid, @RequestBody Department department) {
        logger.info("Inside updatedepartmentbyid of Department Controller");
        return departmentService.updateDepartment(departmentid, department);
    }
    @GetMapping("/fetchDepartmentByName")
    public  Department fetchDepartmentByName(@PathVariable String departmentName){
        logger.info("Inside fetchDepartmentByName of Department Controller");
        return  departmentService.fetchDepartmentByName(departmentName);
    }
}
