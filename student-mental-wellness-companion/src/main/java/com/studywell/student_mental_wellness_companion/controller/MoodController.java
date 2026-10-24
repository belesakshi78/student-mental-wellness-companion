package com.studywell.student_mental_wellness_companion.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studywell.student_mental_wellness_companion.entity.Mood;
import com.studywell.student_mental_wellness_companion.service.MoodService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/mood")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MoodController {
    
    private final MoodService moodService;
    
    // save mood 
    @PostMapping("/add")
    public ResponseEntity<Mood> addMood(@RequestBody Mood mood) {
        return ResponseEntity.ok(moodService.saveMood(mood));
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Mood>> getUserMoods(@PathVariable Long userId) {
        return ResponseEntity.ok(moodService.getMoodsByUser(userId));
    }
}