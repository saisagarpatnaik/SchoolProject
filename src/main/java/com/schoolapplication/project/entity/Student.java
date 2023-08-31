package com.schoolapplication.project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column
    private String studentName;

    @Column
    private float studentGPA;

    @ManyToOne //(cascade = CascadeType.ALL)
    @JoinColumn(name = "classId")
    private Classes c;

    @ManyToOne //(cascade = CascadeType.ALL)
    @JoinColumn(name = "schoolId")
    private School s;
}
