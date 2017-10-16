package com.example.cosain.firebasehaters;

import java.util.Date;

/**
 * Created by cosain on 9/27/2017.
 */

public class UserProfile {
    private String username;
    private String firstname;
    private String lastname;
    private char gender;
    private Date birthDate;
    public UserProfile(){
    }
    public String getUsername(){
       return username;
    }
    public String getFirstname(){
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public char getGender(){
        return gender;
    }
    public Date getBirthDate(){
        return birthDate;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public void setGender(char gender){
        this.gender = gender;
    }
    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }

}
