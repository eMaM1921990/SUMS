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
public class Personphones {
    private int id;
    private String phone;
    private int personid;
    
    public void setId(int i){
        this.id=i;
    }
    
    public int getId(){
        return id;
    }
    
    public void setPhone(String p){
        this.phone=p;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public void setPersonId(int i){
        this.personid=i;
    }
    
    public int getPersonId(){
        return personid;
    }
}
