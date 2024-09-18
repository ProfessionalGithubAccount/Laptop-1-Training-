package com.serviceharbor.auth.service;

import com.serviceharbor.auth.model.Professor;
import com.serviceharbor.auth.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepo;

    public Professor saveProfessor(Professor professor)
    {
        return professorRepo.save(professor);
    }

    public Professor addNewProfessor(Professor professor)
    {
        return professorRepo.save(professor);
    }

    public Professor updateProfessorProfile(Professor professor)
    {
        return professorRepo.save(professor);
    }

    public List<Professor> getAllProfessors()
    {
        return (List<Professor>)professorRepo.findAll();
    }

    public List<Professor> getProfessorListByEmail(String email)
    {
        return (List<Professor>)professorRepo.findProfessorListByEmail(email);
    }

    public Professor fetchProfessorByEmail(String email)
    {
        return professorRepo.findByEmail(email);
    }

    public Professor fetchProfessorByProfessorname(String professorname)
    {
        return professorRepo.findByProfessorname(professorname);
    }

    public Professor fetchProfessorByEmailAndPassword(String email, String password)
    {
        return professorRepo.findByEmailAndPassword(email, password);
    }

    public List<Professor> fetchProfileByEmail(String email)
    {
        return (List<Professor>)professorRepo.findProfileByEmail(email);
    }

    public List<Professor> getProfessorsByEmail(String email)
    {
        return professorRepo.findProfessorListByEmail(email);
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean authenticate(String email, String password) {
        Professor professor = professorRepo.findByEmail(email);
        System.out.println("Professor Present");
        if (professor != null) {
            return passwordEncoder.matches(password, professor.getPassword());
        }
        return false;
    }
    public List<Integer> getCourseIdsByProfessorId(Integer professorId) {
        // Fetch the professor by ID
        Professor professor = professorRepo.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found with id: " + professorId));

        // Return the list of course IDs
        return professor.getCourseIds();
    }
}