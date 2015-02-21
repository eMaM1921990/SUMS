/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doa;

import dao.i.dao;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Person;
import utils.DBConnection;

/**
 *
 * @author emam
 */
public class PersonDAO implements dao<Person> {

    DBConnection db = new DBConnection();

    @Override
    public String Presist(Person o) {
        String message = null;
        try {
            db.connect();
            String sql = "INSERT INTO Person (Forename,Surname,Username,Password,created,PERSON_STATUSID) VALUES (?,?,?,?,now(),?)";
            db.pstm = db.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            db.pstm.setString(1, o.getForname());
            db.pstm.setString(2, o.getSurename());
            db.pstm.setString(3, o.getUsername());
            db.pstm.setString(4, o.getPassword());
            db.pstm.setInt(5, o.getPersonstatus());
            db.pstm.executeUpdate();
            db.rs = db.pstm.getGeneratedKeys();
            int id = 0;
            while (db.rs.next()) {
                id = db.rs.getInt(1);
            }

            message = Integer.toString(id);

        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }

    @Override
    public String remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> FindAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> FindByParentId(int parentID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(Person o) {
        try {
            db.connect();
            String sql = "UPDATE Person SET confirmed=now() WHERE idPerson=?";
            db.pstm = db.con.prepareStatement(sql);
            db.pstm.setInt(1, o.getId());
            db.pstm.executeUpdate();
            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "ok";
    }

    public int FindByUser(Person p) {
        int id = 0;
        try {

            db.connect();
            String sql = "SELECT idPerson AS CHEK FROM Person WHERE Username=? AND Password=?";
            db.pstm = db.con.prepareStatement(sql);
            db.pstm.setString(1, p.getUsername());
            db.pstm.setString(2, p.getPassword());
            db.rs = db.pstm.executeQuery();
            while (db.rs.next()) {
                id = db.rs.getInt(1);
            }

            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    public String updatelastloged(Person o) {
        try {
            db.connect();
            String sql = "UPDATE Person SET logged=now() WHERE Username=? AND Password=?";
            db.pstm = db.con.prepareStatement(sql);

            db.pstm.setString(1, o.getUsername());
            db.pstm.setString(2, o.getPassword());
            db.pstm.executeUpdate();
            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "ok";
    }

    

    public String upDatePassword(Person o) {
        String message=null;
        db.connect();
        try {
            db.pstm = db.con.prepareStatement("UPDATE Person set Password=? where Username=?");
            db.pstm.setString(1, o.getPassword());
            db.pstm.setString(2, o.getUsername());
            db.pstm.executeUpdate();
            db.closeConnection();
            message="Password Updated";
            
        } catch (SQLException ex) {
            db.closeConnection();

            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return message;
    }
    
    
    public Person FindByEntity(Person o) {
        Person p=new Person();
        try {
            
            db.connect();
            db.pstm=db.con.prepareStatement("SELECT Forename,Surname,Password FROM Person where Username=?");
            db.pstm.setString(1, o.getUsername());
            db.rs=db.pstm.executeQuery();
            while(db.rs.next()){
                p.setForname(db.rs.getString(1));
                p.setSurename(db.rs.getString(2));
                p.setPassword(db.rs.getString(3));
            }
            
            db.closeConnection();
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
            db.closeConnection();
        }
        
        return p;
    }

}
