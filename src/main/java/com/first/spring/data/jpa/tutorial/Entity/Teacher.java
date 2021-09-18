package com.first.spring.data.jpa.tutorial.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @SequenceGenerator(
            name ="teacher_sequence_id",
            sequenceName = "teacher_sequence_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence_id"
    )
    @Id
    private Long teacherId ;
    private String firstName ;
    private String lastName;
//When ever possible go for ManyToOne relationship . It is more readable and understandable
//    @OneToMany
//            (
//                    cascade = CascadeType.ALL
//            )
//    @JoinColumn(
//            name="teacher_id",
//            referencedColumnName = "teacherId"
//
//    )
//    private List<Course> courses;
}
