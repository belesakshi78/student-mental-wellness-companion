package com.studywell.student_mental_wellness_companion.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "moods")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mood {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;  
    
    private String mood;  
    
    private String note;  
    
    private LocalDate date;
    
    @PrePersist
    protected void onCreate() {
        date = LocalDate.now();
    }
}