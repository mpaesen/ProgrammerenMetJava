// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PersonsServlet.java

package web;

import db.DbPerson;
import model.Person;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class PersonsServlet extends HttpServlet
    implements Servlet
{

    public PersonsServlet()
    {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        List listOfPersons = null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter outWriter = response.getWriter();
        try
        {
            String name = request.getParameter("nameTextbox").toString();
            DbPerson dbPerson = DbPerson.getInstance();
            dbPerson.open();
            if(name != null && name != "")
            {
                String street = request.getParameter("streetTextbox").toString();
                String postcode = request.getParameter("postcodeTextbox").toString();
                String city = request.getParameter("cityTextbox").toString();
                String gsm = request.getParameter("gsmTextbox").toString();
                String email = request.getParameter("emailTextbox").toString();
                dbPerson.createPerson(name, street, postcode, city, gsm, email);
            }
            listOfPersons = dbPerson.getPersons();
            StringBuilder sb = new StringBuilder();
            sb.append("<html>");
            sb.append("<head>");
            sb.append("<title>Overzicht inhoud tabel 'Person'</title>");
            sb.append("</head>");
            sb.append("<body>");
            sb.append("<h1>Overzicht Personen in database 'Person'</h1><br>");
            sb.append("<table border='1'>");
            sb.append("<tr>");
            sb.append("<td width='100'><B>Id</B></td>");
            sb.append("<td width='200'><B>Name</B></td>");
            sb.append("<td width='200'><B>Street</B></td>");
            sb.append("<td width='100'><B>Postcode</B></td>");
            sb.append("<td width='200'><B>City</B></td>");
            sb.append("<td width='200'><B>Gsm</B></td>");
            sb.append("<td width='200'><B>email</B></td>");
            sb.append("</tr>");
            for(Iterator iterator = listOfPersons.iterator(); iterator.hasNext(); sb.append("</tr>"))
            {
                Person person = (Person)iterator.next();
                sb.append("<tr>");
                sb.append((new StringBuilder("<td>")).append(person.getId()).append("</td>").toString());
                sb.append((new StringBuilder("<td>")).append(person.getName()).append("</td>").toString());
                sb.append((new StringBuilder("<td>")).append(person.getStreet()).append("</td>").toString());
                sb.append((new StringBuilder("<td>")).append(person.getPostcode()).append("</td>").toString());
                sb.append((new StringBuilder("<td>")).append(person.getCity()).append("</td>").toString());
                sb.append((new StringBuilder("<td>")).append(person.getGsm()).append("</td>").toString());
                sb.append((new StringBuilder("<td>")).append(person.getEmail()).append("</td>").toString());
            }

            sb.append("</table>");
            sb.append("<br><a href='/PersonServlet/index.html'>Terug naar main</a><br>");
            sb.append("</body>");
            sb.append("</html>");
            outWriter.write(sb.toString());
            outWriter.close();
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }

    protected void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
    }

    static final long serialVersionUID = 1L;
}
