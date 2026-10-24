package com.studywell.student_mental_wellness_companion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studywell.student_mental_wellness_companion.entity.Mood;

public interface MoodRepository extends JpaRepository<Mood, Long> {
    List<Mood> findByUserId(Long userId);
}