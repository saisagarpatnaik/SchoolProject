package com.schoolapplication.project.dao;

import com.schoolapplication.project.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    public List<Student> findByStudentName(String s1);

}
