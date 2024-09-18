package com.serviceharbor.auth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Professor implements UserDetails
{
    @Id
    private Integer professorId;

    @ElementCollection
    @CollectionTable(name = "professor_courses", joinColumns = @JoinColumn(name = "professor_id"))
    @Column(name = "course_id")
    private List<Integer> courseIds;


    @Column(name = "email", nullable = false, unique = true)
    private String email;

    private String professorname;
    private String degreecompleted;
    private String department;
    private String experience;
    private String mobile;
    private String gender;
    private String password;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return "";
    }

    public String orElseThrow() {
        return "User not found ..sorry";
    }
}
