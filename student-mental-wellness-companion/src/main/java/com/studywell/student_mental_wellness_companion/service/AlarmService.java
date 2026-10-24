package com.studywell.student_mental_wellness_companion.service;

import org.springframework.stereotype.Service;

import com.studywell.student_mental_wellness_companion.entity.Alarm;

@Service
public class AlarmService {
    public Alarm saveAlarm(Alarm alarm) {
        return alarm;
    }
    
    public Alarm getNextAlarm(Long userId) {
        return null; // nantar logic taku
    }
}
