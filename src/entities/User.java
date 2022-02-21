/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author nadee ben cheikh
 */
public class User {

    private int id_user;
    private String username;
    private String first_name;
    private String last_name;
    private int phone;
    private String email;
    private String password;
    private String country;
    private Date birthdate;
    private String picture;
    private String address;
    private String role;
    private String gender;
    private String salt;

  

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", username=" + username + ", first_name=" + first_name + ", last_name=" + last_name + ", phone=" + phone + ", email=" + email + ", password=" + password + ", country=" + country + ", birthdate=" + birthdate + ", picture=" + picture + ", address=" + address + ", role=" + role + ", gender=" + gender + '}';
    }

    
     public User() {
    }

    public User(int id_user, String username, String first_name, String last_name, int phone, String email, String password, String country, Date birthdate, String picture, String address, String role, String gender) {
        this.id_user = id_user;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.country = country;
        this.birthdate = birthdate;
        this.picture = picture;
        this.address = address;
        this.role = role;
        this.gender = gender;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
      public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
     
}


