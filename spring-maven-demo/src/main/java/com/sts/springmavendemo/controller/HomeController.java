package com.sts.springmavendemo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.springmavendemo.dto.StudentDTO;
import com.sts.springmavendemo.service.StudentService;

@RestController
@RequestMapping("/student")
public class HomeController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public String welcome() {
		return "WELCOME";
	}
	@GetMapping("/home")
	public String welcomeHome() {
		return "WELCOME to home";
	}
	
	@GetMapping("/getAll")
	public List<StudentDTO> getAllStudent() {
		return studentService.getAllStudents();
	}
	
	@PostMapping("/save")
	public StudentDTO saveStudent(@Valid @RequestBody StudentDTO studentDTO) {
		return studentService.saveStudent(studentDTO);
	}
	
	@GetMapping("/getByKey/{id}")
	public StudentDTO getStudentById(@PathVariable(value="id") Long id) {
		return studentService.getStudentByKey(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable(value="id") Long id) {
		return studentService.deleteStudent(id);
	
	}
	
	@PutMapping("/updateStudent")
	public StudentDTO updateStudent(@Valid @RequestBody StudentDTO studentDTO) {
		return studentService.updateStudent(studentDTO);
	}
	
}
