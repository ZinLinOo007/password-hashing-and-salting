package com.example.springsecuritymaster.controller;

import com.example.springsecuritymaster.dao.DepartmentDao;
import com.example.springsecuritymaster.ds.Department;
import com.example.springsecuritymaster.security.annotation.departments.IsDepartmentsCreate;
import com.example.springsecuritymaster.security.annotation.departments.IsDepartmentsDelete;
import com.example.springsecuritymaster.security.annotation.departments.IsDepartmentsRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentDao departmentDao;


    @IsDepartmentsRead
    @GetMapping("/departments")
    public ModelAndView modelAndView(){

        return new ModelAndView("departments","departments",departmentDao.findAll());
    }

    @IsDepartmentsCreate
    @GetMapping("/create-department")
    public String createDepartment(Model model){
        model.addAttribute("department",new Department());
        return "department-form";
    }


    @IsDepartmentsCreate
    @PostMapping("/create-department")
    public String saveDepartment(@Valid Department department, BindingResult result){
        if (result.hasErrors()){
            return "department-form";
        }
        departmentDao.save(department);

        return "redirect:/departments";
    }


    @IsDepartmentsDelete
    @GetMapping("/departments/delete")
    public String deleteDepartment(@RequestParam("id") int id){
        departmentDao.deleteById(id);
        return "redirect:/departments";
    }
}
