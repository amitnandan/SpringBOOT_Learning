package com.first.spring.data.jpa.tutorial.Repository;

import com.first.spring.data.jpa.tutorial.Entity.Course;
import com.first.spring.data.jpa.tutorial.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepo ;


    @Test
    public void saveCourse()
    {
        Teacher teach = Teacher.builder().firstName("Smith").lastName("Jones").build();
        Course cour = Course.builder().credits(15).title("JAVA").teacher(teach).build();
        courseRepo.save(cour);
    }
    @Test
    public  void  printAllCourse()
    {
        List<Course> cour = courseRepo.findAll();
        System.out.println("Courses"+cour);
    }
}