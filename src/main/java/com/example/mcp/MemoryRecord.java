package com.example.mcp;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "memory_records")
public class MemoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String user;

    @Column(columnDefinition = "jsonb", nullable = false)
    private String content;

    @Column(nullable = false)
    private Instant createdAt = Instant.now();

    public MemoryRecord() {}

    public MemoryRecord(String user, String content) {
        this.user = user;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
