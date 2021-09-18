package com.first.spring.data.jpa.tutorial.Repository;

import com.first.spring.data.jpa.tutorial.Entity.Course;
import com.first.spring.data.jpa.tutorial.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private  TeacherRepository teacherRepo;

    @Test
    public void  saveTeacher()
    {

        Course co =  Course.builder().credits(45).title("English").build();
        Course co1 = Course.builder().credits(25).title("Math").build();

        Teacher teacher =
                Teacher.builder().firstName("Allen").lastName("Cowell").
                        //courses(List.of(co,co1)).
                         build();
        teacherRepo.save(teacher);
    }

}