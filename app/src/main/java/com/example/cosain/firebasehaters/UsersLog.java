package com.example.cosain.firebasehaters;

/**
 * Created by cosain on 9/27/2017.
 */

public class UsersLog {

    private String username;
    private String id;

    public UsersLog(){

    }
    public void setId(String id){
        this.id = id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getId(){
        return id;
    }
    public String getUsername(){

        return username;
    }
}
