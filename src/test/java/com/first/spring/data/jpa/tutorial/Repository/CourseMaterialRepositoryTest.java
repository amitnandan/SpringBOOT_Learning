package com.first.spring.data.jpa.tutorial.Repository;

import com.first.spring.data.jpa.tutorial.Entity.Course;
import com.first.spring.data.jpa.tutorial.Entity.Course_Material;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private  CourseMaterialRepository coursematerial ;


    @Test
    public  void  saveCourseMaterial()
    {
        Course course = Course.builder().title("Topper").credits(25).build();
        Course_Material coursematerial1 = Course_Material.builder().
                url("http.facebookCourse.com").
                course(course).
                build();

        coursematerial.save(coursematerial1);
    }

    @Test
    public void printAllCourseMaterial()
    {
        List<Course_Material> cmaterial = coursematerial.findAll();
        System.out.println("CourseMaterial = "+cmaterial);
    }
}