package com.cybertek.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping
    public String getRequestMapping(){

        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Fatma")
    public String getRequestMapping2(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Fatma")
    public String getRequestMapping3(){
        return "home";
    }
    //@PostMapping("/fatma")
    @GetMapping("/fatma")
    public String getMappigEx(){
        return "home";
    }

    @GetMapping("/home/{name}")
    public String pathVariableEx(@PathVariable("name") String name){
        System.out.println("name is : " + name);
        return "home";
    }

    @GetMapping("/home/{name}/{email}")
    public String pathVariableEx2(@PathVariable("name")String name, @PathVariable("email")String email) {
        System.out.println("name is : " + name);
        System.out.println("email is: " + email);
        return "home";
    }


    @GetMapping("/home/course")
    public String requestParamEx(@RequestParam("course")String course){
        System.out.println("name is : " + course);
        return "home";
    }

    @GetMapping("/course")
    public String requestParamEx2(@RequestParam(value = "name", required = false,defaultValue = "Cybertek")String name){

        System.out.println(name);
        return "home";
    }




}
