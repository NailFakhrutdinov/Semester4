package ru.kpfu.it;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ru.kpfu.it.model.Todo;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Alexander Tchitchigin
 *         Date: 2/3/14
 *         Time: 2:22 AM
 */
public class TodoStoreSetImpl implements TodoStore {
    private Set<Todo> todoSet = new HashSet<Todo>();

    public void add(Todo todo) {
        todoSet.add(todo);
    }

    public Todo get(Long id) {
        for(Todo todo : todoSet) {
            if (todo.getId().equals(id))
                return todo;
        }
        return null;
    }

    /**
     *
     * @return unmodifiable set
     */
    public Collection<Todo> getAll() {
        return Collections.unmodifiableSet(todoSet);
    }

    public Long size() {
        return (long) todoSet.size();
    }
}





