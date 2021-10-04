package com.example.masterwork.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends BusinessObject{
        private String name;
        private String mail;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Filament> filaments = new ArrayList<>();

    public User() {
    }

    public User(Long id, String name, String mail, List<Filament> filaments) {
        super(id);
        this.name = name;
        this.mail = mail;
        this.filaments = filaments;
    }

    public User(String name, String mail, List<Filament> filaments) {
        this.name = name;
        this.mail = mail;
        this.filaments = filaments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Filament> getFilaments() {
        return filaments;
    }

    public void setFilaments(List<Filament> filaments) {
        this.filaments = filaments;
    }
}
