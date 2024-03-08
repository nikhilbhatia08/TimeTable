package com.example.nikhil;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyRepo frepo;
    public FacultyController(FacultyRepo frepo) {
        this.frepo = frepo;
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity CreateFaculty(@RequestBody Faculty fac) {
        int code = 0;
        String [] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (String day : days) {
            code = frepo.insertWithQuery(fac, day);
            if(code == 1) {
                continue;
            }
            else {
                code = -1;
                break;
            }
        }
        if(code == -1) {
            return ResponseEntity.status(409).body("Already Present");
        }
        return ResponseEntity.status(200).body("ok");
    }

    @GetMapping("/specific/{id}")
    @ResponseBody
    public Optional<SendFaculty> getParticular(@PathVariable("id") int id) {
        SendFaculty send = new SendFaculty(this.frepo.queryForFaculty(id));
        return Optional.of(send);
    }
}
