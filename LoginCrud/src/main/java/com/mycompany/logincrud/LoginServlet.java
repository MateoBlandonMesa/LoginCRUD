/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.logincrud;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import entities.User;
import persistence.MongoDatabaseAccess;

/**
 *
 * @author blandonm
 */
public class LoginServlet extends HttpServlet {

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
        
        MongoDatabaseAccess mongoDatabaseAccess = new MongoDatabaseAccess();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Boolean usernameExists = mongoDatabaseAccess.ValidateUsernameExists(username);
        Boolean passwordIsCorrect = usernameExists == true ? mongoDatabaseAccess.ValidatePasswordIsCorrect(username, password) : false;
        
        if(usernameExists && passwordIsCorrect){
            User loginUser = mongoDatabaseAccess.getDatabaseUser(username);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/update_user.jsp");
            request.setAttribute("username", username);
            dispatcher.forward(request, response);
        }
        else{
            request.setAttribute("errorMessage", "Invalid username or password.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
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
