package com.kpfu.itis.service.impl;

import com.kpfu.itis.model.ToDo;
import com.kpfu.itis.repository.ToDoRepository;
import com.kpfu.itis.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements TodoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public List<ToDo> getAll() {
        return (List<ToDo>)toDoRepository.findAll();
    }

    @Override
    public ToDo getById(Long id) {
        return toDoRepository.findOne(id);
    }

    @Override
    public void deleteToDo(Long id) {
        toDoRepository.delete(id);
    }

    @Override
    public void updateToDo(ToDo todo) {
        toDoRepository.save(todo);
    }

    @Override
    public void saveToDo(ToDo todo) {
        toDoRepository.save(todo);
    }
}
