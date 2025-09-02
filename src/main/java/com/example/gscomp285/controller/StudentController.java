package com.example.gscomp285.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gscomp285.request.StudentRequest;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
	@GetMapping(value = "get-all-student")
	@Operation(summary = "Get all student")
	public ResponseEntity<String> getAllStudent(HttpServletResponse httpServletResponse){
		return null;
	}
	
	@GetMapping(value = "get-student-by-id")
	@Operation(summary = "Get student by id")
	public ResponseEntity<String> getStudentByID(
			@RequestParam(name = "student-id", required = true) int studentID,
			HttpServletResponse httpServletResponse){
		return null;
	}
	
	@PostMapping(value = "save-student")
	@Operation(summary = "Save student")
	public ResponseEntity<String> saveStudent(
			@Valid @RequestBody StudentRequest request,
			HttpServletResponse httpServletResponse){
		return null;
	}
	
	@PutMapping(value = "update-student")
	@Operation(summary = "Update student")
	public ResponseEntity<String> updateStudentByID(
			@Valid @RequestBody StudentRequest request,
			HttpServletResponse httpServletResponse){
		return null;
	}
	
	@DeleteMapping(value = "delete-student")
	@Operation(summary = "Delete student")
	public ResponseEntity<String> deleteStudentByID(
			@RequestParam(name = "student-id", required = true) int studentID,
			HttpServletResponse httpServletResponse){
		return null;
	}
}
