package com.capstone.assignment.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Assignment {

    @Id
    private Integer assignmentId;
    private Integer professorId;
    private Integer courseId;

    @Lob
    @Column(name = "assignment_file", columnDefinition = "MEDIUMBLOB")
    private byte[] assignmentFile;

    private String title;
    private String fileName;
    private Date deadline;
}
