package ru.udisondev.taskmanager;

import ru.udisondev.taskmanager.entity.Task;
import ru.udisondev.taskmanager.entity.TaskState;
import ru.udisondev.taskmanager.persistence.FileSystemTaskRepository;
import ru.udisondev.taskmanager.service.MESSAGE;
import ru.udisondev.taskmanager.service.TaskService;
import ru.udisondev.taskmanager.service.TaskServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Application {

    private final static TaskService taskService;

    static {
        taskService = new TaskServiceImpl(new FileSystemTaskRepository());
    }


    public static void startApp() {
        System.out.println(MESSAGE.START_MESSAGE.getMessage());
        System.out.println(MESSAGE.COMMANDS.getMessage());
        try (BufferedReader keyBoardReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                var command =  keyBoardReader.readLine();
                switch (command) {
                    case "/create":
                        createTask(keyBoardReader);
                    default:
                        System.out.printf("Unknown command: %s%n", command);
                }
            }
        } catch (Exception e) {

        }

    }

    private static void createTask(BufferedReader keyBoardReader) throws IOException {
        System.out.print("Введите название: ");
        var title = keyBoardReader.readLine();
        System.out.println("");
        System.out.print("Введите описание: ");
        var description = keyBoardReader.readLine();
        System.out.println("");
        System.out.print("Введите дату начала: ");
        var startDate = keyBoardReader.readLine();
        System.out.println("");
        System.out.print("Введите дату окончания: ");
        System.out.println("");
        var finishDate = keyBoardReader.readLine();
        var task = new Task(title,
                description,
                LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                LocalDate.parse(finishDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                TaskState.NEW);
        taskService.createTask(task);
        System.out.printf("Задача создана: %s", task);
    }
}
