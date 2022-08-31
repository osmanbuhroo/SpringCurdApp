package com.CurdApp.service;

import com.CurdApp.entity.Department;
import com.CurdApp.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private  DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department=
                Department.builder()
                .departmentName("IT")
                .departmentAddress("kashmir")
                .departmentCode(7009)
                .departmentId(1L)
                .build();
        Mockito.when(departmentRepository.findByDepartmentName("IT"))
                .thenReturn(department);
    }
    @Test
    @DisplayName("Get Data Based on Valid Department Name")
    public  void whenValidDepartment_thenDepartmentShouldFound(){
        String departmentName ="IT";
        Department found=
                departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }

}