package com.first.spring.data.jpa.tutorial.Repository;

import com.first.spring.data.jpa.tutorial.Entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

    //if we want to make some custom methods in this repo .
    //we can do this .
    //Let's see .
    //In this we made a method to fetch student using only firstName


    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    //TO check for more methods go at the above link
    public List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);


    //Now lets make a function where we can perform our custom query.
    //thus we will write jpl queries . These queries are defined on based on the
    //class name not the table name in the database.


    //jplquery
    @Query("Select s from Student s where s.emailId = ?1")
    List<Student> getTheNameBasedOnEmailId(String emailId);

    //UsingNativeSQLQuery

    @Query(
            value = "Select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    List<Student> getTheNameBasedOnEmailNativeSQLQuery(String emailStudent);

    //NativeNamedParam .. that is if there are more than many values that is to be passed .
    // it is not good to use ?1 , ?2 everywhere so we are going to use Native param


    @Query(
            value = "Select * from tbl_student s where s.email_address = :emailid",
            nativeQuery = true
    )
    List<Student> getTheNameBasedOnEmailNativeParamQuery( @Param("emailid") String emailStudent);


    // All the methods that we have used or made above are used to make fetch data
    // Now we are going to make function that will Provide Transaction control / Modify data in table.

    @Modifying // to tell that we are going to modify the data in table
    @Transactional
    @Query(
            value = "Update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId( String firstName ,
                                    String emailId);
}
