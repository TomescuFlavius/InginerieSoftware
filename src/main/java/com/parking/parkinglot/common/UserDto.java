package com.parking.parkinglot.common;

public class UserDto {
     long id;
     String username;
     String email;

    // Constructor
    public UserDto(Long id, String username, String email) {

        this.id = id;
        this.username = username;
        this.email = email;

    }

    public long getId() {
        return id;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}