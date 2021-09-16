package com.first.spring.data.jpa.tutorial.Repository;

import com.first.spring.data.jpa.tutorial.Entity.Course_Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<Course_Material , Long> {
}
