package com.studywell.student_mental_wellness_companion.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.studywell.student_mental_wellness_companion.entity.User;
import com.studywell.student_mental_wellness_companion.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    
    public User registerUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }
    
    public User loginUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }
        throw new RuntimeException("Invalid email or password");
    }
}