package com.capstone.assignmentmicroservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


import java.sql.Timestamp;

@Entity
@Data
public class Assignment {
    @Id
    private Integer assignmentId;
    private Integer professorId;
    private Integer courseId;
    private String title;
    private Integer marks;
    private String fileName;
    private Timestamp deadline;
}
