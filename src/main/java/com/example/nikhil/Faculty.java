package com.example.nikhil;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
@Data
@Entity
@Table(name="staff")
public class Faculty {
    @Id
    private int id;
    @Id
    private String subject;
    @Id
    private String name;
    @Id
    private String day;

    private String one;
    private String two;
    private String three;
    private String four;
    private String five;
    private String six;
}
