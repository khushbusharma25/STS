package com.sts.springmavendemo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sts.springmavendemo.dto.StudentDTO;
import com.sts.springmavendemo.repo.StudentRepo;



@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;
	
	public StudentDTO saveStudent(StudentDTO studentDTO) {
		return studentRepo.save(studentDTO);
	}
	
	public  List<StudentDTO> getAllStudents() {
//		List<StudentDTO> listStudent=  studentRepo.findAll();
//		Map<String,List<StudentDTO>> map= new HashMap<String, List<StudentDTO>>(); 
//		map.put("studentList", listStudent);
//		return map;
		return  studentRepo.findAll();
	}
	
	public StudentDTO getStudentByKey(Long id) {
	
		return studentRepo.findOne(id);
	}

	public StudentDTO updateStudent(StudentDTO studentDTO) {
		StudentDTO dto = studentRepo.getOne(studentDTO.getId());
		dto.setfName(studentDTO.getfName());
		dto.setlName(studentDTO.getlName());
		dto.setEmail(studentDTO.getEmail());
		dto.setAddress(studentDTO.getAddress());
		dto.setContNo(studentDTO.getContNo());
		
		return studentRepo.save(dto);
	}
	
	
	public ResponseEntity<?> deleteStudent(Long id) {
		StudentDTO studentDTO = studentRepo.findOne(id);
		 studentRepo.delete(studentDTO);
		return null;
		
	}
	
	
}
