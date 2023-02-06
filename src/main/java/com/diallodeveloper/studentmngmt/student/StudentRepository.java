package com.diallodeveloper.studentmngmt.student;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT b from Student b WHERE b.email = ?1")
    boolean selectExistsEmail(String email);
}