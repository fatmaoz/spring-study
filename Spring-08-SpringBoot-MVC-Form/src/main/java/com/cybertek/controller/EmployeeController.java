package com.cybertek.controller;

import com.cybertek.datagenerator.DataGenerator;
import com.cybertek.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;

@Controller
public class EmployeeController {

    @GetMapping("/employee/register")
    public String employeeCreate(Model model){
        model.addAttribute("employee", new Employee());

        model.addAttribute("stateList", DataGenerator.getStateList());
        return "employee/employee-create";
    }

    @RequestMapping(value = "/employee/list", method =  RequestMethod.POST)
    public String employeeList(@ModelAttribute("employee") Employee employee, Model model){

        model.addAttribute("employeeList", Arrays.asList(employee));

        int birthYear = LocalDate.parse(employee.getBirthday()).getYear();
        model.addAttribute("age",LocalDate.now().getYear() - birthYear);

        return "employee/employee-list";
    }


}
