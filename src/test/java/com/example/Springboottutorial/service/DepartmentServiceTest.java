package com.example.Springboottutorial.service;

import com.example.Springboottutorial.entity.Department;
import com.example.Springboottutorial.repository.DepartmentRepository;
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

    // this is mocked
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Software")
                .departmentAddress("Patna")
                .departmentCode("Comp")
                .departmentId(100L)
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Software"))
                .thenReturn(department);

    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
       String departmentName = "Software";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}