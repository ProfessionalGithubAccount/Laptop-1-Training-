package com.serviceharbor.auth.service;


import com.serviceharbor.auth.dtos.LoginProfessorDto;
import com.serviceharbor.auth.dtos.LoginStudentDto;
import com.serviceharbor.auth.dtos.RegisterStudentDto;
import com.serviceharbor.auth.model.Professor;
import com.serviceharbor.auth.model.Role;
import com.serviceharbor.auth.model.Student;
import com.serviceharbor.auth.repository.ProfessorRepository;
import com.serviceharbor.auth.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final ProfessorRepository professorRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    private ProfessorRepository profrepo;


    public AuthenticationService(
        UserRepository userRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder,
        ProfessorRepository professorRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.professorRepository=professorRepository;
    }

//    public User signup(RegisterUserDto input) {
//        var user = new User()
//
//            .setEmail(input.getEmail())
//            .setPassword(passwordEncoder.encode(input.getPassword()));
//
//        return userRepository.save(user);
//    }
public Student signupStudent(Student input) {
    System.out.println("service:"+input);
    // Create a new Student object and set its fields based on the input
    Student student = new Student();

    // Set basic fields
    student.setUsername(input.getUsername());
    student.setStudentId(input.getStudentId());
    student.setStudentName(input.getStudentName());
    student.setEmail(input.getEmail());
    student.setPassword(passwordEncoder.encode(input.getPassword()));
    student.setUserid(input.getUserid());
    student.setMobile(input.getMobile());
    student.setGender(input.getGender());
    student.setProfession(input.getProfession());
    student.setAddress(input.getAddress());

    // Set role, assuming Role is an enum and input has it properly set
    student.setRole(input.getRole());

    // Set course IDs
    student.setCourseIds(input.getCourseIds());

    // Save the student in the database
    return userRepository.save(student);
}

    public Professor signupProfessor(Professor input) {
        // Create a new Professor object and set its fields based on the input DTO
        Professor professor = new Professor();

        // Set basic fields
        professor.setProfessorId(input.getProfessorId());
        professor.setProfessorname(input.getProfessorname());
        professor.setDegreecompleted(input.getDegreecompleted());
        professor.setDepartment(input.getDepartment());
        professor.setExperience(input.getExperience());
        professor.setMobile(input.getMobile());
        professor.setGender(input.getGender());
        professor.setEmail(input.getEmail());
        professor.setPassword(passwordEncoder.encode(input.getPassword()));

        // Set course IDs if they are provided in the input DTO
        professor.setCourseIds(input.getCourseIds());

        // Save the professor in the database
        return professorRepository.save(professor);
    }

    public Student authenticate(LoginStudentDto input) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                input.getEmail(),
                input.getPassword()
            )
        );

        return userRepository.findByEmail(input.getEmail()).orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }

    public String authenticate(LoginProfessorDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return profrepo.findByEmail(input.getEmail()).orElseThrow();
    }

    public List<Student> allUsers() {
        List<Student> students = new ArrayList<>();

        userRepository.findAll().forEach(students::add);

        return students;
    }
}
