/*******************************************************************************
 
   Name: Matthew Wright
   Date: December 3 2018
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

@WebServlet(urlPatterns = {"/CreatePatientServlet"})
public class CreatePatientServlet extends HttpServlet {

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
        String userName;
        String password;
        String firstName;
        String lastName;
        String email;
        String address;
        String insuranceCo;
        try{
            // Step 1: Get the "pUserName" from the previous HTML file
            userName = request.getParameter("userName");
            password = request.getParameter("password");
            firstName = request.getParameter("firstName"); 
            lastName = request.getParameter("lastName"); 
            email = request.getParameter("email"); 
            address = request.getParameter("address"); 
            insuranceCo = request.getParameter("insuranceCo"); 
            // Step 2: Get any Objects out of the session using the getAttribute()
                // not needed at this time.
            // Step 3: Create any objects that you need.
            Patient p1 = new Patient();
            p1.insertDB(userName, password, firstName, lastName, email, address, insuranceCo);
            p1.display();
            // Step 4: Make a decsion.
                // not needed at this time.
            // Step 5: put objects into the session.
            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("p1Create", p1);
            // Step 6: use the requestDispatcher to forward the request to the appropriate servlet, html, jsp pages.
            RequestDispatcher rd = request.getRequestDispatcher("patients/CongratsNewAccountLogin.jsp");
            rd.forward(request,response); 
        }// end try
        catch(IOException | ServletException e){
            System.out.println(e);
        }//end catch()
    }// end processRequest
}// end CreatePatientServlet Class
