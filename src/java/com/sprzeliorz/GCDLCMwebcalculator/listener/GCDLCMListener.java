package com.sprzeliorz.GCDLCMwebcalculator.listener;

import com.sprzeliorz.GCDLCMwebcalculator.database.GCDLCMDatabase;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author Sebastian Przeliorz
 * @version 1.1
 */
@WebListener()
//public class GCDLCMListener implements ServletRequestAttributeListener {
public class GCDLCMListener implements ServletContextListener {

    /**
     * Object which represents database connection
     */
    private GCDLCMDatabase db = null;

    /**
     * Method initialises context {@inheritDoc}
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {

        ServletContext context = event.getServletContext();

        String dbDriver = context.getInitParameter("db_driver");
        String dbUrl = context.getInitParameter("db_url");
        String dbUser = context.getInitParameter("db_user");
        String dbPass = context.getInitParameter("db_pass");
        //GCDLCMDatabase gcdlcmDatabase = new GCDLCMDatabase();
        //gcdlcmDatabase.init(dbDriver, dbUrl, dbUser, dbPass);
        //db.create(dbDriver, dbUrl, dbUser, dbPass);
if (dbDriver == null || dbUrl == null || dbUser == null || dbPass == null) {
            System.out.println("One of database parameters is not valid!");
        } else {
            db.create(dbDriver, dbUrl, dbUser, dbPass);
        }
        context.setAttribute("db", db);
    }

    /**
     * Method runs at the end of context lifecycle {@inheritDoc}
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        //db.closeConnection();
    }

    /**
     * Overrided method addind attribute
     *
     * @param attre arrtibute sended by index.html
     */
    /*@Override
    public void attributeAdded(ServletRequestAttributeEvent attre) {
        System.out.println("Attribute " + attre.getName() + " has been added with value: " + attre.getValue());
    }*/
    /**
     * Overrided method removing attribute
     *
     * @param attre arrtibute sended by index.html
     */
    /* @Override
    public void attributeRemoved(ServletRequestAttributeEvent attre) {
        System.out.println("Attribute " + attre.getName() + " has been romoved");
    }*/
    /**
     * Overrided method replaceing attribute
     *
     * @param attre arrtibute sended by index.html
     */
    /*@Override
    public void attributeReplaced(ServletRequestAttributeEvent attre) {
        System.out.println("Attribute " + attre.getName() + " has been replaced, with value: " + attre.getValue());
    }*/
}
