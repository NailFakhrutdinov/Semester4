package ru.kpfu.it;

import java.util.Collection;

import ru.kpfu.it.model.ToDo;
public class CommandProcessorImpl implements CommandProcessor {
    private ToDoStore store;
    public CommandProcessorImpl(ToDoStore store) {
        this.store = store;
    }

    public void handleCreate(String title) {
        store.add(title);
    }

    public boolean handleClose(Long id) {
    	ToDo todo = store.get(id);
    	if(todo != null) {
    		todo.setCompleted(true);
    		return true;
    	}
    	return false;
    }

    public boolean handleDelete(Long id) {
        return store.delete(id);
    }

    public Collection<ToDo> handleList() {
    	return store.getAll();
    }
}
