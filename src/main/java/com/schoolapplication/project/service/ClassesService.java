package com.schoolapplication.project.service;

import com.schoolapplication.project.entity.Classes;

import java.util.List;

public interface ClassesService {

    public Classes getClasses();

    public List<Classes> getClassesAll();

    public Classes getClassesId();

    public Classes saveClasses(Classes c);

    public List<Classes> searchClasses(Classes c);

    public void deleteClasses(Classes c);

    public Classes getClassesDetailbyId(Long id);

    public void updateClasses(Classes s);

}
