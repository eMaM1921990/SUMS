/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import doa.MailDAO;
import doa.OragizationDAO;
import doa.PersonDAO;
import doa.PersonphoneDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Types;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Mails;
import model.Oragization;
import model.Person;
import model.Personphones;
import model.StudentNumber;
import utils.MailNotification;

/**
 *
 * @author emam
 */
public class Registration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        MailNotification mail=new MailNotification();
        String Forename = request.getParameter("Forename");
        String Surname = request.getParameter("Surname");
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        String PERSON_STATUSID = request.getParameter("PERSON_STATUSID");
        String HEMIS = request.getParameter("HEMIS");
        String Name = request.getParameter("Name");
        String Postal_Address = request.getParameter("Postal_Address");
        String Post_code = request.getParameter("Post_code");
        String Activity_description = request.getParameter("Activity_description");
        String phone = request.getParameter("phone");

        Person p = new Person();
        p.setForname(Forename);
        p.setSurename(Surname);
        p.setUsername(Username);
        p.setPassword(Password);
        p.setPersonstatus(Integer.valueOf(PERSON_STATUSID));

        PersonDAO dao = new PersonDAO();
        String i = dao.Presist(p);

        Personphones pp = new Personphones();
        pp.setPersonId(Integer.valueOf(i));
        pp.setPhone(phone);

        PersonphoneDAO p_dao = new PersonphoneDAO();
        p_dao.Presist(pp);

        if (Integer.valueOf(PERSON_STATUSID) == 1) {
            StudentNumber s = new StudentNumber();
            s.setStudentnumber(HEMIS);
            s.setPersonId(Integer.valueOf(i));
        } else {
            Oragization o = new Oragization();
            o.setName(Name);
            o.setPostalAddress(Postal_Address);
            o.setPostalcode(Post_code);
            o.setPersonId(Integer.valueOf(i));
            o.setActivity(Activity_description);

            OragizationDAO odao = new OragizationDAO();
            odao.Presist(o);
        }
        
        
        Mails m=new Mails();
        m.setMail(request.getParameter("mail"));
        m.setPersonId(Integer.valueOf(i));
        MailDAO mdao=new MailDAO();
        mdao.Presist(m);
        
        if (Integer.valueOf(i) > 0) {
            mail.ActivationMail(Username,m.getMail(), i, request.getContextPath()+"/activation?id=");
            response.getWriter().write("Saved");

        } else {
            response.getWriter().write("Not Saved");

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
