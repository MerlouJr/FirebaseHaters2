package com.example.cosain.firebasehaters;

/**
 * Created by cosain on 9/27/2017.
 */

public class SemanticChunk {
    private String label;
    private StringBuffer content;
    private StringBuffer modifier;
    private StringBuffer preposition;
    public SemanticChunk(){

    }
    public void SemanticChunk(String label, StringBuffer content, StringBuffer modifier, StringBuffer preposition){
        this.label = label;
        this.content = content;
        this.modifier = modifier;
        this.preposition = preposition;
    }
   public void appendPreposition(StringBuffer preposition){
       this.preposition = preposition;
   }
   public void appendModifier(StringBuffer modifier){
       this.modifier = modifier;
   }
    public void appendContent(StringBuffer content){
        this.content = content;
    }
    public String  getLabel (){
        return label;
    }
    public StringBuffer getContent(){
        return  content;
    }
    public StringBuffer getModifier(){
        return modifier;
    }
    public StringBuffer getPreposition(){
        return preposition;
    }
}
