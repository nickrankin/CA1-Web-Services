package com.nickrankin.ca1.CA1.Web.Services.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    // Needed empty constructor https://stackoverflow.com/questions/44088360/org-hibernate-instantiationexception-no-default-constructor-for-entity-princ
    public User() {}

    @JsonProperty("returns")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userId")
    private List<Return> returns;


    private @Id @GeneratedValue Long id;
    private String name;
    private String address;
    private String ppsNumber;
    @JsonIgnore
    private String pin;

    public User(String name, String address, String ppsNumber, String pin) {
        this.name = name;
        this.address = address;
        this.ppsNumber = ppsNumber;
        this.pin = pin;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPpsNumber() {
        return ppsNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(address, user.address) && Objects.equals(ppsNumber, user.ppsNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, ppsNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "taxReturns=" + returns +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", ppsNumber='" + ppsNumber + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
