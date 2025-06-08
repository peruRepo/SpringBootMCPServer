package com.example.mcp;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryRecordService {

    private final MemoryRecordRepository repository;

    public MemoryRecordService(MemoryRecordRepository repository) {
        this.repository = repository;
    }

    public MemoryRecord save(String user, String content) {
        MemoryRecord record = new MemoryRecord(user, content);
        return repository.save(record);
    }

    public List<MemoryRecord> findByUser(String user) {
        return repository.findByUser(user);
    }

    public List<MemoryRecord> searchByContent(String text) {
        return repository.searchByContent(text);
    }
}
