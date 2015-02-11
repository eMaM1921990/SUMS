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
public class Oragization {
    private int id;
    private String name;
    private String postalcode;
    private String postaladdress;
    private String activity;
    private int personid;
    
    public void setId(int i){
        this.id=i;
    }
    
    public int getId(){
        return id;
    }
    
    public void setName(String n){
        this.name=n;
    }
    
    public String getName(){
        return name;
    }
    
    public void setPostalcode(String p){
        this.postalcode=p;
    }
    
    public String getPostalcode(){
        return postalcode;
    }
    
    public void setPostalAddress(String a){
        this.postaladdress=a;
    }
    
    public String getPostalAddress(){
        return postaladdress;
    }
    
    public void setActivity(String a){
        this.activity=a;
    }
    
    public String getActivity(){
        return activity;
    }
    
    public void setPersonId(int i){
        this.personid=i;
    }
    
    public int getPersonId(){
        return personid;
    }
}
