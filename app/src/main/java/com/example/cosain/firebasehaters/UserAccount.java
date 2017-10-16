package com.example.cosain.firebasehaters;
/**
 * Created by cosain on 9/27/2017.
 */

public class UserAccount {

    private String username;
    private String password;

    public UserAccount(){

    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
