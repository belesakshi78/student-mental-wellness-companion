package com.studywell.student_mental_wellness_companion.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studywell.student_mental_wellness_companion.service.AlarmService;
import com.studywell.student_mental_wellness_companion.service.StudySessionService;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    private final StudySessionService studyService;
    private final AlarmService alarmService;

    public DashboardController(
            StudySessionService studyService,
            AlarmService alarmService) {
        this.studyService = studyService;
        this.alarmService = alarmService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> getDashboard(@PathVariable Long userId) {
        Map<String, Object> data = new HashMap<>();
        data.put("todayMood", null);
        data.put("todayStudyMinutes", studyService.getTodayStudyTime(userId));
        data.put("nextAlarm", getNextAlarm(userId));
        return ResponseEntity.ok(data);
    }

    private Object getNextAlarm(Long userId) {
        try {
            return alarmService.getClass()
                    .getMethod("getNextAlarm", Long.class)
                    .invoke(alarmService, userId);
        } catch (ReflectiveOperationException | SecurityException exception) {
            if (exception instanceof InvocationTargetException invocationException
                    && invocationException.getCause() instanceof RuntimeException runtimeException) {
                throw runtimeException;
            }
            throw new IllegalStateException("Unable to retrieve the next alarm", exception);
        }
    }
}