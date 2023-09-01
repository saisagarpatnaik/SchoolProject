package com.schoolapplication.project.service;

import com.schoolapplication.project.dao.ClassesRepository;
import com.schoolapplication.project.dao.SchoolRepository;
import com.schoolapplication.project.dao.StudentRepository;
import com.schoolapplication.project.entity.Classes;
import com.schoolapplication.project.entity.School;
import com.schoolapplication.project.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentRepository repo3;

    @Autowired
    ClassesRepository repo2;

    @Autowired
    SchoolRepository repo;

    @Override
    public Student getStudent() {
        Student student = new Student();
        student.setStudentId(1);
        student.setStudentName("SaiSagar");
        student.setStudentGPA(3.5f);
        return student;
    }

    @Override
    public List<Student> getStudentAll() {
        List<Student> student = (List<Student>) repo3.findAll();
        return student;
    }

    @Override
    public Student getStudentId() {
        Optional<Student> student = repo3.findById(1l); //might find a record and may not find a record
        Student s1 = student.get(); //Just one record
        return student.get();
    }

    @Override
    public Student saveStudent(Student s) {
        School school = s.getS();
        Classes classes = s.getC();
        long l = school.getSchoolId();
        long c = classes.getClassId();
        Optional<School> s2 = repo.findById(l);
        Optional<Classes> c2 = repo2.findById(c);
        if (s.getStudentGPA() < s2.get().getSchoolGPA()) {
            log.info("The GPA is too low to get admission to the college");
            return null;
        } else {
            Student s1 = repo3.save(s);
            s.setS(s2.get());
            s.setC(c2.get());
            log.info("You Qualify for the school");
            return s1;
        }
    }

    @Override
    public Student getStudentDetailbyId(Long id) {
        Optional<Student> student = repo3.findById(id);
        return student.get();
    }

    @Override
    public List<Student> searchStudent(Student s) {
        List<Student> searchResult = null;

        if (!StringUtils.isEmpty(s.getStudentName())) {
            searchResult = repo3.findByStudentName(s.getStudentName());
            log.info(searchResult.toString());

        } else {
            log.info("Please post again and check values");
        }
        return searchResult;
    }

    @Override
    public void deleteStudent(Student s) {
        repo3.delete(s);
    }

    @Override
    public void updateStudent(Student s) {
        Optional<Student> student = null;
        try {
            student = repo3.findById(Long.valueOf(s.getStudentId()));
            Student student1 = student.get();
            student1.setStudentName(s.getStudentName());
            student1.setStudentGPA(s.getStudentGPA());
            repo3.save(student1);
        } catch (Exception e) {
            log.info("Its an exception error");
        }
    }
}
