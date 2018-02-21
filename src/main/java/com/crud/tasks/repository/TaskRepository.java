package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface TaskRepository extends CrudRepository<Task, Long> {
    @Override
    List<Task> findAll();

    Optional<Task> getTaskById(Long id);

    @Override
    Task save(Task task);

    @Override
    Optional<Task> findById(Long id);

    @Transactional
    void deleteTaskById(Long taskId);
}
