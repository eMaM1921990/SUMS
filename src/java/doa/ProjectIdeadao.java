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
import model.ProjectIdea;
import model.ProjectIdeaHistory;
import utils.DBConnection;

/**
 *
 * @author emam
 */
public class ProjectIdeadao implements dao.i.dao<ProjectIdea>{

    DBConnection db=new DBConnection();
    ProjectIdeaHistory ph=new ProjectIdeaHistory();
    ProjectIdeaHistorydao dao=new ProjectIdeaHistorydao();
    
    @Override
    public String Presist(ProjectIdea o) {
        String msg=null;
        try {
            db.connect();
            db.pstm=db.con.prepareStatement("INSERT INTO ProjectIdea (title,description,aims,academicQuestion,numberOfStudents,PERSON_ID) VALUES (?,?,?,?,?,?)",db.stmt.RETURN_GENERATED_KEYS);
            db.pstm.setString(1, o.getTitle());
            db.pstm.setString(2, o.getDesc());
            db.pstm.setString(3, o.getAims());
            db.pstm.setString(4, o.getAcQuestion());
            db.pstm.setInt(5, o.getNumberOfStudent());
            db.pstm.setInt(6,o.getPersonid());
            db.pstm.executeUpdate();
            db.rs=db.pstm.getGeneratedKeys();
            int id=0;
            while(db.rs.next()){
                id=db.rs.getInt(1);
            }
            
            
            db.closeConnection();
            
            ph.setChange("Add New idea named "+o.getTitle());
            ph.setReason("Add");
            ph.setProjectID(id);
            dao.Presist(ph);
            
            msg="saved";
        } catch (SQLException ex) {
            db.closeConnection();
            msg="["+ex.getErrorCode()+"]:"+ex.getMessage();
            Logger.getLogger(ProjectIdeadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return msg;
        
    }

    @Override
    public String remove(int id) {
        String msg=null;
        try {
            db.connect();
            db.pstm=db.con.prepareStatement("DELETE FROM ProjectIdea WHERE idProjectIdea=?");
            db.pstm.setInt(1, id);
            db.pstm.executeUpdate();
            db.closeConnection();
            msg="Deleted";
        } catch (SQLException ex) {
            msg="["+ex.getErrorCode()+"] :"+ex.getMessage();
            Logger.getLogger(ProjectIdeadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return msg;
    }

    @Override
    public List<ProjectIdea> FindAll() {
        List<ProjectIdea> data=new ArrayList<>();
        db.connect();
        try {
            
            db.pstm=db.con.prepareStatement("SELECT * FROM ProjectIdea");
            db.rs=db.pstm.executeQuery();
            while(db.rs.next()){
                ProjectIdea p=new ProjectIdea();
                p.setId(db.rs.getInt(1));
                p.setTitle(db.rs.getString(2));
                p.setDesc(db.rs.getString(3));
                p.setAims(db.rs.getString(4));
                p.setAcQuestion(db.rs.getString(5));
                p.setDate(db.rs.getString(6));
                p.setNumberOfStudent(db.rs.getInt(7));
                p.setPersonid(db.rs.getInt(8));
                data.add(p);
            }
            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(ProjectIdeadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }

    @Override
    public List<ProjectIdea> FindByParentId(int parentID) {
         List<ProjectIdea> data=new ArrayList<>();
        try {
            db.connect();
            db.pstm=db.con.prepareStatement("SELECT * FROM ProjectIdea WHERE PERSON_ID=?");
            db.pstm.setInt(1, parentID);
            db.rs=db.pstm.executeQuery();
            while(db.rs.next()){
                ProjectIdea p=new ProjectIdea();
                p.setId(db.rs.getInt(1));
                p.setTitle(db.rs.getString(2));
                p.setDesc(db.rs.getString(3));
                p.setAims(db.rs.getString(4));
                p.setAcQuestion(db.rs.getString(5));
                p.setDate(db.rs.getString(6));
                p.setNumberOfStudent(db.rs.getInt(7));
                p.setPersonid(db.rs.getInt(8));
                data.add(p);
            }
            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(ProjectIdeadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }

    @Override
    public String update(ProjectIdea o) {
        String msg=null;
        try {
            db.connect();
            db.pstm=db.con.prepareStatement("UPDATE ProjectIdea SET title=?,description=?,aims=?,academicQuestion=?,numberOfStudents=? WHERE idProjectIdea=?");
            db.pstm.setString(1, o.getTitle());
            db.pstm.setString(2, o.getDesc());
            db.pstm.setString(3, o.getAims());
            db.pstm.setString(4, o.getAcQuestion());
            db.pstm.setInt(5, o.getNumberOfStudent());
            db.pstm.setInt(6, o.getId());
            db.pstm.executeUpdate();
            db.closeConnection();
            
            ph.setChange("Edit idea named "+o.getTitle());
            ph.setReason("Edit");
            ph.setProjectID(o.getId());
            dao.Presist(ph);
            
            msg="Updated";
        } catch (SQLException ex) {
            db.closeConnection();
            msg="["+ex.getErrorCode()+"]:"+ex.getMessage();
            Logger.getLogger(ProjectIdeadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return msg;
    }
    
}
