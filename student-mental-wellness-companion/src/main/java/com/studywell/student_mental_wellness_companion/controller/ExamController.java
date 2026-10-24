package com.studywell.student_mental_wellness_companion.controller;

import com.studywell.student_mental_wellness_companion.entity.Exam;
import com.studywell.student_mental_wellness_companion.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExamController {
    private final ExamService examService;

    @PostMapping("/add")
    public ResponseEntity<Exam> addExam(@RequestBody Exam exam) {
        return ResponseEntity.ok(examService.saveExam(exam));
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Exam>> getExams(@PathVariable Long userId) {
        return ResponseEntity.ok(examService.getUpcomingExams(userId));
    }
}