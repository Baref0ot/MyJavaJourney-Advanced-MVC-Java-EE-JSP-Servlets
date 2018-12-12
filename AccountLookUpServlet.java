/*******************************************************************************
 *
 * Matthew Wright
 * Java3
 * Lab # 5
 * 13 September 2018
 *
 ****************************************************************************** */

import Business.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/AccountLookUpServlet"})
public class AccountLookUpServlet extends HttpServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String an;
        String ci;
        String t;
        String b;
        try (PrintWriter out = response.getWriter()) {
            // Step 1: Get the "userName" from the previous HTML file
            an = request.getParameter("acctNo");
            ci = request.getParameter("customerId");
            t = request.getParameter("type");
            b = request.getParameter("balance");
            // Step 2: Get any Objects out of the session using the getAttribute()
            HttpSession ses1;
            ses1 = request.getSession();
            CustBusObj c1 = (CustBusObj)ses1.getAttribute("c1ObjName");
            // Step 3: Create any objects that you need to verify Customer login
            AccountBusObj a1 = new AccountBusObj();
            a1.selectDB(an);
            a1.display();
            // Step 5: put Object into the session using HTTPSession
            ses1.setAttribute("a1ObjName", a1);
            // Step 4: Make any decsions
                // no descions at this point
            // Step 6: Use RequestDispatcher to forward tp a page
                RequestDispatcher rd = request.getRequestDispatcher("/DisplayAccount.jsp");
                rd.forward(request, response);
        }// end try 
        catch (Exception e) {
            System.out.println(e);
        }// end catch
    }// end processRequest

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }// end doGet

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }// end doPost
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}// end class
