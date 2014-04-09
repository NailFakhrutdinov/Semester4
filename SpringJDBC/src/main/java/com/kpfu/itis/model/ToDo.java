package com.kpfu.itis.model;


import org.joda.time.DateTime;


public class ToDo {
    private  DateTime time = new DateTime();
    private Long id;
    private String title;
    private String start;
    private String end;

    public ToDo(String title) {
        this();
        this.title = title;
    }

    public ToDo() {
        start = getTime();
    }

    public boolean isCompleted() {
        return end != null;
    }

    public void setCompleted(boolean completed) {
        if (completed) {
            end = getTime();
        } else {
            end = null;
        }
    }


    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToDo toDo = (ToDo) o;

        if (!start.equals(toDo.start)) return false;
        if (!title.equals(toDo.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + start.hashCode();
        return result;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStart() {

        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    private String getTime() {
        return time.getDayOfMonth() + "." + time.getMonthOfYear() + "." + time.getYear() +
                " " + time.getHourOfDay() + ":" + time.getMinuteOfHour() + ":" + time.getSecondOfMinute();
    }
}

