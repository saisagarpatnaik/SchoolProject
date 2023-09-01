package com.schoolapplication.project.service;

import com.schoolapplication.project.entity.Student;

import java.util.List;

public interface StudentService {

    public Student getStudent();

    public List<Student> getStudentAll();

    public Student getStudentId();

    public Student saveStudent(Student s);

    public Student getStudentDetailbyId(Long id);

    public List<Student> searchStudent(Student s);

    public void deleteStudent(Student s);

    public void updateStudent(Student s);

}
