package ru.udisondev.taskmanager.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.udisondev.taskmanager.entity.Task;
import ru.udisondev.taskmanager.entity.TaskState;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.List;

public class FileSystemTaskRepository implements TaskRepository {

    private final static String PATH = "/Users/olga/Projects/ru/udisondev/taskmanager/src/main/resources/task";

    @Override
    public Task save(Task task) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(PATH)))) {
            var stringObjectView = task.toString();
            writer.write(stringObjectView + "\n");
            var objectMapper = new ObjectMapper();
            objectMapper.writeValue(writer, task);

            return task;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Task findById(Integer id) {
        return null;
    }

    @Override
    public List<Task> findByState(TaskState state) {
        return null;
    }

    @Override
    public List<Task> findByStartDateEquals(LocalDate startDate) {
        return null;
    }

    @Override
    public List<Task> findByFinishDateBefore(LocalDate finishDate) {
        return null;
    }
}
