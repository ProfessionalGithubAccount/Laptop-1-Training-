package com.capstoneproject.assignmentmicroservice.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;

    private Long courseId;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Integer mark = 0; // default value of 0
}

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class Assignment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long assignmentId;
//
//    private Long courseId;
//    private String title;
//    private String description;
//    private LocalDate dueDate;
//    private Integer mark = 0; // default value of 0
//}
