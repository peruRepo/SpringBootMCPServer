package com.example.mcp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemoryRecordRepository extends JpaRepository<MemoryRecord, Long> {

    List<MemoryRecord> findByUser(String user);

    @Query(value = "SELECT * FROM memory_records WHERE content::text ILIKE %:text%", nativeQuery = true)
    List<MemoryRecord> searchByContent(@Param("text") String text);
}
