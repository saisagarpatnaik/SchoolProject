package com.schoolapplication.project.service;

import com.schoolapplication.project.entity.School;

import java.util.List;

public interface SchoolService {
    public School getSchool();

    public List<School> getSchoolAll();

    public School getSchoolId();

    public School getSchoolDetailbyId(long id);

    public School saveSchool(School s);

    public List<School> searchSchool(School s);

    public void deleteSchool(long id);

    public void updateSchool(School s);

}
