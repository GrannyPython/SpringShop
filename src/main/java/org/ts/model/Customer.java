package org.ts.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by gp on 6/2/16.
 * <p>Basic entity of the application</p>
 * This class using for <i></>product classification</i>
 * Contains all requered field from technical documentation
 */

@Entity
@Table(name = "customer")
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends User {
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "birthday")
    private String date;
    @Column(name = "postal_PIN")
    private String postalPin;
    @Column(name = "street")
    private String street;
    @Column(name = "house")
    private String house;
    @Column(name = "flat")
    private String flat;
    @Column(name = "experience")
    private Integer experience;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    List<Order> orders = new ArrayList<Order>();


    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL})
    List<Cart> sc;

    public List<Cart> getSc() {
        return sc;
    }

    public void setSc(List<Cart> sc) {
        this.sc = sc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalPin() {
        return postalPin;
    }

    public void setPostalPin(String postalPin) {
        this.postalPin = postalPin;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public void setFlatNumber(String flatNumber) {
        this.flat = flatNumber;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }


    public Customer(String name, String surname, String date, String email,
                    String phone, String password, String country,
                    String city, String post_code, String street,
                    String house, String flat, Integer role) {
        super(name, surname, phone, email, password, role);
        this.city = city;
        this.country = country;
        this.date = date;
        this.postalPin = post_code;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.experience = 0;
    }

    public Customer() {
    }
}
