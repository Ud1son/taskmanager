package ru.udisondev.taskmanager.persistence;

import ru.udisondev.taskmanager.entity.Task;
import ru.udisondev.taskmanager.entity.TaskState;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository {

    /**
     * Сохраняет переданный объект Task {@link Task}
     * @param task - объект который нужно сохранить
     * @return task в сохраненном состаянии.
     */
    Task save(Task task);

    /**
     * Возвращает Task с указанным идентификатором
     * @param id - идентификатор задачи
     * @return задачу с указанным идентификатором
     */
    Task findById(Integer id);

    List<Task> findByState(TaskState state);

    List<Task> findByStartDateEquals(LocalDate startDate);

    List<Task> findByFinishDateBefore(LocalDate finishDate);
}
