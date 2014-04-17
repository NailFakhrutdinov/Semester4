package com.kpfu.itis.service;

import com.kpfu.itis.model.ToDo;

import java.util.List;

public interface TodoService {

    List<ToDo> getAll();
    ToDo getById(Long id);
    void deleteToDo(Long id);
    void updateToDo(ToDo todo);
    void saveToDo(ToDo todo);

}
