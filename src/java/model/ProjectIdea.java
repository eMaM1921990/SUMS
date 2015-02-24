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
public class ProjectIdea {
    private int idProjectIdea;
    private String title;
    private String description;
    private String aims;
    private String academicQuestion;
    private String submissionDate;
    private int numberOfStudents;
    private int PERSON_ID;
    
    public void setId(int i){
        this.idProjectIdea=i;
    }
    
    public int getId(){
        return idProjectIdea;
    }
    
    public void setTitle(String s){
        this.title=s;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setDesc(String s){
        this.description=s;
    }
    
    public String getDesc(){
        return description;
    }
    
    public void setAims(String s){
        this.aims=s;
    }
    
    public String getAims(){
        return aims;
    }
    
    public void setAcQuestion(String s){
        this.academicQuestion=s;
    }
    
    public String getAcQuestion(){
        return academicQuestion;
    }
    
    public void setDate(String s){
        this.submissionDate=s;
    }
    
    public String getDate(){
        return submissionDate;
    }
    
    public void setNumberOfStudent(int i){
        this.numberOfStudents=i;
    }
    
    public int getNumberOfStudent(){
        return numberOfStudents;
    }
    
    public void setPersonid(int i){
        this.PERSON_ID=i;
    }
    
    public int getPersonid(){
        return PERSON_ID;
    }
}
