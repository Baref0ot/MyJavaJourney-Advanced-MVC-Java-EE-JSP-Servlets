/*******************************************************************************
 
   Name: Matthew Wright
   Date: 28 November 2018
   Description: This is a login verification servlet for both Patient and Dentist business objects 
                inside the ConfidentU business package.
 
 ******************************************************************************/

import Business.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/PatientUpdateServlet"})
public class PatientUpdateServlet extends HttpServlet {

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
        String patientFirstName;
        String patientLastName; 
        String patientEmail;
        String patientAddress;
        String patientProvider;
        try{
            // Step 1: Get the "pUserName" from the previous HTML file
            
            patientFirstName = request.getParameter("firstName");
            patientLastName = request.getParameter("lastName");
            patientEmail = request.getParameter("email");
            patientAddress = request.getParameter("address");
            patientProvider = request.getParameter("insuranceCo");
            // Step 2: Get any Objects out of the session using the getAttribute()
            HttpSession ses1;
            ses1 = request.getSession();
            Patient p1 = (Patient)ses1.getAttribute("p1LoginSession");
            // Step 3: Create any objects that you need to verify Patient or Dentist login
            Patient p2 = new Patient();
            p2.selectDB(p1.getPatientId());
            p2.setFirstName(patientFirstName);
            p2.setLastName(patientLastName);
            p2.setEmail(patientEmail);
            p2.setAddress(patientAddress);
            p2.setInsuranceCo(patientProvider);
            p2.updateDB();
            p2.display();
            // Step 5: put Patient Object into the session using HTTPSession
            HttpSession ses2;
            ses2 = request.getSession();
            ses2.setAttribute("p2UpdateSession", p2);
            // Step 6: use the requestDispatcher to forward the request to the appropriate servlet, html, jsp pages.
            RequestDispatcher rd = request.getRequestDispatcher("./ShowUpdatedPAccount.jsp");
            rd.forward(request,response); 
        }// end try
        catch(IOException | ServletException e){
            System.out.println(e);
        }// end catch()
    }// end processRequest()
}// end PatientUpdateServlet class
