package com.example.globality.Users;

import javax.persistence.*;

@Entity
public class UsersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String userName;
    private String password;
    private String email;
    private Integer phoneNumber;

    public UsersModel(String userName, String password, String email, Integer phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UsersModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UsersModel() {

    }

    public Long getUser_id() {
        return user_id;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
