

package com.serviceharbor.auth.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.security.Timestamp;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student implements UserDetails
{
    @Id
    private Integer studentId;

////
//    @ElementCollection
//    @CollectionTable(name = "user_courses", joinColumns = @JoinColumn(name = "user_id"))
//    @Column(name = "course_id")
//    private List<Integer> courseIds;

    private String courseIds;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    private Role role;



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



    @CreationTimestamp
    @Column(name = "CreatedAt")
    private java.security.Timestamp createdAt;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

}


