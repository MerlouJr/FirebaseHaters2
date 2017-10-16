package com.example.cosain.firebasehaters;

import java.util.List;

/**
 * Created by cosain on 9/27/2017.
 */

public class LogChunks {

    private String logID;
    private List<SemanticChunk> chunks;

    public LogChunks(){
    }

    public void setLogID(String logID){
        this.logID = logID;
    }
    public void setChunks(List<SemanticChunk> chunks){
        this.chunks = chunks;
    }

    public String getLogID(){
        return logID;
    }

    public List<SemanticChunk> getChunks(){
        return chunks;
    }

}
