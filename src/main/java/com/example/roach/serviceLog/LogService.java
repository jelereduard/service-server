package com.example.roach.serviceLog;

import com.example.roach.option.Option;
import com.example.roach.option.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    public void createLog(Long carId) {
        ServiceLog serviceLog = new ServiceLog(carId, LocalDate.now(),LocalDate.now().plusDays(2));
            logRepository.save(serviceLog);
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
        List<Option> options = serviceLog.getLog();
        options.add(option);
        serviceLog.setLog(options);

        logRepository.save(serviceLog);
    }

    public void addOptionsToLog(Long logId, OptionService optionService, Map<String, String> map) {
        System.out.println(map);
        ServiceLog serviceLog = logRepository.findById(logId).get();
        List<Option> options = new ArrayList<>();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if(entry.getValue().equals("1")) {
                Option option = optionService.getOptionById(Long.parseLong(entry.getKey()));
                options.add(option);
            }
        }
        serviceLog.setLog(options);
        logRepository.save(serviceLog);
    }
}
