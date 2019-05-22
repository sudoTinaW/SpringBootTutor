package com.example.demo.repository;

import com.example.demo.modal.Course;
import com.example.demo.modal.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class CourseRepository {
    List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        Course javaOne = Course.builder()
                .className("Java I")
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();

        courses.add(javaOne);
    }


    public List<Course> findAllClasses(){
        //链接数据库
        //返回数据库的信息
        return  courses;
    }

    public List<Course> findAllCourse(String searchByCourseName){

        return new ArrayList<Course>();
    }

    public List<Course> findCourseByName(String courseName) {
        if(courseName.equals("Java_I")) {
            return courses;
        }

        return new ArrayList<Course>();
    }

    public Course addCourse(Course course) {
        courses.add(course);
        return course;
    }

    public Course updateCourse (String className, Course newCourse) {
        int index = IntStream.range(0, courses.size())
                .filter(i -> courses.get(i).getClassName().equals(className))
                .findFirst()
                .orElse(-1);
        if(index != -1) {
            courses.set(index, newCourse);

        }
        return newCourse;

    }

    public boolean deleteCourse(String courseName) {

        Course deletedCourse = courses.stream()
                .filter(course -> courseName.equals(course.getClassName()))
                .findAny()
                .orElse(null);
        if(deletedCourse != null) {
            return courses.remove(deletedCourse);
        }else {
            return false;
        }

    }

}
