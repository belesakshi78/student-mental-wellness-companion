package com.studywell.student_mental_wellness_companion.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Note {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SuppressWarnings("unused")
    private Long id;
    private Long userId;
    private String title;
    @Column(length = 2000)
    private String content;
    private LocalDateTime createdAt;

    public Note(String content, LocalDateTime createdAt, Long id, String title, Long userId) {
        this.content = content;
        this.createdAt = createdAt;
        this.id = id;
        this.title = title;
        this.userId = userId;
    }
}
