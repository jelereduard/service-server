package com.example.roach.serviceLog;

import com.example.roach.option.Option;
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

    public void addOptionToLog(Long logId, Option option) {
        ServiceLog serviceLog = logRepository.findById(logId).get();
        System.out.println("------------ option ---------------------------" + serviceLog);
        List<Option> options = serviceLog.getLog();
        System.out.println("------------ option ---------------------------" + options);
        options.add(option);
        System.out.println("------------ option ---------------------------" + options);
        serviceLog.setLog(options);

        logRepository.save(serviceLog);
    }
}
