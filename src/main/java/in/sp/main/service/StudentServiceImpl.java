package in.sp.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.sp.main.StudentMangementSysteminSpringbootApplication;
import in.sp.main.entities.Student;
import in.sp.main.repository.StudentReository;

@Service 
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentReository studentReository;


    @Override
    public List<Student> getAllStudents() {
        return studentReository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentReository.save(student);
    }

	@Override
	public Student getById(int id) {
		return studentReository.findById(id).get();
		
	}

	@Override
	public void deleteById(int id) {
		
		studentReository.deleteById(id);
		
	}

	


}
