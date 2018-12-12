/*******************************************************************************
 
   Name: Matthew Wright
   Date: 28 November 2018
   Description: This is a login verification servlet for both Patient and Dentist business objects 
                inside the ConfidentU business package.
 
 ******************************************************************************/

import Business.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/PatientLoginServlet"})
public class PatientLoginServlet extends HttpServlet {

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
        String patientUserName;
        String patientPassword; 
        String procCode;
        String dentistId;
        try{
            /******************************************************************
             Step 1: Get "pUserName" and "pPassword" from the previous HTML file.
             ******************************************************************/
            patientUserName = request.getParameter("pUserName");
            patientPassword = request.getParameter("pPassword");
            /******************************************************************
            Step 3: Create any objects that you need to verify Patient or Dentist login.
            ******************************************************************/
            Patient p1 = new Patient();
            p1.selectDB(patientUserName);
            p1.display();
            // new 
            Appointment a1 = new Appointment();
            a1.selectDB(patientUserName);
            procCode = a1.getProcCode();
            dentistId = a1.getDentistId();
            a1.display();
            // new
            Procedure pr1 = new Procedure();
            pr1.selectDB(procCode);
            pr1.display();
            // new
            Dentist d1 = new Dentist();
            d1.selectDB(dentistId);
            d1.display();
            /******************************************************************
            Step 5: put Patient, Appointment, Procedure, and Dentist Objects into the session using HTTPSession.
            ******************************************************************/
            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("p1LoginSession", p1);
            // new
            HttpSession ses2;
            ses2 = request.getSession();
            ses2.setAttribute("p1AppointmentInfo", a1);
            // new
            HttpSession ses3;
            ses3 = request.getSession();
            ses3.setAttribute("p1ProcedureInfo", pr1);
            // new
            HttpSession ses4;
            ses4 = request.getSession();
            ses4.setAttribute("p1DentistInfo", d1);
            // Step 4: Make any decsions 
            if(patientUserName.equals(p1.getPatientId()) && patientPassword.equals(p1.getPassword())){
                RequestDispatcher rd = request.getRequestDispatcher("/CUPAccountInfo.jsp");
                rd.forward(request,response); 
            }// end if()
                //else if(dentistUserName.equals(d1.getDentistId()) && dentistPassword.equals(d1.getPassword())){
                
                //}// end else if()
            else{
                RequestDispatcher rd = request.getRequestDispatcher("/patients/AccessDenied.jsp");
                rd.forward(request, response);
            }// end else
        }// end try
        catch(IOException | ServletException e){
            System.out.println(e);
        }// end catch()
    }// end processRequest()
}// end PatientLoginServlet class
