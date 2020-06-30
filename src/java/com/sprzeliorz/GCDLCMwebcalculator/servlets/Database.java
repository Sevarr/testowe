package com.sprzeliorz.GCDLCMwebcalculator.servlets;

import com.sprzeliorz.GCDLCMwebcalculator.database.GCDLCMDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet showing archives of already counted data.
 *
 * @author Sebastian Przeliorz
 * @version 1.0
 */
@WebServlet(name = "Database", urlPatterns = {"/Database"})
public class Database extends HttpServlet {

    
    /**
     * Object representing database connection
     */
    private GCDLCMDatabase db;
    
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
        ServletContext context = getServletContext();
        db = (GCDLCMDatabase) context.getAttribute("db");
        try (PrintWriter out = response.getWriter()) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
            } catch (ClassNotFoundException cnfe) {
                System.err.println(cnfe.getMessage());
                return;
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculations archives</title>");
            out.println("</head>");
            out.println("<body>");
            out.printf("<table>" + "<thead>"
                    + "<th>" + "Data" + "</th>" + "<th>" + "GCD" + "</th>"
                    + "<th>" + "LCM" + "</th>" + "<tbody>");
            try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/lab", "db_user", "db_pass")) {
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM Results");
                while (rs.next()) {
                    out.printf("<tr>");
                    out.printf("<td>" + rs.getString("data") + "</td>");
                    out.printf("<td>" + rs.getString("gcd") + "</td>");
                    out.printf("<td>" + rs.getString("lcm") + "</td>");
                    out.printf("</tr>");
                }
                rs.close();
                out.println("</tbody>");
                out.println("<table>");
            } catch (SQLException sqle) {
                System.err.println(sqle.getMessage());
            }
            out.println("</body>");
            out.println("</html>");
        }
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