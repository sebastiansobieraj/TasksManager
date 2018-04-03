package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        //Given
        Task task = new Task(1L, "Test", "test_task");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(1L, taskDto.getId().longValue());
        assertEquals("Test", taskDto.getTitle());
        assertEquals("test_task", taskDto.getContent());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Test", "test_task");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(1L, task.getId().longValue());
        assertEquals("Test", task.getTitle());
        assertEquals("test_task", task.getContent());
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        Task task = new Task(1L, "Test", "test_task");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);

        //When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(tasks);

        //Then
        assertEquals(1, taskDtos.size());
    }
}