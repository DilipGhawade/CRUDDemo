package com.meteorsoftech.cruddemo;

/**
 * Created by Delete on 6/24/2017.
 */

public class Dataprovider {

    private String name;
    private String mob;
    private String email;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Dataprovider(String name, String mob, String email, String address)
    {
        this.name=name;
        this.mob=mob;
        this.email=email;
        this.address=address;

    }
}
