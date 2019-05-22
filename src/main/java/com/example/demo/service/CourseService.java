package com.example.demo.service;


import com.example.demo.modal.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> findAllCourses(){

        return courseRepository.findAllClasses();
    }

    public List<Course> searchByCourseName(String input){

        return courseRepository.findCourseByName(input);
    }

    public Course addCourse(Course course){
        return courseRepository.addCourse(course);
    }

    public boolean deleteCourse(String className) {
        return courseRepository.deleteCourse(className);
    }

    public Course updateCourse(String className, Course newCourse){
        return courseRepository.updateCourse(className, newCourse);

    }

}

