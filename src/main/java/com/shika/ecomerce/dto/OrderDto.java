package com.shika.ecomerce.dto;

public class OrderDto {

    private String fullname;
    private String address;
    private String city;
    private String zip;
    private String phone;
    private long productId;

    public OrderDto() {}

    public OrderDto(String fullname, String address, String city, String zip, String phone,
                    long productId) {
        this.fullname = fullname;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.productId = productId;
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
