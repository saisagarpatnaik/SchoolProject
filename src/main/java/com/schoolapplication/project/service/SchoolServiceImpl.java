package com.schoolapplication.project.service;

import com.schoolapplication.project.controller.SchoolController;
import com.schoolapplication.project.dao.ClassesRepository;
import com.schoolapplication.project.dao.SchoolRepository;
import com.schoolapplication.project.dao.StudentRepository;
import com.schoolapplication.project.entity.School;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {

    private static final Logger log = LoggerFactory.getLogger(SchoolController.class);
    @Autowired
    SchoolRepository repo;


    @Autowired
    StudentRepository repo1;

    @Autowired
    ClassesRepository repo2;

    @Override
    public School getSchool() {
        School s = new School();
        s.setSchoolId(1);
        s.setSchoolName("Tarun");
        s.setSchoolAddress("NJIT");
        s.setSchoolGPA(3);
        return s;
    }

    @Override
    public List<School> getSchoolAll() {
        List<School> ls = (List<School>) repo.findAll();
        return ls;
    }

    @Override
    public School getSchoolId() {
        Optional<School> is = repo.findById(1l); //might find a record and may not find a record
        School s = is.get(); //Just one record
        if (s.getSchoolGPA() < 3) {
            log.info("U do not qualify");
        } else {
            log.info("Qualified");
        }

        //Need to write a logic on if the student has less gpa
        return is.get();
    }

    @Override
    public School getSchoolDetailbyId(long id) {
        Optional<School> is = repo.findById(id);
        return is.get();
    }


    @Override
    public School saveSchool(School s) {
        School s1 = repo.save(s);
        return s1;
    }

    @Override
    public List<School> searchSchool(School s) {
        List<School> searchResult = null;

        if (!StringUtils.isEmpty(s.getSchoolName())) {
            searchResult = repo.findBySchoolName(s.getSchoolName());
            log.info(searchResult.toString());

        } else if (!StringUtils.isEmpty(s.getSchoolAddress())) {
            searchResult = repo.findBySchoolAddress(s.getSchoolAddress());
            log.info(searchResult.toString());
        } else if (!StringUtils.isEmpty(String.valueOf(s.getSchoolGPA()))) {
            searchResult = repo.findBySchoolGPA(s.getSchoolGPA());
            log.info(searchResult.toString());
        } else {
            log.info("Please post again and check values");
        }
        return searchResult;
    }

    @Override
    public void deleteSchool(long id) {
        Optional<School> s2 = repo.findById(id);
        repo.delete(s2.get());
    }

    @Override
    public void updateSchool(School s) {
        Optional<School> school = null;
        try {
            school = repo.findById(Long.valueOf(s.getSchoolId()));
            School school1 = school.get();
            school1.setSchoolGPA(s.getSchoolGPA());
            school1.setSchoolAddress(s.getSchoolAddress());
            school1.setSchoolName(s.getSchoolName());
            repo.save(school1);
        } catch (Exception e) {
            log.info("Its an exception error");
        }
    }

}
