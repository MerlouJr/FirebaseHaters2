package com.example.cosain.firebasehaters;

/**
 * Created by cosain on 9/3/2017.
 */

public class Log {

    private int id;
    private String raw_content;
    private String tag_content;
    private long time_stamp;


    public Log(){
    }

    public void setTag_content(String tag_content){

        this.tag_content = tag_content;

    }
    public String getTag_content(){

        return tag_content;

    }
    public void setTime_stamp(Long time_stamp_recorded){

        this.time_stamp = time_stamp_recorded;

    }

    public Long getTime_stamp(){

        return time_stamp;

    }

}
