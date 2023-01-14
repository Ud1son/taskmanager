package ru.udisondev.taskmanager.service;

import ru.udisondev.taskmanager.entity.Task;
import ru.udisondev.taskmanager.entity.TaskState;
import ru.udisondev.taskmanager.persistence.TaskRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static java.util.Optional.ofNullable;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task createTask(Task task) {
        return repository.save(task);
    }

    @Override
    public boolean completeTaskById(Integer id) {
        return ofNullable(repository.findById(id))
                .map(changeStatus())
                .map(repository::save)
                .isPresent();
    }

    private static Function<Task, Task> changeStatus() {
        return t -> {
            t.setState(TaskState.COMPLETED);
            return t;
        };
    }

    @Override
    public List<Task> findByState(TaskState state) {
        return repository.findByState(state);
    }

    @Override
    public List<Task> findByStartDate(LocalDate startDate) {
        return repository.findByStartDateEquals(startDate);
    }
}
