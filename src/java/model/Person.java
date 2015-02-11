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
public class Person {
    private int id;
    private String Forename;
    private String Surname;
    private String Username;
    private String Password;
    private String created;
    private String confirmed;
    private String logged;
    private int PERSON_STATUSID;
    
    public void setId(int i){
        this.id=i;
    }
    
    public int getId(){
        return id;
    }
    
    public void setForname(String f){
        this.Forename=f;
    }
    
    public String getForname(){
        return Forename;
    }
    
    public void setSurename(String s){
        this.Surname=s;
    }
    
    public String getSurename(){
        return Surname;
        
    }
    
    public void setUsername(String u){
        this.Username=u;
    }
    public String getUsername(){
        return Username;
    }
    
    public void setPassword(String p){
        this.Password=p;
    }
    
    public String getPassword(){
        return Password;
    }
    
    public void setCreated(String c){
        this.created=c;
    }
    
    public String getCreated(){
        return created;
    }
    
    public void setConfirmed(String c){
        this.confirmed=c;
    }
    
    public String getConfirmed(){
        return confirmed;
    }
    
    public void setLogged(String l){
        this.logged=l;
    }
    
    public String getLogged(){
        return logged;
    }
    
    public void setPersonstatus(int s){
        this.PERSON_STATUSID=s;
        
    }
    
    public int getPersonstatus(){
        return PERSON_STATUSID;
    }
}



