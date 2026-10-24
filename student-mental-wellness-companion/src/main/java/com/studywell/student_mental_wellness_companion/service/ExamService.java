package com.studywell.student_mental_wellness_companion.service;

import com.studywell.student_mental_wellness_companion.entity.Exam;
import com.studywell.student_mental_wellness_companion.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;

    public Exam saveExam(Exam exam) {
        return examRepository.save(exam);
    }
    
    @SuppressWarnings("unchecked")
    public List<Exam> getUpcomingExams(Long userId) {
        return (List<Exam>) (List<?>) examRepository.findByUserIdOrderByExamDateAsc(userId);
    }
}