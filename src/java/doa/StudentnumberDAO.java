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
import model.StudentNumber;
import utils.DBConnection;

/**
 *
 * @author emam
 */
public class StudentnumberDAO implements dao<StudentNumber>{

    DBConnection db=new DBConnection();
    @Override
    public String Presist(StudentNumber o) {
        String message="No Message";
        try {
            db.connect();
            String sql="INSERT INTO StudentNumber (Hemis number,PERSON_ID) VALUES (?,?)";
            db.pstm=db.con.prepareStatement(sql);
            db.pstm.setString(1, o.getStudentnumber());
            db.pstm.setInt(2, o.getId());
            db.pstm.executeUpdate();
            db.closeConnection();
            message="saved";
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(StudentnumberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return message;
    }

    @Override
    public String remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StudentNumber> FindAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StudentNumber> FindByParentId(int parentID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(StudentNumber o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
