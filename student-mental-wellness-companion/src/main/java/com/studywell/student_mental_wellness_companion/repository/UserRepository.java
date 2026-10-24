package com.studywell.student_mental_wellness_companion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studywell.student_mental_wellness_companion.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
