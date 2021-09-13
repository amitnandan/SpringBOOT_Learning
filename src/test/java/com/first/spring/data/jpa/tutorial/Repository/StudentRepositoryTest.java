package com.first.spring.data.jpa.tutorial.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class StudentRepositoryTest {
    @Autowired
    private  StudentRepository StudentRepo ;

    @Test
    public  void saveStudent()
    {}

}