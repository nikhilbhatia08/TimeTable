package com.example.nikhil;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/upload")
public class ClassController {
    private ClassRepo clsrepo;
    private FacultyRepo frepo;

    public ClassController(ClassRepo clsrepo, FacultyRepo frepo) {
        this.clsrepo = clsrepo;
        this.frepo = frepo;
    }

    @PostMapping("/createclass")
    public void createClass(@RequestBody Clss Class) {
        String [] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for(int i = 0; i < days.length; i++) {
            this.clsrepo.insertQuery(Class, days[i]);
        }
    }

    @PostMapping("/details/{classyr}/{branch_sec}")
    public void UpdateDetails(@PathVariable("classyr")int classyr, @PathVariable("branch_sec")String branch_sec, @RequestBody Week week){
        ArrayList<Day> arr = week.getWeek();
        System.out.println(classyr);
        System.out.println(branch_sec);
        for(int i = 0; i < arr.size(); i++) {
            //System.out.println(arr.get(i));
            String day = arr.get(i).getDay();
            String one = arr.get(i).getOne();
            String two = arr.get(i).getTwo();
            String three = arr.get(i).getThree();
            String four = arr.get(i).getFour();
            String five = arr.get(i).getFive();
            String six = arr.get(i).getSix();
            this.clsrepo.UpdateQuery(day, classyr, branch_sec, one, two, three, four, five, six);
            this.frepo.UpdateQuery(one, day, classyr, branch_sec, "one");
            this.frepo.UpdateQuery(two, day, classyr, branch_sec, "two");
            this.frepo.UpdateQuery(three, day, classyr, branch_sec, "three");
            this.frepo.UpdateQuery(four, day, classyr, branch_sec, "four");
            this.frepo.UpdateQuery(five, day, classyr, branch_sec, "five");
            this.frepo.UpdateQuery(six, day, classyr, branch_sec, "six");
        }
    }
}
