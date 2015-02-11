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
public class StudentNumber {
    private int id;
    private String studentnumber;
    private int person_id;
    
    public void setPersonId(int i){
        this.person_id=i;
    }
    
    public int getPersonId(){
        return person_id;
    }
    
    public void setId(int i){
        this.id=i;
    }
    
    public int getId(){
        return id;
    }
    
    public void setStudentnumber(String n){
        this.studentnumber=n;
    }
    
    public String getStudentnumber(){
        return studentnumber;
    }
}
