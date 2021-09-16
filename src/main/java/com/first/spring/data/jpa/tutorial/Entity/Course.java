package com.first.spring.data.jpa.tutorial.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class Course {

    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue( strategy = GenerationType.SEQUENCE
                    ,   generator = "course_sequence"
    )


    @Id
    private Long courseId;
    private String title ;
    private Integer credits;

    @OneToOne(
            mappedBy = "course"
    )
    private Course_Material coursemateriall ;
}
