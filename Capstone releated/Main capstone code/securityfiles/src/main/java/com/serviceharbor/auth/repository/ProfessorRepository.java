package com.serviceharbor.auth.repository;

import com.serviceharbor.auth.model.Professor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {
	public Professor findByUsername(String username);

	public Professor findByEmail(String email);

	public List<Professor> findProfessorListByEmail(String email);

	public Professor findByProfessorname(String professorname);

	public Professor findByEmailAndPassword(String email, String password);

	public List<Professor> findProfileByEmail(String email);

}