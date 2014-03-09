package ru.kpfu.it.model;

import java.util.Date;
public class Todo {
    private static long lastId = 0;

    private Long id;
    private String title;
    private Boolean completed = false;
    private Date startDate;
    private Date endDate;

    public Todo(String title) {
        id = ++lastId;
        this.title = title;
        startDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
        if (completed) {
            endDate = new Date();
        } else {
            endDate = null;
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        return id.equals(todo.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
