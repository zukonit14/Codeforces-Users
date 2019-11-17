package com.example.retrofitpractice;

public class User {

    private String lastName;

    private String firstName;

    private String country;

    private String rating;

    private String handle;

    private String avatar;

    private String maxRating;

    private String rank;

    private String organization;

    private String city;

    public String getMaxRating() {
        return maxRating;
    }

    public String getRank() {
        return rank;
    }

    public String getOrganisation() {
        return organization;
    }

    public String getCity() {
        return city;
    }

    public User(String lastName, String firstName, String country, String rating, String handle, String avatar, String maxRating, String rank, String organisation, String city) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.country = country;
        this.rating = rating;
        this.handle = handle;
        this.avatar = avatar;
        this.maxRating = maxRating;
        this.rank = rank;
        this.organization = organisation;
        this.city = city;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCountry() {
        return country;
    }

    public String getRating() {
        return rating;
    }

    public String getHandle() {
        return handle;
    }

    public String getAvatar() {
        return avatar;
    }
}
