/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ProjectIdeaHistory;
import utils.DBConnection;

/**
 *
 * @author emam
 */
public class ProjectIdeaHistorydao implements dao.i.dao<ProjectIdeaHistory>{

    DBConnection db=new DBConnection();
    
    @Override
    public String Presist(ProjectIdeaHistory o) {
        String msg=null;
        try {
            db.connect();
            db.pstm=db.con.prepareStatement("INSERT INTO ProjectIdeaHistory (change,reson,PROJECTID) VALUES (?,?,?)");
            db.pstm.setString(1, o.getChange());
            db.pstm.setString(2, o.getReason());
            db.pstm.setInt(3, o.getProjectID());
            db.pstm.executeUpdate();
            db.closeConnection();
            msg="saved";
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(ProjectIdeaHistorydao.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return msg;
    }

    @Override
    public String remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProjectIdeaHistory> FindAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProjectIdeaHistory> FindByParentId(int parentID) {
        List<ProjectIdeaHistory> data=new ArrayList<>();
        try {
            db.connect();
            db.pstm=db.con.prepareStatement("SELECT * FROM ProjectIdeaHistory WHERE PROJECTID=?");
            db.pstm.setInt(1, parentID);
            db.rs=db.pstm.executeQuery();
            while(db.rs.next()){
                ProjectIdeaHistory p=new ProjectIdeaHistory();
                p.setidProjectIdeaHistory(db.rs.getInt(1));
                p.setDates(db.rs.getString(2));
                p.setChange(db.rs.getString(3));
                p.setReason(db.rs.getString(4));
                p.setProjectID(db.rs.getInt(5));
                data.add(p);
                
            }
                db.closeConnection();
        
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(ProjectIdeaHistorydao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }

    @Override
    public String update(ProjectIdeaHistory o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
