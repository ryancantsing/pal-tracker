package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(long projectId, long userId, LocalDate date, int hours){
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours){
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry() {

    }

    public long getProjectId(){
        return projectId;
    }

    public long getUserId(){
        return userId;
    }

    public long getId(){
        return id;
    }

    public int getHours(){
        return hours;
    }

    public LocalDate getDate(){
        return date;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, projectId, userId, date, hours);
    }

    @Override
    public String toString(){
        return "TimeEntry{" + "id=" + id +", projectId=" + projectId + ", userId=" + userId + ", date=" + date + ", hours=" + hours +"}";
    }


}
