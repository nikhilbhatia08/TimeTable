package com.example.nikhil;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name="class")
public class Clss {
    @Id
    private int classyr;
    @Id
    private String branch_sec;
    @Id
    private String day;

//    private String one;
//    private String two;
//    private String three;
//    private String four;
//    private String five;
//    private String six;
}
