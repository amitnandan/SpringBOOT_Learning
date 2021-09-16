package com.first.spring.data.jpa.tutorial.Repository;

import com.first.spring.data.jpa.tutorial.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
