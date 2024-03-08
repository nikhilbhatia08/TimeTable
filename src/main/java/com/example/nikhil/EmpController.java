package com.example.nikhil;

import org.aspectj.weaver.ast.Instanceof;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class EmpController {
    private final EmpRepo emp;
    public EmpController(EmpRepo emp) {
        this.emp = emp;
    }
    @GetMapping("/employees")
    @ResponseBody
    public Iterable<Employee> findAllEmployees() {
        return this.emp.findAll();
    }

    @PostMapping("/getemployee")
    @ResponseBody
    public Optional<Employee> getH(@NotNull @RequestBody Employee emp) {
//        System.out.println(((Object)emp.getId()).getClass());
//        System.out.println(emp.getId());
        var byId = this.emp.findById((int)emp.getId());
        //System.out.println(byId);
        return byId;
    }

    @PostMapping("/gethello")
    @ResponseBody
    public Optional<Employee> getn(@NotNull @RequestBody Employee emp) {
        System.out.println(emp.getName());
        return this.emp.findByName(emp.getName());
    }
}
