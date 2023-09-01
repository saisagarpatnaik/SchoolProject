package com.schoolapplication.project.service;

import com.schoolapplication.project.dao.ClassesRepository;
import com.schoolapplication.project.entity.Classes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ClassesServiceImpl implements ClassesService {
    private static final Logger log = LoggerFactory.getLogger(ClassesServiceImpl.class);

    @Autowired
    ClassesRepository repo2;

    @Override
    public Classes getClasses() {
        Classes c = new Classes();
        c.setClassId(1);
        c.setClassName("Grade 4");
        return c;
    }

    @Override
    public List<Classes> getClassesAll() {
        List<Classes> ls = (List<Classes>) repo2.findAll();
        return ls;
    }

    @Override
    public Classes getClassesId() {
        Optional<Classes> cls = repo2.findById(1l); //might find a record and may not find a record
        Classes c1 = cls.get(); //Just one record
        return cls.get();
    }

    @Override
    public Classes saveClasses(Classes c) {
        Classes c1 = repo2.save(c);
        return c1;
    }

    @Override
    public Classes getClassesDetailbyId(Long id) {
        Optional<Classes> classes = repo2.findById(id);
        return classes.get();
    }

    @Override
    public void updateClasses(Classes c) {

        Optional<Classes> classes = null;
        try {
            classes = repo2.findById(Long.valueOf(c.getClassId()));
            Classes classes1 = classes.get();
            classes1.setClassName(c.getClassName());
            repo2.save(classes1);
        } catch (Exception e) {
            log.info("Its an exception error");
        }
    }

    @Override
    public List<Classes> searchClasses(Classes c) {
        List<Classes> searchResult = null;

        if (!StringUtils.isEmpty(c.getClassName())) {
            searchResult = repo2.findByClassName(c.getClassName());
            log.info(searchResult.toString());

        } else {
            log.info("Please post again and check values");
        }
        return searchResult;
    }

    @Override
    public void deleteClasses(Classes c1) {

        repo2.delete(c1);

    }
}

