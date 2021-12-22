package com.example.roach.serviceLog;

import com.example.roach.option.Option;
import com.example.roach.option.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @PostMapping
    public void registerNewLog(@RequestBody ServiceLog serviceLog) {
        logService.createLog(serviceLog);
    }

    @DeleteMapping(path = "{logId}")
    public void deleteLog(@PathVariable("logId") Long logId) {
        logService.deleteLog(logId);
    }

//    @PutMapping(path = "{logId}/option/{optionId}")
//    public void addOptionToLog(@PathVariable Long logId, @PathVariable Long optionId) {
//        Option option = optionService.getOptionById(optionId);
//        System.out.println("------------ option ---------------------------" + option);
//        logService.addOptionToLog(logId, option);
//    }
    @PutMapping(path = "{logId}")
    public void addOptionsToLog(@PathVariable Long logId, @RequestBody Map<String, String> map) {
        logService.addOptionsToLog(logId,optionService, map);
    }

}
