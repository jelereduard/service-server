package com.example.roach.serviceLog;

import com.example.roach.option.Option;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class ServiceLog {
    @Id
    @SequenceGenerator(
            name = "log_sequence",
            sequenceName = "log_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "log_sequence"
    )
    private Long id;

    private Long carId;
    private LocalDate entryDate;
    private LocalDate exitDate;
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "service_log_id"),
            inverseJoinColumns = @JoinColumn(name = "log_id")
    )
    private List<Option> log;

    public ServiceLog() {
    }

    public ServiceLog(Long carId ,LocalDate entryDate, LocalDate exitDate) {
        this.carId = carId;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public List<Option> getLog() {
        return log;
    }

    public void setLog(List<Option> log) {
        this.log = log;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDate exitDate) {
        this.exitDate = exitDate;
    }

    public Double calcTotalPrice() {
        return log.isEmpty() ? 0.0 : log.stream().mapToDouble(Option::getPrice).sum();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ServiceLog{" +
                "carId=" + carId +
                ", log=" + log +
                ", entryDate=" + entryDate +
                ", exitDate=" + exitDate +
                '}';
    }
}
