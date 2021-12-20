package com.example.roach.option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/option")
@CrossOrigin(origins = "http://localhost:3000")
public class OptionController {
    public final OptionService optionService;

    @Autowired
    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping
    public List<Option> getOptionList() {
        return optionService.getOptions();
    }

    @PutMapping
    public void addOption(@RequestBody Option option) {
        optionService.addOption(option);
    }
}
