package ru.kpfu.it;

import java.util.Collection;

import ru.kpfu.it.model.Todo;

public interface TodoStore {
	public void add(Todo todo);
	public Todo get(Long id);
	public Collection<Todo> getAll();
	public Long size();
}
