package com.example.cosain.firebasehaters;

/**
 * Created by cosain on 9/27/2017.
 */

public class LogDAO {
    private String id;
    private String raw_content;
    private String tag_content;
    private long timestamp_recorded;
    public LogDAO(){

    }
    public void setId(String id){
        this.id = id;
    }
    public void setRaw_content(String raw_content){
        this.raw_content = raw_content;
    }
    public void setTag_content(String tag_content){
        this.tag_content = tag_content;
    }
    public void setTimestamp_recorded(long timestamp_recorded){
        this.timestamp_recorded = timestamp_recorded;
    }
    public String getId(){
        return id;
    }
    public String getRaw_content(){
        return raw_content;
    }
    public String getTag_content(){
        return tag_content;
    }
    public long getTimestamp_recorded(){
        return timestamp_recorded;
    }

}
