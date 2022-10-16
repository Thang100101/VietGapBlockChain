package com.example.ofood.Models;

import java.util.List;

public class TinhThanh {
    private String name,division_type,codename;
    private List<String> districts;
    private int code,phone_code;

    public TinhThanh(String name, String division_type, String codename, List<String> districts, int code, int phone_code) {
        this.name = name;
        this.division_type = division_type;
        this.codename = codename;
        this.districts = districts;
        this.code = code;
        this.phone_code = phone_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDivision_type() {
        return division_type;
    }

    public void setDivision_type(String division_type) {
        this.division_type = division_type;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public List<String> getDistricts() {
        return districts;
    }

    public void setDistricts(List<String> districts) {
        this.districts = districts;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPhone_code() {
        return phone_code;
    }

    public void setPhone_code(int phone_code) {
        this.phone_code = phone_code;
    }

    @Override
    public String toString() {
        return "TinhThanh{" +
                "name='" + name + '\'' +
                ", division_type='" + division_type + '\'' +
                ", codename='" + codename + '\'' +
                ", districts='" + districts + '\'' +
                ", code=" + code +
                ", phone_code=" + phone_code +
                '}';
    }
}
