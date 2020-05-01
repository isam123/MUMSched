package com.MumSched.MUMSched.Repository;

import com.MumSched.MUMSched.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
