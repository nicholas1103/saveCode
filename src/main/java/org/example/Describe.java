package org.example;

public class Describe {
    private String sessionID;
    private String MSSV;
    private String exerciseTopic;
    private String countString;
    private String orderString;
    private String stringText;
    private String typeFile;
    private String nameFile;

    public Describe (String sessionID, String MSSV, String exerciseTopic, String countString, String orderString, String stringText, String typeFile, String nameFile){
        this.sessionID = sessionID;
        this.MSSV = MSSV;
        this.exerciseTopic = exerciseTopic;
        this.countString = countString;
        this.orderString = orderString;
        this.stringText = stringText;
        this.typeFile = typeFile;
        this.nameFile = nameFile;
    }

    public String getSessionID (){
        return sessionID;
    }

    public void setSessionID (String sessionID){
        this.sessionID = sessionID;
    }

    public String getMSSV (){
        return MSSV;
    }

    public void setMSSV (String MSSV){
        this.MSSV = MSSV;
    }

    public String getExerciseTopic(){
        return exerciseTopic;
    }

    public void setExerciseTopic(String exerciseTopic){
        this.exerciseTopic = exerciseTopic;
    }

    public String getCountString (){
        return countString;
    }

    public void setCountString (String countString){
        this.countString = countString;
    }

    public String getOrderString (){
        return orderString;
    }

    public void setOrderString (String orderString){
        this.orderString = orderString;
    }

    public String getStringText (){
        return stringText;
    }

    public void setStringText (String stringText){
        this.stringText = stringText;
    }
    public String getTypeFile () {
        return typeFile;
    }
    public void setTypeFile (String typeFile){
        this.typeFile = typeFile;
    }
    public String getNameFile () {
        return nameFile;
    }
    public void setNameFile (String nameFile){
        this.nameFile = nameFile;
    }
}
