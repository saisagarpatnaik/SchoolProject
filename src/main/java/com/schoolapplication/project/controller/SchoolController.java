package com.schoolapplication.project.controller;

import com.schoolapplication.project.constants.SchoolConstants;
import com.schoolapplication.project.entity.School;
import com.schoolapplication.project.service.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@authorSai
 */

@RestController
public class SchoolController {

    private static final Logger log = LoggerFactory.getLogger(SchoolController.class);
    @Autowired
    SchoolService schoolService;

    /* A get Method to use Test Data
    No need to connect with the db, the data is already embedded in Service
     */


    @GetMapping(SchoolConstants.GETSCHOOL)
    public School getSchool() {
        log.info("Welcome to School");
        //log.info("Welcome to School");
        School s1 = schoolService.getSchool();
        return s1;
    }

    /*
    This will get all the data for the specific repository
     */

    @GetMapping(SchoolConstants.GETSCHOOLALL) //Get all data of school from the database
    public List<School> getSchoolAll() {
        log.info("Welcome to School");
        List<School> s1 = schoolService.getSchoolAll();
        return s1;
    }

    /*
    This will get the data for a speific record id, it is for testing only as the id is hard coded in service
    */

    @GetMapping(SchoolConstants.GETSCHOOLID)
    public School getSchoolId() {
        log.info("Lets see whether you Qualify to be in the School");
        School s1 = schoolService.getSchoolId();
        return s1;
    }

    /*
    Get a specific record with the id
     */
    @GetMapping(SchoolConstants.GETSCHOOLDETAILID)
    public School getSchoolDetailbyId(@PathVariable long id) {
        School s1 = schoolService.getSchoolDetailbyId(id);
        return s1;
    }

    /*
This is to save to db
 */
    @PostMapping(SchoolConstants.SAVESCHOOL)
    public School saveSchool(@RequestBody School s) {
        School s1 = schoolService.saveSchool(s);
        log.info("Are you going to School");
        log.info(s1.toString());
        return s1;
    }

    /*
This is to search school with specific data
 */
    @PostMapping(SchoolConstants.SEARCHSCHOOL)
    public List<School> searchSchool(@RequestBody School s) {
        List<School> s1 = schoolService.searchSchool(s);
        return s1;
    }

    /*
This is to delete a record
 */
    @DeleteMapping(SchoolConstants.DELETESCHOOL)
    public void deleteSchool(@PathVariable long id) {
        schoolService.deleteSchool(id);
    }

    /*
This is to update an existing record
 */
    @PutMapping(SchoolConstants.UPDATESCHOOL)
    public void updateSchool(@RequestBody School s) {
        schoolService.updateSchool(s);
    }
}
