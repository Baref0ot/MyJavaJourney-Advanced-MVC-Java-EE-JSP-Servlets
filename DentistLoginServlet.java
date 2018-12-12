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

@WebServlet(urlPatterns = {"/DentistLoginServlet"})
public class DentistLoginServlet extends HttpServlet {

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
    
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String dentistUserName;
        String dentistPassword; 
        try{
            // Step 1: Get the "pUserName" from the previous HTML file
            dentistUserName = request.getParameter("dUserName");
            dentistPassword = request.getParameter("dPassword");
            // Step 2: Get any Objects out of the session using the getAttribute()
                // not needed as of now
            // Step 3: Create any objects that you need to verify Patient or Dentist login
            Dentist d1 = new Dentist();
            d1.selectDB(dentistUserName);
            d1.display();
            // Step 5: put Patient Object into the session using HTTPSession
            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("d1LoginSession", d1);
            // Step 4: Make any decsions 
            if(dentistUserName.equals(d1.getDentistId()) && dentistPassword.equals(d1.getPassword())){
                RequestDispatcher rd = request.getRequestDispatcher("./CUDAccountInfo.jsp");
                rd.forward(request,response); 
            }// end if()
                //else if(dentistUserName.equals(d1.getDentistId()) && dentistPassword.equals(d1.getPassword())){
                
                //}// end else if()
            else{
                RequestDispatcher rd = request.getRequestDispatcher("/dentists/AccessDenied.jsp");
                rd.forward(request, response);
            }// end else
        }// end try
        catch(IOException | ServletException e){
            System.out.println(e);
        }// end catch()
    }// end processRequest()
}// end PatientLoginServlet class
