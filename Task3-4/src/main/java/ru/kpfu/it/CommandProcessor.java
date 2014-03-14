package ru.kpfu.it;

import ru.kpfu.it.model.ToDo;

import java.util.Collection;
public interface CommandProcessor {
    void handleCreate(String title);
    boolean handleClose(Long id);
    boolean handleDelete(Long id);
    Collection<ToDo> handleList();
}
