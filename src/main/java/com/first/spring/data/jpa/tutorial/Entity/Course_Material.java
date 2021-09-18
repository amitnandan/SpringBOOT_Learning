package com.first.spring.data.jpa.tutorial.Entity;


import lombok.*;
//import org.hibernate.annotations.Cascade;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude ="course")

public class Course_Material {

    @SequenceGenerator(
            name = "courseMaterialSequence",
            sequenceName = "courseMaterialSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "courseMaterialSequence"
    )
    @Id
    private  Long courseMaterialId;
    private String url ;


    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private  Course course;
}
