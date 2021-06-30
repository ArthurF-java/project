package com.artur_f.project.entity;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="surname")
    private String surname;
    @Column(name="name")
    private String name;
    @Column(name="phone")
    private String phone;
    @Column(name="address_city")
    private String cityCustomer;
    @Column(name="address_street")
    private String streetCustomer;
    @Column(name= "address_house")
    private int houseCustomer;
    @Column(name = "address_flat")
    private int flatCustomer;

    public Customer() {
    }

    public Customer(long id, String surname, String name, String phone, String cityCustomer, String streetCustomer, int homeCustomer, int flatCustomer) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.cityCustomer = cityCustomer;
        this.streetCustomer = streetCustomer;
        this.houseCustomer = homeCustomer;
        this.flatCustomer = flatCustomer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCityCustomer() {
        return cityCustomer;
    }

    public void setCityCustomer(String cityCustomer) {
        this.cityCustomer = cityCustomer;
    }

    public String getStreetCustomer() {
        return streetCustomer;
    }

    public void setStreetCustomer(String streetCustomer) {
        this.streetCustomer = streetCustomer;
    }

    public int getHouseCustomer() {
        return houseCustomer;
    }

    public void setHouseCustomer(int homeCustomer) {
        this.houseCustomer = homeCustomer;
    }

    public int getFlatCustomer() {
        return flatCustomer;
    }

    public void setFlatCustomer(int flatCustomer) {
        this.flatCustomer = flatCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", cityCustomer='" + cityCustomer + '\'' +
                ", streetCustomer='" + streetCustomer + '\'' +
                ", houseCustomer=" + houseCustomer +
                ", flatCustomer=" + flatCustomer +
                '}';
    }
}
