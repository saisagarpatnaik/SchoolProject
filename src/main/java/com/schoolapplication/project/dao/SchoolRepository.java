package com.schoolapplication.project.dao;

import com.schoolapplication.project.entity.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {
    public List<School> findBySchoolName(String s1);

    public List<School> findBySchoolAddress(String s2);
    public List<School> findBySchoolGPA(float s3);
}
