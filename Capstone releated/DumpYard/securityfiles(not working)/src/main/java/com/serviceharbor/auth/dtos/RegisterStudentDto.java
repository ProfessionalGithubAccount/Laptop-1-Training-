package com.serviceharbor.auth.dtos;

import com.serviceharbor.auth.model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterStudentDto {

    @Id
    private Integer studentId;

    @ElementCollection
    @CollectionTable(name = "user_courses", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "course_id")
    private List<Integer> courseIds;


    @Column(name = "email", nullable = false, unique = true)
    private String email;
    private String username;
    private String studentName;
    private String userid;
    private String mobile;
    private String gender;
    private String profession;
    private String address;
    private String password;




}
