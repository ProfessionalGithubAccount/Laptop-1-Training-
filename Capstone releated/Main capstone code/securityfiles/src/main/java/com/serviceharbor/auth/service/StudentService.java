package com.serviceharbor.auth.service;


import com.serviceharbor.auth.model.Student;
import com.serviceharbor.auth.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private StudentRepository userRepo;
	
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
	
	public Student fetchUserByEmail(String email)
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
        Student student = userRepo.findByUsername(username);
        System.out.println("User Present");
        if (student != null) {
            return passwordEncoder.matches(password, student.getPassword());
        }
        return false;
    }

    public void registerUser(Student student) {
        if (userRepo.existsByUsername(student.getUsername())) {
            throw new RuntimeException("Username already exists!");
        }
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        userRepo.save(student);
    }

	public List<Integer> getCourseIdsByStudentId(Integer studentId) {
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