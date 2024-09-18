package com.serviceharbor.auth.repository;

import com.serviceharbor.auth.model.Role;
import com.serviceharbor.auth.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<Student, Integer> {
    Optional<Student> findByEmail(String email);
    Student findByRoleAndEmail(Role role, String email);

//    public Student findByEmail(String email);

    public Student findByUsername(String username);

    public Student findByEmailAndPassword(String email, String password);

    public List<Student> findProfileByEmail(String email);

    public boolean existsByUsername(String username);

}

