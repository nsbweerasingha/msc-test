package com.example.gscomp285.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gscomp285.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

}
