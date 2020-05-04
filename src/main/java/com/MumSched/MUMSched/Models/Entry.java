package com.MumSched.MUMSched.Models;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long Id;
    String name;
    LocalDate date;

    public Long getId() {
        return Id;
    }

    public Student getStudent() {
        return student;
    }

    @OneToOne(mappedBy = "entry", fetch = FetchType.LAZY)
    private Student student;

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
