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
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classId;

    @Column
    private String className;

   /* @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "SchoolId")
    private School s;*/

}
