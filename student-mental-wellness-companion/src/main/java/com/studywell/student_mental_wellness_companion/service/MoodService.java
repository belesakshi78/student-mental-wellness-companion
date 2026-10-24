package com.studywell.student_mental_wellness_companion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studywell.student_mental_wellness_companion.entity.Mood;
import com.studywell.student_mental_wellness_companion.repository.MoodRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MoodService {
    
    private final MoodRepository moodRepository;
    
    public Mood saveMood(Mood mood) {
        return moodRepository.save(mood);
    }
    
    public List<Mood> getMoodsByUser(Long userId) {
        return moodRepository.findByUserId(userId);
    }
}