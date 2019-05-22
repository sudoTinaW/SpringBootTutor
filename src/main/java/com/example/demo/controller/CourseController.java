package com.example.demo.controller;

import com.example.demo.modal.Course;
import com.example.demo.modal.dto.CourseDto;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

// single function interface
@RestController
@RequestMapping(path="/course")
public class CourseController {
    @Autowired // IOC
    CourseService courseService; // Singleton

    Logger logger = LoggerFactory.getLogger(CourseController.class);

    @GetMapping(path = "/", produces = "application/json")
    public HttpEntity findAllCourses(){
        List<Course> allCourses = courseService.findAllCourses();

        return new ResponseEntity<>(allCourses,HttpStatus.OK);
    }

//    @GetMapping(path = "/api/course/findAllCourses", produces = "application/json")
//    public HttpEntity<List<CourseDto>> findAllCourses(){
//        List<CourseDto> allCourses = courseService.findAllCourses();
//
//        return new ResponseEntity<>(allCourses, HttpStatus.OK);
//    }

    @GetMapping(path = "/look-up/{inputString}", produces = "application/json")
    public HttpEntity<Course> searchCourse(@PathVariable("inputString") String inputString) {
        List<Course> foundCourse = courseService.searchByCourseName(inputString);

        return new ResponseEntity(foundCourse, HttpStatus.OK);
    }

    @PostMapping(path="/", produces="application/json")
    public HttpEntity<Course> addCourse(@RequestBody Course course) {

        Course addedCourse = courseService.addCourse(course);

        return new ResponseEntity(addedCourse, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{className}", produces = "application/json")
    public HttpEntity<Boolean> deleteCourse(@PathVariable("className") String className) {


        Boolean isDeleted = courseService.deleteCourse(className);


        return new ResponseEntity(isDeleted, HttpStatus.OK);
    }

    @PutMapping(path = "/{className}", produces = "application/json")
    public HttpEntity<Course> updateCourse(@PathVariable("className") String className, @RequestBody Course newCourse) {


        Course updatedCourse = courseService.updateCourse(className, newCourse);


        return new ResponseEntity(updatedCourse, HttpStatus.OK);
    }


}
