package com.terzocloud.employeez.controller;

import com.terzocloud.employeez.dto.EmployeeDto;
import com.terzocloud.employeez.entity.Department;
import com.terzocloud.employeez.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentRestController {
    DepartmentService departmentService;
    @Autowired
    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department")
    public List<Department> findAll(){
        List<Department> departments = departmentService.findAll();
        return departments;
    }

    @GetMapping("/department/{departmentId}")
    public Department findById(@PathVariable Integer departmentId){
        return departmentService.findById(departmentId);
    }

}
