package com.example.nikhil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping (path="/get", produces = "application/json")
@CrossOrigin(origins = "*")
public class HelloController {
    @ResponseBody
    public String Hello() {
        return "Hello World";
    }

    @PostMapping("/send")
    @ResponseBody
    public ResponseEntity<Person> see(@RequestBody Person p) {
        Person p2 = new Person();
        p2.setName(p.getName());
        p2.setAge(p.getAge());
        return ResponseEntity.status(600).body(p2);
    }

    @GetMapping(path="/details")
    @ResponseBody
    public Person See() {
        Person p = new Person();
        p.setName("Nikhil Bhatia");
        p.setAge(18);
        return p;
    }
}
