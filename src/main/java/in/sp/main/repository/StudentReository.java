package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sp.main.entities.Student;

@Repository
public interface StudentReository extends JpaRepository<Student, Integer> {

}
