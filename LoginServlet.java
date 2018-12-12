
/** *****************************************************************************
 *
 * Matthew Wright
 * Java3
 * Lab # 5
 * 13 September 2018
 *
 ****************************************************************************** */

import Business.CustBusObj;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    // Declarations
    private String userNm;
    private String passWd;

    // Methods
    public void setUserNm(String un) {
        userNm = un;
    }// end setUserNm

    public String getUserNm() {
        return userNm;
    }// end getUserNm

    public void setPassword(String pw) {
        passWd = pw;
    }// end setPassword

    public String getPassword() {
        return passWd;
    }// end getPassword

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }// end doGet

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }// end doPost

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String un;
        String pw;
        try{
            // Step 1: Get the "userName" from the previous HTML file
            un = request.getParameter("userName");
            pw = request.getParameter("password");
            System.out.println("UserName retrieved" +un);
            // Step 2: Get any Objects out of the session using the getAttribute()
                // not needed as of now
            // Step 3: Create any objects that you need to verify Customer login
            CustBusObj c1;
            c1 = new CustBusObj();
            c1.selectDB(un);
            //c1.display();
            // Step 5: put Customer Object into the session using HTTPSession
            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("c1Name", c1);
            // Step 4: Make any decsions 
            if ((un.equals(c1.getCustId()))  && (pw.equals(c1.getCustPassWord()))) {
                // AccountLookUp.jsp is another jsp that you can forward the request dispatcher to.
                RequestDispatcher rd = request.getRequestDispatcher("/DisplayAccounts.jsp");
                rd.forward(request,response);
            }// end if
            else {
                RequestDispatcher rd2 = request.getRequestDispatcher("/ErrorPage.jsp");
                rd2.forward(request,response);
            }// end else  
        }// end try
        catch (IOException | ServletException e) {
            System.out.println(e);
        }// end catch
    }// end processRequest
}// end class
