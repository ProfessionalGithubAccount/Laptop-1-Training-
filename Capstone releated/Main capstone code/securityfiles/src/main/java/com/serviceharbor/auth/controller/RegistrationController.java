package com.serviceharbor.auth.controller;


import com.serviceharbor.auth.model.Professor;
import com.serviceharbor.auth.model.Role;
import com.serviceharbor.auth.model.Student;
import com.serviceharbor.auth.model.User;
import com.serviceharbor.auth.repository.ProfessorRepository;
import com.serviceharbor.auth.repository.StudentRepository;
import com.serviceharbor.auth.repository.UserRepository;
import com.serviceharbor.auth.service.ProfessorService;
import com.serviceharbor.auth.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController 
{
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ProfessorService professorService;


	@PostMapping("/registerstudent")
	@CrossOrigin(origins = "http://localhost:4200")
	public Student registerStudent(@RequestBody Student student) throws Exception
	{

		//The goal is to save the username,id,password and role in the user tabel ...and everything except role in the student table

        String password= student.getPassword();
		String encodedPassword = passwordEncoder.encode(password);

        // Create a new user object
        Student student1 = studentService.saveUser(student);
        student1.setPassword(encodedPassword);

		String username=student.getUsername();
		int id=student.getStudentId();
//		System.out.println(id);


		User user1=new User();
		user1.setId(id);
		user1.setEmail(username);
		user1.setPassword(encodedPassword);
		user1.setRole(Role.STUDENT);
        // Save the student to the database(student table)...and also to the sec_user table
        userrepo.save(user1);
		return studentRepository.save(student1);
	}
	
	@PostMapping("/registerprofessor")
	@CrossOrigin(origins = "http://localhost:4200")
	public Professor registerProfessor(@RequestBody Professor professor) throws Exception
	{


		String password=professor.getPassword();
		String encodedPassword = passwordEncoder.encode(password);
		
		Professor professor2=professorService.saveProfessor(professor);
		professor2.setPassword(encodedPassword);




		String username=professor.getUsername();
		int id=professor.getProfessorId();


		User user1=new User();
		user1.setId(id);
		user1.setEmail(username);
		user1.setPassword(encodedPassword);
		user1.setRole(Role.PROFESSOR);


		userrepo.save(user1);
		return professorRepository.save(professor2);
	}
}