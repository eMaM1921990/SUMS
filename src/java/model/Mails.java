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
public class Mails {
    private int id;
    private String mail;
    private int personid;
    
    
    public void setPersonId(int id){
        this.personid=id;
    }
    
    public int getPersonId(){
        return personid;
    }
    
    public void setId(int i){
        this.id=i;
    }
    
    public int getId(){
        return id;
    }
    
    public void setMail(String m){
        this.mail=m;
    }
    
    public String getMail(){
        return mail;
    }
}

