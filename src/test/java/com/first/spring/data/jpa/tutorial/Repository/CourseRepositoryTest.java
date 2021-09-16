package com.first.spring.data.jpa.tutorial.Repository;

import com.first.spring.data.jpa.tutorial.Entity.Course;
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
    public  void  printAllCourse()
    {
        List<Course> cour = courseRepo.findAll();
        System.out.println("Courses"+cour);
    }
}