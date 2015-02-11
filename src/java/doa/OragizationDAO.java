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
import model.Oragization;
import utils.DBConnection;

/**
 *
 * @author emam
 */
public class OragizationDAO implements dao<Oragization>{

    DBConnection db=new DBConnection();
    @Override
    public String Presist(Oragization o) {
        try {
            db.connect();
            String sql="INSERT INTO Organisation (Name,Postal_Address,Post_code,Activity_description,PERSON_ID) VALUES (?,?,?,?,?)";
            db.pstm=db.con.prepareStatement(sql);
            db.pstm.setString(1, o.getName());
            db.pstm.setString(2, o.getPostalAddress());
            db.pstm.setString(3, o.getPostalcode());
            db.pstm.setString(4, o.getActivity());
            db.pstm.setInt(5,o.getPersonId());
            db.pstm.executeUpdate();
            db.closeConnection();
        } catch (SQLException ex) {
                        db.closeConnection();

            Logger.getLogger(OragizationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "ok";
        
    }

    @Override
    public String remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Oragization> FindAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Oragization> FindByParentId(int parentID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(Oragization o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
