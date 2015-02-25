/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author emam
 */
public class ProjectIdeaHistory {
    private int idProjectIdeaHistory;
    private String dates;
    private String change;
    private String reason;
    private int PROJECTID;
    
    public void setProjecID(int i){
        this.PROJECTID=i;
    }
    
    public int getProjectID(){
        return PROJECTID;
    }
    
    public void setidProjectIdeaHistory(int i){
        this.idProjectIdeaHistory=i;
    }
    
    public int getidProjectIdeaHistory(){
        return idProjectIdeaHistory;
    }
    
    public void setDates(String d){
        this.dates=d;
    }
    
    public String getDates(){
        return dates;
    }
    
    public void setChange(String s){
        this.change=s;
    }
    
    public String getChange(){
        return change;
    }
    
    public void setReason(String r){
        this.reason=r;
    }
    
    public String getReason(){
        return reason;
    }
    
    public void setProjectID(int i){
        this.PROJECTID=i;
    }
}
