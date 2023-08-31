package com.schoolapplication.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Data
@ToString
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int schoolId;

    @Column
    private String schoolName;

    @Column
    private String schoolAddress;

    @Column
    private float schoolGPA;

}
