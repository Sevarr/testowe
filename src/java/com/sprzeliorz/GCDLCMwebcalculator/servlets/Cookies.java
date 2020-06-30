package com.sprzeliorz.GCDLCMwebcalculator.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet displaying cookies of last counting operation.
 *
 * @author Sebastian Przeliorz
 * @version 1.0
 */
public class Cookies extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. Method desplaying cookies of last counting operation.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Last counted data</title>");
            out.println("</head>");
            out.println("<body>");
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
            String lastGCD = "none";
            String lastLCM = "none";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("lastGCD")) {
                    lastGCD = cookie.getValue();
                } else {
                    if (cookie.getName().equals("lastLCM")) {
                        lastLCM = cookie.getValue();
                    }
                }
            }
            out.println("Last counted data:" + "</p>");
            out.println("Greatest common factor " + lastGCD + "</p>");
            out.println("Least common multiple " + lastLCM);
            } else {
                out.println("There whas no calculations before");
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
