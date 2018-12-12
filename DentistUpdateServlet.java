/*******************************************************************************
 
   Name: Matthew Wright
   Date: 28 November 2018
   Description: This is a login verification servlet for both Patient and Dentist business objects 
                inside the ConfidentU business package.
 
 ******************************************************************************/

import Business.Dentist;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/DentistUpdateServlet"})
public class DentistUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }// end doGet()

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }// end doPost()
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String dentistFirstName;
        String dentistLastName; 
        String dentistEmail;
        String dentistOfficeNo;
        try{
            // Step 1: Get the "pUserName" from the previous HTML file
            
            dentistFirstName = request.getParameter("firstName");
            dentistLastName = request.getParameter("lastName");
            dentistEmail = request.getParameter("email");
            dentistOfficeNo = request.getParameter("officeNumber");
            // Step 2: Get any Objects out of the session using the getAttribute()
            HttpSession ses1;
            ses1 = request.getSession();
            Dentist d1 = (Dentist)ses1.getAttribute("d1LoginSession");
            // Step 3: Create any objects that you need to verify Patient or Dentist login
            Dentist d2 = new Dentist();
            d2.selectDB(d1.getDentistId());
            d2.setFirstName(dentistFirstName);
            d2.setLastName(dentistLastName);
            d2.setEmail(dentistEmail);
            d2.setOfficeNo(dentistOfficeNo);
            d2.updateDB();
            d2.display();
            // Step 5: put Patient Object into the session using HTTPSession
            HttpSession ses2;
            ses2 = request.getSession();
            ses2.setAttribute("d2UpdateSession", d2);
            // Step 6: use the requestDispatcher to forward the request to the appropriate servlet, html, jsp pages.
            RequestDispatcher rd = request.getRequestDispatcher("./showUpdatedDAccount.jsp");
            rd.forward(request,response); 
        }// end try
        catch(IOException | ServletException e){
            System.out.println(e);
        }// end catch()
    }// end processRequest()
}// end PatientUpdateServlet class
