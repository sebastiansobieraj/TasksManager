package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
        return taskMapper.mapToTaskDtoList(service.getAllTasks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tasks/{taskId}")
    public TaskDto getTask(Long taskId) {
        return taskMapper.mapToTaskDto(service.getTaskById(taskId).orElseThrow(IllegalArgumentException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/tasks/{taskId}")
    public void deleteTask(String taskId) {

    }
    @RequestMapping(method = RequestMethod.PUT, value = "/tasks")
    public TaskDto updateTask(TaskDto taskDto) {
        return new TaskDto((long) 1, "Edited test title", "Test content");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tasks")
    public void createTask(TaskDto taskDto) {

    }
}
