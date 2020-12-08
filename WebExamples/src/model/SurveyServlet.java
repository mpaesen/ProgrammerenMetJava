package model;


import database.SurveyDatabaseConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class SurveyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        try {

            SurveyDatabaseConnector dbCon = new SurveyDatabaseConnector();
            dbCon.updateData(Integer.parseInt(request.getParameter("animal")));

            out.println("<head>");
            out.println("<title>A Database Servlet Example</title>");
            out.println("</head>");
            out.println("<h1>" + "AnimalSurvey" + "</h1>");

            ResultSet rs = dbCon.getRs();
            int rowCount = 0;

            out.println("<TABLE BORDER=1>");
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/theme/Master.css' />");

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            out.println("<TR>");
            for (int i = 0; i < columnCount; i++) {
                out.println("<TH>" + rsmd.getColumnLabel(i + 1) + "</TH>");
            }
            out.println("</TR>");

            while (rs.next()) {
                rowCount++;
                out.println("<TR>");
                for (int i = 0; i < columnCount; i++) {
                    out.println("<TD>" + rs.getString(i + 1) + "</TD>");
                }
                out.println("</TR>");
            }
            out.println("</TABLE></P>");


            dbCon.getRs().close();
            dbCon.getConnection().close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Committed transaction and closed connection");


        // start XHTML document
        out.println("<?xml version = \"1.0\"?>");

        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD "
                + "XHTML 1.0 Strict//EN\" \"http://www.w3.org"
                + "/TR/xhtml1/DTD/xhtml1-strict.dtd\">");

        out.println("<html xmlns = \"http://www.w3.org/1999/xhtml\">");

        // end XHTML document
        out.println("</html>");
        out.close(); // close stream to complete the page
    }
}







