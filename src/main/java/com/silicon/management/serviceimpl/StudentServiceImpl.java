package com.silicon.management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silicon.management.model.Student;
import com.silicon.management.repository.StudentRepository;
import com.silicon.management.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentrepository;
	@Override
	
	public void addStudent(Student st) {
		// TODO Auto-generated method 
		studentrepository.save(st);
		
	}

	@Override
	public List<Student> fetchStudent() {
		// TODO Auto-generated method stub
		List<Student> Students= studentrepository.findAll();
		return Students;
	}

	@Override
	public void updateStudent(Student st) {
		// TODO Auto-generated method stub
		//fetch the student with particular id if exist update it else throw exception
		Optional<Student> opt=studentrepository.findById(st.getId());
		
		if(opt.isPresent())
		{
			studentrepository.save(st);
		}
		
		else {
			throw new RuntimeException("Student not found");
		}
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		if(studentrepository.existsById(id))
		{
			studentrepository.deleteById(id);
		}
		else {
			throw new RuntimeException("ID not found");
		}
		
		
	}
	
	
	
	

	
}
