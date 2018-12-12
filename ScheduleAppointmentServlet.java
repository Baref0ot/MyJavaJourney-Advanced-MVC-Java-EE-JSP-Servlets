/*******************************************************************************
 
   Name: Matthew Wright
   Date: 30 November 2018
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

@WebServlet(urlPatterns = {"/ScheduleAppointmentServlet"})
public class ScheduleAppointmentServlet extends HttpServlet {

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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String appointmentDateTime;
        String procedure;
        String dentist;
        String aptdt;
        String pid;
        String did;
        String pc;
        try{
             // Step 1: Get the "pUserName" from the previous HTML file
            appointmentDateTime = request.getParameter("apptDateTime");
            procedure= request.getParameter("procedure");
            dentist = request.getParameter("dentist"); 
            // Step 2: Get any Objects out of the session using the getAttribute()
            HttpSession ses1;
            ses1 = request.getSession();
            Patient p1 = (Patient)ses1.getAttribute("p1LoginSession");
            // new
            HttpSession ses3;
            ses3 = request.getSession();
            Procedure pr1 = (Procedure) ses3.getAttribute("p1ProcedureInfo");
            pr1.selectDB(procedure);
            pr1.display();
            // new
            HttpSession ses4;
            ses4 = request.getSession();
            Dentist d1 = (Dentist) ses4.getAttribute("p1DentistInfo");
            d1.selectDB(dentist);
            // new
            HttpSession ses2;
            ses2 = request.getSession();
            Appointment a1 = (Appointment) ses2.getAttribute("p1AppointmentInfo");
            a1.setApptDateTime(appointmentDateTime);
            a1.setPatientId(p1.getPatientId());
            a1.setDentistId(d1.getDentistId());
            a1.setProcCode(pr1.getProcCode());
            // values to be stored in the a1.insertDB() method.
            aptdt = a1.getApptDateTime();
            pid = a1.getPatientId();
            did = a1.getDentistId();
            pc = a1.getProcCode();
            a1.insertDB(aptdt, pid, did, pc);
            a1.selectDB(pid);
            a1.display();
            // Step 5: put Objects into the session using HTTPSession
            HttpSession ses5;
            ses5 = request.getSession();
            ses5.setAttribute("p1ProcedureInfo", pr1);
            // new
            HttpSession ses6;
            ses6 = request.getSession();
            ses6.setAttribute("p1DentistInfo", d1);
            // new
            HttpSession ses7;
            ses7 = request.getSession();
            ses7.setAttribute("p1AppointmentInfo", a1);
            // Step 6: use the requestDispatcher to forward the request to the appropriate servlet, html, jsp pages.
            RequestDispatcher rd = request.getRequestDispatcher("/CUPAppointmentInfo.jsp");
            rd.forward(request,response); 
        }// end try
        catch(IOException | ServletException e){
            System.out.println(e);
        }// end catch()
      }// end processRequest
}// end ScheduleAppointmentServlet class
