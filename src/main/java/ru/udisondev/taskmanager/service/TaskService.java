package ru.udisondev.taskmanager.service;

import ru.udisondev.taskmanager.entity.Task;
import ru.udisondev.taskmanager.entity.TaskState;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    /**
     * Меняет статус задачи с указанным идентификатором на переданный.
     * @param id - идентификатор задачи
     * @return true если статус удалось изменить false если задачи с указанным идентификатором не было найдено
     */
    boolean completeTaskById(Integer id);

    List<Task> findByState(TaskState state);

    List<Task> findByStartDate(LocalDate startDate);
}
