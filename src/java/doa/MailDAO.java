/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doa;

import dao.i.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mails;
import utils.DBConnection;

/**
 *
 * @author emam
 */
public class MailDAO implements dao<Mails>{

    DBConnection db=new DBConnection();
    @Override
    public String Presist(Mails o) {
        try {
            db.connect();
            String sql="INSERT INTO Email (Email_address,USER_ID) VALUES (?,?)";
            db.pstm=db.con.prepareStatement(sql);
            db.pstm.setString(1, o.getMail());
            db.pstm.setInt(2, o.getPersonId());
            db.pstm.executeUpdate();
            db.closeConnection();
        } catch (SQLException ex) {
                        db.closeConnection();
            Logger.getLogger(MailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "OK";
    }

    @Override
    public String remove(int id) {
        try {
            db.connect();
            db.pstm=db.con.prepareStatement("DELETE FROM Email WHERE idEmail=?");
            db.pstm.setInt(1, id);
            db.pstm.executeUpdate();
            db.closeConnection();
            
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(MailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "ok";
    }

    @Override
    public List<Mails> FindAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mails> FindByParentId(int parentID) {
        List<Mails> data=new ArrayList<>();
        try {
            db.connect();
            db.pstm=db.con.prepareStatement("SELECT idEmail,Email_address FROM Email WHERE USER_ID=?");
            db.pstm.setInt(1, parentID);
            db.rs=db.pstm.executeQuery();
            while(db.rs.next()){
                Mails m=new Mails();
                m.setId(db.rs.getInt(1));
                m.setMail(db.rs.getString(2));
                data.add(m);
            }
            
            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(MailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public String update(Mails o) {
        try {
            db.connect();
            db.pstm=db.con.prepareStatement("UPDATE Email SET Email_address=? WHERE idEmail=?");
            db.pstm.setString(1, o.getMail());
            db.pstm.setInt(2, o.getId());
            db.pstm.executeUpdate();
            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(MailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Ok";
    }
    
}
