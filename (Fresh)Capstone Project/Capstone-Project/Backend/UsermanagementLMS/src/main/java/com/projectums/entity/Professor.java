package com.projectums.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Professor
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

//	private String role;
	private String username;

	public Integer getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Integer professorId) {
		this.professorId = professorId;
	}

	public List<Integer> getCourseIds() {
		return courseIds;
	}

	public void setCourseIds(List<Integer> courseIds) {
		this.courseIds = courseIds;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfessorname() {
		return professorname;
	}

	public void setProfessorname(String professorname) {
		this.professorname = professorname;
	}

	public String getDegreecompleted() {
		return degreecompleted;
	}

	public void setDegreecompleted(String degreecompleted) {
		this.degreecompleted = degreecompleted;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
