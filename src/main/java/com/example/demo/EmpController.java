package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmpController {

    @Value("${app.message}")
    private String message;

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        System.out.println("name .123..."+ employee);
        return employee;
    }

    @GetMapping
    public String findAll() {
        System.out.println("name ...." + message);
        return message;
    }

    private void test(){
        System.out.println("TEST 111");
    }

}
