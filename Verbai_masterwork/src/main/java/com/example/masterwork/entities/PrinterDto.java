package com.example.masterwork.entities;

public class PrinterDto  {
    private Long id;
    private String name;
    private String printerType;
    private Double printSize;
    private Double acceptedFilamentDiameter;
    private Double maxTemperature;
    private Double operationCostPerHour;
    private String availableFilaments;
    private String printPlanIds;

    public PrinterDto() {
    }

    public PrinterDto(Long id, String name, String printerType, Double printSize, Double acceptedFilamentDiameter, Double maxTemperature, Double operationCostPerHour, String availableFilaments, String printPlanIds) {
        this.id = id;
        this.name = name;
        this.printerType = printerType;
        this.printSize = printSize;
        this.acceptedFilamentDiameter = acceptedFilamentDiameter;
        this.maxTemperature = maxTemperature;
        this.operationCostPerHour = operationCostPerHour;
        this.availableFilaments = availableFilaments;
        this.printPlanIds = printPlanIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAvailableFilaments() {
        return availableFilaments;
    }

    public void setAvailableFilaments(String availableFilaments) {
        this.availableFilaments = availableFilaments;
    }

    public String getPrintPlanIds() {
        return printPlanIds;
    }

    public void setPrintPlanIds(String printPlanIds) {
        this.printPlanIds = printPlanIds;
    }

    @Override
    public String toString() {
        return "PrinterDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", printerType='" + printerType + '\'' +
                ", printSize=" + printSize +
                ", acceptedFilamentDiameter=" + acceptedFilamentDiameter +
                ", maxTemperature=" + maxTemperature +
                ", operationCostPerHour=" + operationCostPerHour +
                ", availableFilaments='" + availableFilaments + '\'' +
                ", printPlanIds='" + printPlanIds + '\'' +
                '}';
    }
}
