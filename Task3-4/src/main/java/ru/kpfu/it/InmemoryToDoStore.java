package ru.kpfu.it;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ru.kpfu.it.model.ToDo;
public class InmemoryToDoStore implements ToDoStore {
    private long nextId = 0;

    private Set<ToDo> todos = new HashSet<ToDo>();

    public ToDo get(Long id) {
        for (ToDo todo : todos) {
            if (todo.getId().equals(id)) return todo;
        }
        return null;
    }

    public Collection<ToDo> getAll() {
        return Collections.unmodifiableSet(todos);
    }

    public void add(String title) {
        final ToDo todo = new ToDo(++nextId, title);
        todos.add(todo);
    }

    public boolean delete(Long id) {
        ToDo todo = null;
        for (ToDo t : todos) {
            if (t.getId().equals(id)) {
                todo = t;
                break;
            }
        }
        if (todo != null) {
            todos.remove(todo);
            return true;
        }
        return false;
    }
}
