package com.example.masterwork.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "print_plan")
public class PrintPlan extends BusinessObject{
    String projectName;
    double filamentLength;
    double time;
    double allCosts;
    String printStatus;
    String fileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Printer printer;

    public PrintPlan() {
    }


    public PrintPlan(Long id, String projectName, double filamentLength, double time, double allCosts, String printStatus, String fileName, Printer printer) {
        super(id);
        this.projectName = projectName;
        this.filamentLength = filamentLength;
        this.time = time;
        this.allCosts = allCosts;
        this.printStatus = printStatus;
        this.fileName = fileName;
        this.printer = printer;
    }

    public PrintPlan(String projectName, double filamentLength, double time, double allCosts, String printStatus, String fileName, Printer printer) {
        this.projectName = projectName;
        this.filamentLength = filamentLength;
        this.time = time;
        this.allCosts = allCosts;
        this.printStatus = printStatus;
        this.fileName = fileName;
        this.printer = printer;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getFilamentLength() {
        return filamentLength;
    }

    public void setFilamentLength(double filamentLength) {
        this.filamentLength = filamentLength;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getAllCosts() {
        return allCosts;
    }

    public void setAllCosts(double allCosts) {
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

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
}
