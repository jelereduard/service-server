package com.example.roach.serviceLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/log")
@CrossOrigin(origins = "http://localhost:3000")
public class LogController {
    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public List<ServiceLog> getLogs() {
        return logService.getLogs();
    }

    @PostMapping
    public void registerNewLog(@RequestBody ServiceLog serviceLog) {
        logService.createLog(serviceLog);
    }

    @DeleteMapping(path = "{logId}")
    public void deleteLog(@PathVariable("logId") Long logId) {
        logService.deleteLog(logId);
    }
}
