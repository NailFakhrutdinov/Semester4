package ru.kpfu.it;

import ru.kpfu.it.model.Todo;
public class App {
	private TodoStore store;
	public App(TodoStore store) {
		this.store = store;
	}
    public String addTodo(final String input) {
        String[] parts = input.trim().split("\\s+", 2);
        if (parts.length == 2) {
            store.add(new Todo(parts[1]));
            return "Done.";
        } else {
            return "Missing title.";
        }
    }

    public String listAll() {
        StringBuilder sb = new StringBuilder();
        for (Todo todo : store.getAll()) {
            sb.append(String.format("%d: %s - %s\n",
                    todo.getId(), todo.getTitle(),
                    (todo.getCompleted()) ? "completed" : "open"));
        }
        return sb.toString();
    }
    public Long size() {
    	return store.size();
    }
}






