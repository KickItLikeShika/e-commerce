package com.shika.ecomerce.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Column(name = "username", nullable = false)
    private String username;
    @NotNull
    @Column(name = "fullname", nullable = false)
    private String fullname;
    @NotNull
    @Column(name = "productId", nullable = false)
    private long productId;
    @NotNull
    @Column(name = "address", nullable = false)
    private String address;
    @NotNull
    @Column(name = "cityName", nullable = false)
    private String city;
    @NotNull
    @Column(name = "zipCode", nullable = false)
    private String zip;
    @NotNull
    @Column(name = "totalPrice", nullable = false)
    private String totalPrice;
    @Column(name = "phoneNumber", nullable = false)
    private String phone;

    public Order() {}

    public Order(String username, String fullname, String address, long productId,
                 String city, String zip, String totalPrice, String phone) {
        this.fullname = fullname;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.totalPrice = totalPrice;
        this.phone = phone;
        this.username = username;
        this.productId = productId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
