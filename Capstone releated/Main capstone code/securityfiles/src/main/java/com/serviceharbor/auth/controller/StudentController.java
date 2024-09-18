package com.serviceharbor.auth.controller;


import com.serviceharbor.auth.model.Student;
import com.serviceharbor.auth.service.ProfessorService;
import com.serviceharbor.auth.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController
{
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/studentlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Student>> getStudents() throws Exception
	{
		List<Student> students = studentService.getAllUsers();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@GetMapping("/studentprofileDetails/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Student>> getProfileDetails(@PathVariable String email) throws Exception
	{
		List<Student> students = studentService.fetchProfileByEmail(email);
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	@PutMapping("/updatestudent")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Student> updateStudentProfile(@RequestBody Student student) throws Exception
	{
		Student userobj = studentService.updateUserProfile(student);
		return new ResponseEntity<Student>(userobj, HttpStatus.OK);
	}
	
	@GetMapping("/gettotalstudents")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Integer>> getTotalStudents() throws Exception
	{
		List<Student> students = studentService.getAllUsers();
		List<Integer> usersCount = new ArrayList<>();
		usersCount.add(students.size());
		return new ResponseEntity<List<Integer>>(usersCount, HttpStatus.OK);
	}

	@GetMapping("/{studentId}/courses")
	public List<Integer> getCourseIdsByStudentId(@PathVariable Integer studentId) {
		return studentService.getCourseIdsByStudentId(studentId);
	}




	
}
