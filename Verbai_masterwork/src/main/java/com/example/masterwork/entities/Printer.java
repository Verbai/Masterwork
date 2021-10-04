package com.example.masterwork.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "printer")
public class Printer extends BusinessObject {
    private String name;
    private String printerType;
    private Double printSize;
    private Double acceptedFilamentDiameter;
    private Double maxTemperature;
    private Double operationCostPerHour;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(
            name = "compatible_filaments",
            joinColumns = @JoinColumn(name = "filament_id"),
            inverseJoinColumns = @JoinColumn(name = "printer_id"))
    private List<Filament> compatibleFilaments;


    @OneToMany(mappedBy = "printer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PrintPlan> plans = new ArrayList<>();

    public Printer() {
    }

    public Printer(Long id, String name, String printerType, Double printSize, Double acceptedFilamentDiameter, Double maxTemperature, Double operationCostPerHour, List<Filament> compatibleFilaments) {
        super(id);
        this.name = name;
        this.printerType = printerType;
        this.printSize = printSize;
        this.acceptedFilamentDiameter = acceptedFilamentDiameter;
        this.maxTemperature = maxTemperature;
        this.operationCostPerHour = operationCostPerHour;
        this.compatibleFilaments = compatibleFilaments;
    }

    public Printer(String name, String printerType, Double printSize, Double acceptedFilamentDiameter, Double maxTemperature, Double operationCostPerHour, List<Filament> compatibleFilaments) {
        this.name = name;
        this.printerType = printerType;
        this.printSize = printSize;
        this.acceptedFilamentDiameter = acceptedFilamentDiameter;
        this.maxTemperature = maxTemperature;
        this.operationCostPerHour = operationCostPerHour;
        this.compatibleFilaments = compatibleFilaments;
    }

    public Printer(Long id, String name, String printerType, Double printSize, Double acceptedFilamentDiameter, Double maxTemperature, Double operationCostPerHour, List<Filament> compatibleFilaments, List<PrintPlan> plans) {
        super(id);
        this.name = name;
        this.printerType = printerType;
        this.printSize = printSize;
        this.acceptedFilamentDiameter = acceptedFilamentDiameter;
        this.maxTemperature = maxTemperature;
        this.operationCostPerHour = operationCostPerHour;
        this.compatibleFilaments = compatibleFilaments;
        this.plans = plans;
    }

    public Printer(String name, String printerType, Double printSize, Double acceptedFilamentDiameter, Double maxTemperature, Double operationCostPerHour, List<Filament> compatibleFilaments, List<PrintPlan> plans) {
        this.name = name;
        this.printerType = printerType;
        this.printSize = printSize;
        this.acceptedFilamentDiameter = acceptedFilamentDiameter;
        this.maxTemperature = maxTemperature;
        this.operationCostPerHour = operationCostPerHour;
        this.compatibleFilaments = compatibleFilaments;
        this.plans = plans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrinterType() {
        return printerType;
    }

    public void setPrinterType(String printerType) {
        this.printerType = printerType;
    }

    public Double getPrintSize() {
        return printSize;
    }

    public void setPrintSize(Double printSize) {
        this.printSize = printSize;
    }

    public Double getAcceptedFilamentDiameter() {
        return acceptedFilamentDiameter;
    }

    public void setAcceptedFilamentDiameter(Double acceptedFilamentDiameter) {
        this.acceptedFilamentDiameter = acceptedFilamentDiameter;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getOperationCostPerHour() {
        return operationCostPerHour;
    }

    public void setOperationCostPerHour(Double operationCostPerHour) {
        this.operationCostPerHour = operationCostPerHour;
    }

    public List<Filament> getCompatibleFilaments() {
        return compatibleFilaments;
    }

    public void setCompatibleFilaments(List<Filament> compatibleFilaments) {
        this.compatibleFilaments = compatibleFilaments;
    }

    public List<PrintPlan> getPlans() {
        return plans;
    }

    public void setPlans(List<PrintPlan> plans) {
        this.plans = plans;
    }

    @Override
    public String toString() {
        return "Printer{" +
                "name='" + name + '\'' +
                ", printerType='" + printerType + '\'' +
                ", printSize=" + printSize +
                ", acceptedFilamentDiameter=" + acceptedFilamentDiameter +
                ", maxTemperature=" + maxTemperature +
                ", operationCostPerHour=" + operationCostPerHour +
                ", compatibleFilaments=" + compatibleFilaments +
                ", plans=" + plans +
                '}';
    }
}
