package com.silicon.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silicon.management.model.Student;
import com.silicon.management.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/students")
@Tag(name = "Student Controller", description = "APIs for managing students")
public class StudentController {

	@Autowired
	StudentService studentservice;	

	@Operation(summary = "Add a new student", description = "Stores a student object in the database")
	@ApiResponse(responseCode = "200", description = "Student added successfully")
	@PostMapping("/addstudent")
	public String addstudent(@RequestBody Student st) {
		studentservice.addStudent(st);
		return "Added Successfully";
	}

	@Operation(summary = "Fetch all students", description = "Retrieves all student records from the database")
	@ApiResponse(responseCode = "200", description = "Students fetched successfully")
	@GetMapping("/getstudent")
	public List<Student> getstudent() {
		return studentservice.fetchStudent();
	}

	@Operation(summary = "Update a student", description = "Updates the details of an existing student")
	@ApiResponse(responseCode = "200", description = "Student updated successfully")
	@PutMapping("/update")
	public void updateStudent(@RequestBody Student st) {
		studentservice.updateStudent(st);
	}

	@Operation(summary = "Delete a student", description = "Deletes a student from the database by ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Student deleted successfully"),
		@ApiResponse(responseCode = "404", description = "Student not found")
	})
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentservice.deleteStudent(id);
		return "Deleted Successfully";
	}
}
