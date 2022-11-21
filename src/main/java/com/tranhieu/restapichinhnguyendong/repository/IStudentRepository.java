package com.tranhieu.restapichinhnguyendong.repository;

import com.tranhieu.restapichinhnguyendong.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {
}
