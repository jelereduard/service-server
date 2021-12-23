package com.example.roach.serviceLog;

import com.example.roach.option.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/log")
@CrossOrigin(origins = "http://localhost:3000")
public class LogController {
    private final LogService logService;
    private final OptionService optionService;

    @Autowired
    public LogController(LogService logService, OptionService optionService) {
        this.logService = logService;
        this.optionService = optionService;
    }

    @GetMapping
    public List<ServiceLog> getLogs() {
        return logService.getLogs();
    }

    @PostMapping(path = "car/{carId}")
    public void registerNewLog(@PathVariable Long carId) {
        logService.createLog(carId);
    }

    @DeleteMapping(path = "{logId}")
    public void deleteLog(@PathVariable("logId") Long logId) {
        logService.deleteLog(logId);
    }

    @PutMapping(path = "{logId}")
    public void addOptionsToLog(@PathVariable Long logId, @RequestBody Map<String, String> map) {
        logService.addOptionsToLog(logId,optionService, map);
    }

}
