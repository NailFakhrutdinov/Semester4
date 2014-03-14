package ru.kpfu.it.model;

import java.util.Date;

public class ToDo {
    private Long id;
    private String title;
    private Date start;
    private Date end;

    public ToDo(Long id, String title) {
        this.id = id;
        this.title = title;
        start = new Date();
    }

    public boolean isCompleted() {
        return end != null;
    }

    public void setCompleted(boolean completed) {
        if (completed) {
            end = new Date();
        } else {
            end = null;
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
