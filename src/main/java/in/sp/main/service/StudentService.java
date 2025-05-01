package in.sp.main.service;

import java.util.List;

import in.sp.main.entities.Student;

public interface StudentService 
{
	public List<Student> getAllStudents();

	public void saveStudent(Student student);
	
	public Student getById(int id);
	
	public void deleteById(int id);

}
