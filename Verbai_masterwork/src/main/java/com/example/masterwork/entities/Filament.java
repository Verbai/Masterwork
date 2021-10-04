package com.example.masterwork.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "filament")
public class Filament extends BusinessObject {
    private Double weight;
    private Double Length;
    private Double density;
    private Double price;
    private Double diameter;
    private String producer;
    private String material;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private User user;

    @ManyToMany(mappedBy = "compatibleFilaments")
    private List<Printer> compatiblePrinters;

    public Filament() {
    }

    public Filament(Long id, Double weight, Double length, Double density, Double price, Double diameter, String producer, String material, User user) {
        super(id);
        this.weight = weight;
        Length = length;
        this.density = density;
        this.price = price;
        this.diameter = diameter;
        this.producer = producer;
        this.material = material;
        this.user = user;
    }

    public Filament(Double weight, Double length, Double density, Double price, Double diameter, String producer, String material, User user) {
        this.weight = weight;
        Length = length;
        this.density = density;
        this.price = price;
        this.diameter = diameter;
        this.producer = producer;
        this.material = material;
        this.user = user;
    }

    public Filament(Long id, Double weight, Double length, Double density, Double price, Double diameter, String producer, String material, List<Printer> compatiblePrinters) {
        super(id);
        this.weight = weight;
        Length = length;
        this.density = density;
        this.price = price;
        this.diameter = diameter;
        this.producer = producer;
        this.material = material;
        this.compatiblePrinters = compatiblePrinters;
    }

    public Filament(Double weight, Double length, Double density, Double price, Double diameter, String producer, String material, List<Printer> compatiblePrinters) {
        this.weight = weight;
        Length = length;
        this.density = density;
        this.price = price;
        this.diameter = diameter;
        this.producer = producer;
        this.material = material;
        this.compatiblePrinters = compatiblePrinters;
    }

    public Filament(Long id, Double weight, Double length, Double density, Double price, Double diameter, String producer, String material) {
        super(id);
        this.weight = weight;
        Length = length;
        this.density = density;
        this.price = price;
        this.diameter = diameter;
        this.producer = producer;
        this.material = material;
    }

    public Filament(Double weight, Double length, Double density, Double price, Double diameter, String producer, String material) {
        this.weight = weight;
        Length = length;
        this.density = density;
        this.price = price;
        this.diameter = diameter;
        this.producer = producer;
        this.material = material;
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

    public List<Printer> getCompatiblePrinters() {
        return compatiblePrinters;
    }

    public void setCompatiblePrinters(List<Printer> compatiblePrinters) {
        this.compatiblePrinters = compatiblePrinters;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Filament{" +
                "weight=" + weight +
                ", Length=" + Length +
                ", density=" + density +
                ", price=" + price +
                ", diameter=" + diameter +
                ", producer='" + producer + '\'' +
                ", material='" + material + '\'' +
                ", user=" + user +
                ", compatiblePrinters=" + compatiblePrinters +
                '}';
    }
}


