package ru.kpfu.it;

import ru.kpfu.it.model.ToDo;

import java.util.Collection;

public interface ToDoStore {
    ToDo get(Long id);
    Collection<ToDo> getAll();
    void add(String title);
    boolean delete(Long id);
}
