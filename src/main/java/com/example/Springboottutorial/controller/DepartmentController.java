package com.example.Springboottutorial.controller;

import com.example.Springboottutorial.entity.Department;
import com.example.Springboottutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService ;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
      LOGGER.info("Inside Save department Controller");
      return departmentService.saveDepartment(department);
   }

   @GetMapping("/departments")
   public List<Department> fetchDepartmentList(){
       LOGGER.info("Inside fetchdepartmentList department Controller");
        return departmentService.fetchDepartmentList();
   }

   @GetMapping("/departments/{id}")
   public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
      return departmentService.fetchDepartmentById(departmentId);
   }

   @DeleteMapping("/departments/{id}")
   public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
      return "Department Deleted Successfully";
   }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId,department);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
      return departmentService.fetchDepartmentByName(departmentName);
    }



}
