package com.example.roach.option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OptionService {
    private final OptionRepository optionRepository;

    @Autowired
    public OptionService(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    public List<Option> getOptions() {
        return optionRepository.findAll();
    }

    public void addOption(Option option) {
        optionRepository.save(option);
    }

    public Option getOptionById(Long optionId) {
        return optionRepository.getById(optionId);
    }
}
