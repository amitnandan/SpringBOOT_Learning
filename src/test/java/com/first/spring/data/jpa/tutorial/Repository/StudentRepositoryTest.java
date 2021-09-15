package com.first.spring.data.jpa.tutorial.Repository;

import com.first.spring.data.jpa.tutorial.Entity.Guardian;
import com.first.spring.data.jpa.tutorial.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class StudentRepositoryTest {
    @Autowired
    private  StudentRepository StudentRepo ;

    @Test
    public  void saveStudent()
    {
        Student student = new Student().builder().emailId("a.amitnandan@gmail.com").firstName("Amit")
                            .lastName("Nandan")
                                //guardianName("Guard").guardianEmail("abc@gmail.com")
                            //.guardianMobile("93080")
                            .build();
        StudentRepo.save(student);
    }
    @Test
    public void saveStudentWithGuardian()
    {
        Guardian guardian = new Guardian().builder().
                        name("Rashmi").email("Rashmi@gmail.com").mobile("461313").
                build();

        Student student = new Student().builder().
                firstName("Rahul").lastName("Raj").emailId("R@gmail.com").guardian(guardian).
                build();

        StudentRepo.save(student);
    }
    @Test
    public void getStudentByFirstName()
    {
        List<Student> students =  StudentRepo.findByFirstName("Amit");
        System.out.println("STUDENTS"+students);
    }
    @Test
    public void getStudentByFirstNameContainingCharacters()
    {
        List<Student> students =  StudentRepo.findByFirstNameContaining("a");
        System.out.println("STUDENTS"+students);
    }
    @Test
    public void getStudentByEmailIdOfStudent()
    {
        List<Student> students =  StudentRepo.getTheNameBasedOnEmailId("a.amitnandan@gmail.com");
        System.out.println("STUDENTS"+students);
    }
    @Test
    public void getStudentByEmailIdUsingNativeSql()
    {
        List<Student> students =  StudentRepo.getTheNameBasedOnEmailNativeSQLQuery("a.amitnandan@gmail.com");
        System.out.println("STUDENTS"+students);
    }

    @Test
    public void getStudentByEmailIdUsingParamSql()
    {
        List<Student> students =  StudentRepo.getTheNameBasedOnEmailNativeParamQuery("a.amitnandan@gmail.com");
        System.out.println("STUDENTS"+students);
    }
    @Test
    public  void updateStudentEmailId()
    {
        StudentRepo.updateStudentNameByEmailId("Rahul Raj" , "R@gmail.com");
    }

}