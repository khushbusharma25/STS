package com.sts.springmavendemo.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sts.springmavendemo.dto.StudentDTO;

@Repository
public interface StudentRepo extends JpaRepository<StudentDTO, Serializable>{

}
