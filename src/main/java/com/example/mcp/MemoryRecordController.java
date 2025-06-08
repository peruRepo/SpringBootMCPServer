package com.example.mcp;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/memories")
public class MemoryRecordController {

    private final MemoryRecordService service;

    public MemoryRecordController(MemoryRecordService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<MemoryRecord> createMemory(@RequestBody MemoryRequest request) {
        return Mono.fromSupplier(() -> service.save(request.user(), request.content()));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<MemoryRecord> listMemories(@RequestParam(required = false) String user,
                                           @RequestParam(required = false) String search) {
        if (search != null && !search.isEmpty()) {
            List<MemoryRecord> result = service.searchByContent(search);
            return Flux.fromIterable(result);
        }
        if (user != null) {
            List<MemoryRecord> result = service.findByUser(user);
            return Flux.fromIterable(result);
        }
        List<MemoryRecord> all = service.searchByContent("");
        return Flux.fromIterable(all);
    }

    public record MemoryRequest(String user, String content) {}
}
