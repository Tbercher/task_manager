package com.trevorbercher.taskmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task {
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
    private LocalDateTime createdAt;

    public void setId(Long aLong) {
    }

    public void setCreatedAt(LocalDateTime now) {
    }

    public void setCompleted(boolean b) {
    }
}
