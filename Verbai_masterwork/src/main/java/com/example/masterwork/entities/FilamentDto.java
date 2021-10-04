package com.example.masterwork.entities;


import java.util.Set;

public class FilamentDto {
    private Long id;
    private Double weight;
    private Double Length;
    private Double density;
    private Double price;
    private Double diameter;
    private String producer;
    private String material;
    private String compatibilePrinters;
    private long userId;

    public FilamentDto() {
    }

    public FilamentDto(Long id, Double weight, Double length, Double density, Double price, Double diameter, String producer, String material, String compatibilePrinters, long userId) {
        this.id = id;
        this.weight = weight;
        Length = length;
        this.density = density;
        this.price = price;
        this.diameter = diameter;
        this.producer = producer;
        this.material = material;
        this.compatibilePrinters = compatibilePrinters;
        this.userId = userId;
    }

    public FilamentDto(Long id, Double weight, Double length, Double density, Double price, Double diameter, String producer, String material, long userId) {
        this.id = id;
        this.weight = weight;
        Length = length;
        this.density = density;
        this.price = price;
        this.diameter = diameter;
        this.producer = producer;
        this.material = material;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getLength() {
        return Length;
    }

    public void setLength(Double length) {
        Length = length;
    }

    public Double getDensity() {
        return density;
    }

    public void setDensity(Double density) {
        this.density = density;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCompatibilePrinters() {
        return compatibilePrinters;
    }

    public void setCompatibilePrinters(String compatibilePrinters) {
        this.compatibilePrinters = compatibilePrinters;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
