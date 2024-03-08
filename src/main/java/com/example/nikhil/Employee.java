package com.example.nikhil;
import jakarta.persistence.Column;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;
@Data
@Entity
@Table(name = "company")
public class Employee {
    @jakarta.persistence.Id
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
}
