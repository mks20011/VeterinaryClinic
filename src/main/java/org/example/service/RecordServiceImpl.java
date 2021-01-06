package org.example.service;

import org.example.dao.RecordDao;
import org.example.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RecordServiceImpl implements RecordService {

    private RecordDao recordDao;

    @Autowired
    public void setRecordDao(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    @Override
    @Transactional
    public List<Record> allRecord() {
        return recordDao.allRecord();
    }

    @Override
    @Transactional
    public void add(Record record) {
        recordDao.add(record);
    }

    @Override
    @Transactional
    public void delete(Record record) {
        recordDao.delete(record);
    }

    @Override
    @Transactional
    public void edit(Record record) {
        recordDao.edit(record);
    }

    @Override
    @Transactional
    public Record getById(int id) {
        return recordDao.getById(id);
    }
}
