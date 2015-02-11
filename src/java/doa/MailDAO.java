/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doa;

import dao.i.dao;
import java.sql.SQLException;
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
            String sql="INSER INTO Email (Email_address,USER_ID) VALUES (?,?)";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mails> FindAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mails> FindByParentId(int parentID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(Mails o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
