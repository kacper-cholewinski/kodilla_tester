package com.kodilla.hibernate.task.repository;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.hibernate.tasklist.repository.TaskListRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TaskListRepositoryTestSuite {
    @Autowired
    private TaskListRepository taskListRepository;

    @Test
    void testFindByListName() {
        TaskList taskList = new TaskList("example name", "example description");
        taskListRepository.save(taskList);
        String listName = taskList.getListName();

        //When
        List<TaskList> readTaskLists = taskListRepository.findByListName(listName);

        //Then
        Assertions.assertEquals(1, readTaskLists.size());

        //CleanUp
        int id = readTaskLists.getFirst().getId();
        taskListRepository.deleteById(id);
    }
}