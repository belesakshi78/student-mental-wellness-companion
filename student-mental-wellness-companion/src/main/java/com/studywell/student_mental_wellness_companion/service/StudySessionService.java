package com.studywell.student_mental_wellness_companion.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.studywell.student_mental_wellness_companion.entity.StudySession;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class StudySessionService {
    @PersistenceContext
    private EntityManager entityManager;

    public StudySession saveSession(StudySession session) {
        return entityManager.merge(session);
    }

    public Integer getTodayStudyTime(Long userId) {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(23, 59, 59);
        List<StudySession> sessions = entityManager.createQuery(
            "select s from StudySession s where s.userId = :userId "
                + "and s.startTime between :startOfDay and :endOfDay",
            StudySession.class)
            .setParameter("userId", userId)
            .setParameter("startOfDay", startOfDay)
            .setParameter("endOfDay", endOfDay)
            .getResultList();
        return sessions.stream().mapToInt(session -> session.getDurationMinutes()).sum();
    }
}