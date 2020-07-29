package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntry timeEntry;
    private TimeEntryRepository repository;

    public TimeEntryController(TimeEntryRepository repository){
        this.repository = repository;
    }


    @GetMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(TimeEntry addTimeEntry){
        ResponseEntity<TimeEntry> response = new ResponseEntity(timeEntry,  HttpStatus.CREATED);
        return response;
    }
    public ResponseEntity<TimeEntry> create(TimeEntryRepository timeEntryRepository){
        ResponseEntity<TimeEntry> response = new ResponseEntity(timeEntryRepository,  HttpStatus.CREATED);
        return response;
    }

    public ResponseEntity<TimeEntry> read(long timeEntryId) {
        ResponseEntity<TimeEntry> response = new ResponseEntity<>(repository.find(timeEntryId), HttpStatus.OK);
        return response;
    }

    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<List<TimeEntry>>(repository.list(), HttpStatus.OK);
    }

    public ResponseEntity<TimeEntry> update(long timeEntryId, TimeEntry expected) {
        return new ResponseEntity<TimeEntry>(repository.update(timeEntryId, expected), HttpStatus.OK);
    }

    public ResponseEntity delete(long timeEntryId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
