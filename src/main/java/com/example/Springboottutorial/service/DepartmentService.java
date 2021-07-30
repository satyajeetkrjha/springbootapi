package com.example.Springboottutorial.service;

import com.example.Springboottutorial.entity.Department;
import  java.util.List;
public interface DepartmentService {

   public Department saveDepartment(Department department);

   public  List<Department> fetchDepartmentList();
}
