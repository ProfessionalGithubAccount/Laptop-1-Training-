package com.serviceharbor.auth.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RegisterProfessorDto
{
    @Id
    private Integer professorId;

    @ElementCollection
    @CollectionTable(name = "professor_courses", joinColumns = @JoinColumn(name = "professor_id"))
    @Column(name = "course_id")
    private List<Integer> courseIds;

    private String email;
    private String professorname;
    private String degreecompleted;
    private String department;
    private String experience;
    private String mobile;
    private String gender;
    private String password;
}
