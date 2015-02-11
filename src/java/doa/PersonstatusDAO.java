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
import model.PerstonStatus;
import utils.DBConnection;

/**
 *
 * @author emam
 */
public class PersonstatusDAO implements dao<PerstonStatus> {

    DBConnection db = new DBConnection();

    @Override
    public String Presist(PerstonStatus o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PerstonStatus> FindAll() {
        List<PerstonStatus> data_list = new ArrayList<>();

        try {
            db.connect();
            String sql = "SELECT * FROM PersonStatus";
            db.pstm = db.con.prepareStatement(sql);
            db.rs = db.pstm.executeQuery();
            while (db.rs.next()) {
                PerstonStatus p = new PerstonStatus();
                p.setId(db.rs.getInt(1));
                p.setName(db.rs.getString(2));
                data_list.add(p);
            }
            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(PersonstatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data_list;
    }

    @Override
    public List<PerstonStatus> FindByParentId(int parentID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(PerstonStatus o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
