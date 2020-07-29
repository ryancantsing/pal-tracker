package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository extends TimeEntryRepository {

    private Map<Long, TimeEntry> entries = new HashMap<>();
    private long nextIndex = 0;

    @Override
    public TimeEntry create(TimeEntry timeEntry){
        nextIndex++;

        TimeEntry timeEntry1 = new TimeEntry(nextIndex, timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours());
        entries.put(nextIndex, timeEntry1);
        return timeEntry1;
    }

    @Override
    public TimeEntry find(long id){
        return entries.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> newList = new ArrayList<>(entries.values());
        return newList;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry){
        TimeEntry updatedEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        entries.replace(id, updatedEntry);
        return entries.get(id);
    }

    @Override
    public void delete(long id) {
        entries.remove(id);
    }


}
