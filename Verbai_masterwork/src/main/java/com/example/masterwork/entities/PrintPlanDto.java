package com.example.masterwork.entities;

public class PrintPlanDto {
    Long id;
    String projectName;
    Double filamentLength;
    Double time;
    Double allCosts;
    String printStatus;
    String fileName;
    String printerName;

    public PrintPlanDto() {
    }

    public PrintPlanDto(Long id, String projectName, Double filamentLength, Double time, Double allCosts, String printStatus, String fileName, String printerName) {
        this.id = id;
        this.projectName = projectName;
        this.filamentLength = filamentLength;
        this.time = time;
        this.allCosts = allCosts;
        this.printStatus = printStatus;
        this.fileName = fileName;
        this.printerName = printerName;
    }

    public PrintPlanDto(String projectName, Double filamentLength, Double time, Double allCosts, String printStatus, String fileName, String printerName) {
        this.projectName = projectName;
        this.filamentLength = filamentLength;
        this.time = time;
        this.allCosts = allCosts;
        this.printStatus = printStatus;
        this.fileName = fileName;
        this.printerName = printerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Double getFilamentLength() {
        return filamentLength;
    }

    public void setFilamentLength(Double filamentLength) {
        this.filamentLength = filamentLength;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Double getAllCosts() {
        return allCosts;
    }

    public void setAllCosts(Double allCosts) {
        this.allCosts = allCosts;
    }

    public String getPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(String printStatus) {
        this.printStatus = printStatus;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    @Override
    public String toString() {
        return "PrintPlanDto{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", filamentLength=" + filamentLength +
                ", time=" + time +
                ", allCosts=" + allCosts +
                ", printStatus='" + printStatus + '\'' +
                ", fileName='" + fileName + '\'' +
                ", printerName='" + printerName + '\'' +
                '}';
    }
}
