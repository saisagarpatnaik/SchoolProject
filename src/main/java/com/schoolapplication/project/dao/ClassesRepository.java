package com.schoolapplication.project.dao;

import com.schoolapplication.project.entity.Classes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesRepository extends CrudRepository<Classes, Long> {

    public List<Classes> findByClassName(String s1);

}
