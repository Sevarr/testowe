package com.sprzeliorz.GCDLCMwebcalculator.servlets;

import com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCore;
import com.sprzeliorz.GCDLCMwebcalculator.database.GCDLCMDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet used to start calculations from added data
 *
 * @author Sebastian Przeliorz
 * @version 1.2
 */
public class Calculate extends HttpServlet {

     /**
     * Object representing database connection
     */
    private GCDLCMDatabase db;
    
    
    /**
     * list of parameters sended from index.html
     */
    public List<String> list = new ArrayList<>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. Method used to call model and calculate.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int i = 0;
        int[] tabResult = new int[2];

        GCDLCMCore gcdlcmCore = GCDLCMCore.INSTANCE;

        //GCDLCMDatabase gcdlcmDatabase = new GCDLCMDatabase();
ServletContext context = getServletContext();
        db = (GCDLCMDatabase) context.getAttribute("db");
        
        PrintWriter out = response.getWriter();

        String data = request.getParameter("data");
        List<String> splitData = Arrays.asList(data.split(" "));

        for (String element : splitData) {
            list.add(splitData.get(i));
            i++;
        }
        db.createTable();
        try {
            tabResult = gcdlcmCore.gcdlcmCalculate(splitData);
        } catch (com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCalculatorExeption ex) {
            response.sendError(response.SC_BAD_REQUEST, ex.getMessage());
        }
        db.insertData(data, Integer.toString(tabResult[0]), Integer.toString(tabResult[1]));
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Result of calculations</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("Greatest common factor: " + tabResult[0] + "</p>"
                + "Least common multiple: " + tabResult[1] + "\n");
        out.println("</body>");
        out.println("</html>");

        Cookie lastGCD = new Cookie("lastGCD", Integer.toString(tabResult[0]));
        Cookie lastLCM = new Cookie("lastLCM", Integer.toString(tabResult[1]));
        response.addCookie(lastGCD);
        response.addCookie(lastLCM);

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
