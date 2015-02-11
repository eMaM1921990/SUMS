/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;
/**
 *
 * @author Ahmed Elemam
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

public class DBConnection {

    private static final long serialVersionUID = -5099250487211761968L;

    String propFileName = "../connections.properties";
    public Connection con;
    public Statement stmt;
    public ResultSet rs;
    public String driverName = "com.mysql.jdbc.Driver";

    public String url ; //"jdbc:oracle:thin:DELIVERY/delivery@db-public.cc9fyyn0rz8v.eu-west-1.rds.amazonaws.com:1521:orcl";
    public String user ;//= "DELIVERY";
    public String password; //= "DBPassKaza0rder";
    public PreparedStatement pstm;
    int colcount;
    private DataSource dataSource;
    HttpServletRequest request;
    HttpServletResponse response;

    /**
     * Creates a new instance of DBConnection driver
     * sun.jdbc.odbc.JdbcOdbcDriver url jdbc:odbc:student
     */
    public void connect() {

        try {

            String path = Thread.currentThread().getContextClassLoader().getResource("/").toURI().resolve(propFileName).getPath();

            Properties prop = new Properties();

            prop.load(new FileInputStream(path));
            url = prop.getProperty(prop.getProperty("CURRENT_URL"));
            user = prop.getProperty(prop.getProperty("CURRENT_USER"));
            password = prop.getProperty(prop.getProperty("CURRENT_PASS"));
            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();

        } catch (SQLException | ClassNotFoundException ex) {

            closeConnection();
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);

        } catch (URISyntaxException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void excuteUpdate(String sqlStmt) {
        try {

            stmt.executeUpdate(sqlStmt);
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }

    public ResultSet excuteQuery(String selectStmt) {

        try {
            rs = stmt.executeQuery(selectStmt);

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
        return rs;

    }
    /* returns data as a vector of vector to be displayed in a JTable
     **/

    public ArrayList getData() {

        ArrayList display = new ArrayList();
        try {
            colcount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                ArrayList row = new ArrayList();
                for (int i = 1; i <= colcount; i++) {
                    row.add(rs.getString(i));
                }
                display.add(row);
            }
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }

        return display;
    }

    public void closeConnection() {
        try {
            //con.commit();
            stmt.close();
            con.close();

            System.out.println("close connection");

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }

    public void closeResult() {
        try {

            rs.close();
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }

    public void CloseStatment() {
        try {

            stmt.close();

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }

}
