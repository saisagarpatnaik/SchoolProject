package com.schoolapplication.project.controller;

import com.schoolapplication.project.constants.StudentConstants;
import com.schoolapplication.project.entity.Student;
import com.schoolapplication.project.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    /* A get Method to use Test Data
No need to connect with the db, the data is already embedded in Service
 */
    @GetMapping(StudentConstants.GETSTUDENT)
    public Student getStudent() {
        log.info("Welcome the student");
        Student student = studentService.getStudent();
        return student;
    }

        /*
    This will get all the data for the specific repository
     */

    @GetMapping(StudentConstants.GETSTUDENTALL) //Get all data of class from the database
    public List<Student> getStudentAll() {
        log.info("Welcome all the students");
        List<Student> student = studentService.getStudentAll();
        return student;
    }

        /*
    This will get the data for a speific record id, it is for testing only as the id is hard coded in service
    */

    @GetMapping(StudentConstants.GETSTUDENTID)
    public Student getStudentId() {
        log.info("Whats your Student id");
        Student s1 = studentService.getStudentId();
        return s1;
    }

    /*
This is to save to db
 */
    @PostMapping(StudentConstants.SAVESTUDENT)
    public Student saveStudent(@RequestBody Student s) {
        Student s1 = studentService.saveStudent(s);
        return s1;
    }

    /*
Get a specific record with the id
 */
    @GetMapping(StudentConstants.GETSTUDENTDETAILBYID)
    public Student getStudentDetailbyId(@PathVariable Long id) {
        Student student = studentService.getStudentDetailbyId(id);
        return student;
    }

    /*
This is to search school with specific data
 */
    @PostMapping(StudentConstants.SEARCHSTUDENT)
    public List<Student> searchStudent(@RequestBody Student s) {
        List<Student> s1 = studentService.searchStudent(s);
        return s1;
    }

    /*
This is to delete a record
 */
    @DeleteMapping(StudentConstants.DELETESTUDENT)
    public void deleteStudent(@RequestBody Student s) {
        studentService.deleteStudent(s);
    }

    /*
This is to update an existing record
 */
    @PutMapping(StudentConstants.UPDATESTUDENT)
    public void updateStudent(@RequestBody Student s) {
        studentService.updateStudent(s);
    }
}
