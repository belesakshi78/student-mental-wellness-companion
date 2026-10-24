package com.studywell.student_mental_wellness_companion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studywell.student_mental_wellness_companion.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByUserIdOrderByExamDateAsc(Long userId);
}