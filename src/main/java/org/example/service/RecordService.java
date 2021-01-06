package org.example.service;

import org.example.model.Record;

import java.util.List;

public interface RecordService {
    List<Record> allRecord();
    void add(Record record);
    void delete(Record record);
    void edit(Record record);
    Record getById(int id);
    
}
