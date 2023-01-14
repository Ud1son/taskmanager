package ru.udisondev.taskmanager.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Task implements Serializable {

    private Integer id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate finishDate;
    private TaskState state;

    public Task(String title, String description, LocalDate startDate, LocalDate finishDate, TaskState state) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.state = state;
    }
}
