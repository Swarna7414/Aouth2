package com.Outh.Autht.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomUser {

    @Id
    private String id;
    private String given_name;
    private String family_name;
    private String name;
    private String email;

    private String picture;

    public CustomUser() {
    }

    public CustomUser(String id, String given_name, String family_name, String name, String email, String picture) {
        this.id = id;
        this.given_name = given_name;
        this.family_name = family_name;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
