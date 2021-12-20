package com.example.roach.serviceLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<ServiceLog> getLogs() {
        return logRepository.findAll();
    }

    public ServiceLog findLogByCarId(Long id) {
        return logRepository.findLogByCarId(id).get();
    }

    public void createLog(ServiceLog serviceLog) {
        if (logRepository.existsById(serviceLog.getId())) {
            logRepository.getById(serviceLog.getId()).setLog(serviceLog.getLog());
        } else {
            logRepository.save(serviceLog);
        }
    }

    public void deleteLog(Long logId) {
        if (logRepository.existsById(logId)) {
            logRepository.deleteById(logId);
        } else {
            throw new IllegalStateException("log with id: " + logId + " does not exist");
        }
    }
}
