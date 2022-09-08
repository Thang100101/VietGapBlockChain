package com.example.ofood.Models;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String barcode;
    private boolean isExpired;
    private String phone;
    private String address;
    private String vietGapCode;
    private String date;
    private String technicality;
    private String environment;
    private String origin;
//    private Certification certification;
//    private String foodSafety;
//    private byte[] image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVietGapCode() {
        return vietGapCode;
    }

    public void setVietGapCode(String vietGapCode) {
        this.vietGapCode = vietGapCode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTechnicality() {
        return technicality;
    }

    public void setTechnicality(String technicality) {
        this.technicality = technicality;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

//    public Certification getCertification() {
//        return certification;
//    }
//
//    public void setCertification(Certification certification) {
//        this.certification = certification;
//    }
//
//    public String getFoodSafety() {
//        return foodSafety;
//    }
//
//    public void setFoodSafety(String foodSafety) {
//        this.foodSafety = foodSafety;
//    }
//
//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }
}
