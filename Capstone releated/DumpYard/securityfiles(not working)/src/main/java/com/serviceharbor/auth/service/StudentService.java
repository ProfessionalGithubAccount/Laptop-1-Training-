package com.serviceharbor.auth.service;


import com.serviceharbor.auth.model.Role;
import com.serviceharbor.auth.model.Student;
import com.serviceharbor.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    private final UserRepository userRepository;

    public StudentService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }


    public Student getUserByRoleAndEmail(String role, String email) {
        Role userRole;
        try {
            userRole = Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid role: " + role);
        }
        return userRepository.findByRoleAndEmail(userRole, email);
    }
    public List<Student> allUsers() {
        List<Student> students = new ArrayList<>();

        userRepository.findAll().forEach(students::add);

        return students;
    }





    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepo;

    public Student saveUser(Student student)
    {

        return userRepo.save(student);
    }

    public Student updateUserProfile(Student student)
    {

        return userRepo.save(student);
    }

    public List<Student> getAllUsers()
    {

        return (List<Student>)userRepo.findAll();
    }

    public Optional<Student> fetchUserByEmail(String email)
    {

        return userRepo.findByEmail(email);
    }

    public Student fetchUserByUsername(String username)
    {
        return userRepo.findByUsername(username);
    }

    public Student fetchUserByEmailAndPassword(String email, String password)
    {
        return userRepo.findByEmailAndPassword(email, password);
    }

    public List<Student> fetchProfileByEmail(String email)
    {
        return (List<Student>)userRepo.findProfileByEmail(email);
    }

    public boolean authenticate(String username, String password) {
        Student user = userRepo.findByUsername(username);
        System.out.println("User Present");
        if (user != null) {
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    public void registerUser(Student user) {
        if (userRepo.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    public String getCourseIdsByStudentId(Integer studentId) {
        // Fetch the student by ID
        Student student = userRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        // Return the list of course IDs
        return student.getCourseIds();
    }



    public boolean existsByUsername(String username) {

        return userRepo.existsByUsername(username);
    }
}
