package com.example.lawassistant;

public class ListData {

    private String state;
    private String district;

    private String name;
    private String specialization;
    private String experience;
    private String phone;
    private String email;
    private String location;

    private float rating;

    private int desc;
    private int image;

    public ListData(
            String name,
            String specialization,
            String experience,
            String phone,
            String email,
            String state,
            String district,
            String location,
            float rating,
            int desc,
            int image
    ) {

        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.phone = phone;
        this.email = email;

        this.state = state;
        this.district = district;

        this.location = location;
        this.rating = rating;
        this.desc = desc;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getExperience() {
        return experience;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return district;
    }

    public String getLocation() {
        return location;
    }

    public float getRating() {
        return rating;
    }

    public int getDesc() {
        return desc;
    }

    public int getImage() {
        return image;
    }
}