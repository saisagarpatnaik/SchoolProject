package com.schoolapplication.project.controller;

import com.schoolapplication.project.constants.ClassesConstants;
import com.schoolapplication.project.entity.Classes;
import com.schoolapplication.project.service.ClassesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassesController {

    private static final Logger log = LoggerFactory.getLogger(ClassesController.class);

    @Autowired
    ClassesService classesService;

    /* A get Method to use Test Data
    No need to connect with the db, the data is already embedded in Service
     */
    @GetMapping(ClassesConstants.GETCLASSES)
    public Classes getClasses() {
        log.info("Welcome to the class");
        Classes c1 = classesService.getClasses();
        return c1;
    }

    /*
    This will get all the data for the specific repository
     */
    @GetMapping(ClassesConstants.GETCLASSESALL) //Get all data of class from the database
    public List<Classes> getClassesAll() {
        log.info("Welcome to the Class");
        List<Classes> c1 = classesService.getClassesAll();
        return c1;
    }

        /*
    This will get the data for a specific record id, it is for testing only as the id is hard coded in service
    */

    @GetMapping(ClassesConstants.GETCLASSESID)
    public Classes getClassesId() {
        log.info("Whats your school id");
        Classes c1 = classesService.getClassesId();
        return c1;
    }

    /*
This is to save classes data to db
 */
    @PostMapping(ClassesConstants.SAVECLASSES)
    public Classes saveClasses(@RequestBody Classes c) {
        Classes c1 = classesService.saveClasses(c);
        return c1;
    }

        /*
    Get a specific record with the id
     */

    @GetMapping(ClassesConstants.GETCLASSESDETAILBYID)
    public Classes getClassesDetailbyId(@PathVariable long id) {
        Classes classes = classesService.getClassesDetailbyId(id);
        return classes;
    }

    /*
This is to search classes data
 */
    @PostMapping(ClassesConstants.SEARCHCLASSES)
    public List<Classes> searchClasses(@RequestBody Classes c) {
        List<Classes> classes = classesService.searchClasses(c);
        return classes;
    }


    /*
This is to delete a record
 */
    @DeleteMapping(ClassesConstants.DELETECLASSES)
    public void deleteClasses(@RequestBody Classes c1) {
        classesService.deleteClasses(c1);
    }

    /*
This is to update an existing record
 */
    @PutMapping(ClassesConstants.UPDATECLASSES)
    public void updateClasses(@RequestBody Classes s) {
        classesService.updateClasses(s);
    }
}
