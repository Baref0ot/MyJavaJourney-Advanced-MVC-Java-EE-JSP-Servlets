package Business;
import java.sql.*;
/*******************************************************************************
 
   Name: Matthew Wright
   Date: 15 November 2018
   Description: This is a business object class for Dentist of the ConfidentU Java
                Enterprise Level web application.
 
 ******************************************************************************/
public class Dentist {
    
    /*********************************************************
        Declaration
    *********************************************************/
    private String dentistId;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String officeNo;
    public AppointmentsList applist = new AppointmentsList();
    
    // Setters and Getters
    public void setDentistId(String did){
        dentistId = did;
    }// end setDentistId()
    public String getDentistId(){
        return dentistId;
    }// end getDentistId()
    public void setPassword(String pw){
        password = pw;
    }// end setPassword()
    public String getPassword(){
        return password;
    }// end getPassword()
    public void setFirstName(String fn){
        firstName = fn;
    }// end setFirstName()
    public String getFirstName(){
        return firstName;
    }// end getFirstName()
    public void setLastName(String ln){
        lastName = ln;
    }// end setLastName()
    public String getLastName(){
        return lastName;
    }// end getLastName()
    public void setEmail(String em){
        email = em;
    }// end setEmail()
    public String getEmail(){
        return email;
    }// end getEmail()
    public void setOfficeNo(String on){
        officeNo = on;
    }// end setOfficeNo()
    public String getOfficeNo(){
        return officeNo;
    }// end getOfficeNo()
    
    /*********************************************************
     Constructors
    *********************************************************/
    public Dentist(){
        setDentistId("");
        setPassword("");
        setFirstName("");
        setLastName("");
        setEmail("");
        setOfficeNo("");
    }// end empty Dentist Constructor
    public Dentist(String did, String pw, String fn, String ln, String em, String on){
        setDentistId(did);
        setPassword(pw);
        setFirstName(fn);
        setLastName(ln);
        setEmail(em);
        setOfficeNo(on);
    }// end parameter filled Dentist Constructor
    
     // JDBC Methods
    public void getAppointments(){
        try{
            /********************************************************* 
             step 1: Load the driver.
            *********************************************************/
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            /********************************************************* 
             step 2: Get a connection to the database.
            *********************************************************/
            /********************************************************* 
             step 3: Create a memory location for the sql statement to be passed in to the database via the connection to be executed.
            *********************************************************/
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week8Project/DentistOfficeMDB.mdb");
            /********************************************************* 
             step 3: Create a memory location for the sql statement to be passed in to the database via the connection to be executed.
            **********************************************************/
            Statement stmt = con.createStatement();
            /********************************************************* 
             step 4: create the sql query that you wish to be placed in the Statement object (stmt) to be sent over to the database to be executed.
            **********************************************************/
            String sql;
            sql = "select * from Appointments where dentId = '"+getDentistId()+"'";
            System.out.println("// from Dentist getAppointments() method.");
            System.out.println(sql);
            System.out.println("");
            ResultSet rs = stmt.executeQuery(sql);
            String patId;
            Appointment app1 = null;
            while(rs.next()){
                patId = rs.getString("patId");
                app1 = new Appointment();
                app1.selectDB(patId);
                applist.addAppointment(app1);
            }// end while()
        }// end try
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }// end catch()
    }// end getAppointments() 
    /********************************************************* 
     selectDB() method. 
     *********************************************************/
    public void selectDB(String did){
        setDentistId(did);
        try{
            /********************************************************* 
             step 1: Load the driver.
            *********************************************************/
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            /********************************************************* 
             step 2: Get a connection to the database.
            *********************************************************/
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week8Project/DentistOfficeMDB.mdb");
            /********************************************************* 
             step 3: Create a memory location for the sql statement to be passed in to the database via the connection to be executed.
            *********************************************************/
            Statement stmt = con.createStatement();
            /********************************************************* 
             step 4: create the sql query that you wish to be placed in the Statement object (stmt) to be sent over to the database to be executed.
            **********************************************************/
            String sql;
            sql = "select * from Dentists where id = '"+getDentistId()+"'";
            System.out.println("//from the Dentist selectDB() method.");
            System.out.println(sql);
            System.out.println("");
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            /**********************************************************
             step 5: process through the data that has been placed in the result set.
             **********************************************************/
            rs.next();
            setPassword(rs.getString("passwd"));
            setFirstName(rs.getString("firstName"));
            setLastName(rs.getString("lastName"));
            setEmail(rs.getString("email"));
            setOfficeNo(rs.getString("office"));   
            /**********************************************************
             step 6: // close the connection to the database.
             **********************************************************/
            con.close();
        }// end try()
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }// end catch
        getAppointments();
    }// end selectDB()
    
    /********************************************************* 
      insertDB(String did, String pw, String fn, String ln, String em, String on) method
     *********************************************************/
    public void insertDB(String did, String pw, String fn, String ln, String em, String on){
        try{
            setDentistId(did);
            setPassword(pw);
            setFirstName(fn);
            setLastName(ln);
            setEmail(em);
            setOfficeNo(on);
             /********************************************************* 
             step 1: Load the driver.
            *********************************************************/
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            /********************************************************* 
             step 2: Get a connection to the database.
            *********************************************************/
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week8Project/DentistOfficeMDB.mdb");
            /********************************************************* 
             step 3: Create a memory location for the sql statement to be passed in to the database via the connection to be executed.
            *********************************************************/
            Statement stmt = con.createStatement();
            /********************************************************* 
             step 4: create the sql query that you wish to be placed in the Statement object (stmt) to be sent over to the database to be executed.
            **********************************************************/
            String sql;
            sql = "insert into Dentists(id, passwd, firstName, lastName, email, office) values('" + getDentistId() + "', '" + getPassword() + "', '" + getFirstName() + "', '" + getLastName() + "', '" + getEmail() + "', '"+getOfficeNo()+"')";
            System.out.println("// from the Dentist insertDB() method.");
            System.out.println(sql);
            System.out.println("");
             /**********************************************************
             step 5: process through the data that has been placed in the result set.
             **********************************************************/
            int numberOfInserts = stmt.executeUpdate(sql);
            if(numberOfInserts == 1){
                System.out.println("One Dentist was successfully added to the database.");
                 /**********************************************************
                 step 6: // close the connection to the database.
                 **********************************************************/
                con.close();
            }// end if
            else if(numberOfInserts != 1){
                System.out.println("Something went wrong...");
                con.close();
            }// end else
        }// end try
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }// end catch
    }// end insertDB()
    /********************************************************* 
     updateDB() method.
     *********************************************************/
    public void updateDB(){
        try{
            /********************************************************* 
             step 1: Load the driver.
            *********************************************************/
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            /********************************************************* 
             step 2: Get a connection to the database.
            *********************************************************/
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week8Project/DentistOfficeMDB.mdb");
            /********************************************************* 
             step 3: Create a memory location for the sql statement to be passed in to the database via the connection to be executed.
            *********************************************************/
            Statement stmt = con.createStatement();
            /********************************************************* 
             step 4: create the sql query that you wish to be placed in the Statement object (stmt) to be sent over to the database to be executed.
            **********************************************************/
            String sql;
            sql = "update Dentists set passwd = '"+getPassword()+"', firstName = '"+getFirstName()+"', lastName = '"+getLastName()+"', email = '"+getEmail()+"', office = '"+getOfficeNo()+"' where id = '"+getDentistId()+"'";
            System.out.println("// from the Dentist updateDB() method.");
            System.out.println(sql);
            System.out.println("");
           /**********************************************************
             step 5: process through the data that has been placed in the result set.
             **********************************************************/
            int numberOfUpdates = stmt.executeUpdate(sql);
            if(numberOfUpdates == 1){
                System.out.println("One Dentist's information was successfully updated.");
               /**********************************************************
                 step 6: // close the connection to the database.
                 **********************************************************/
                con.close();
            }// end if
            else if(numberOfUpdates != 1){
                System.out.println("Something went wrong...");
                con.close();
            }// end else if
        }// end try
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }// end catch()
    }// end updateDB()
    /********************************************************* 
     deleteDB() method.
     ********************************************************/
    public void deleteDB(){
        try{
             /********************************************************* 
             step 1: Load the driver.
            *********************************************************/
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            /********************************************************* 
             step 2: Get a connection to the database.
            *********************************************************/
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week8Project/DentistOfficeMDB.mdb");
            /********************************************************* 
             step 3: Create a memory location for the sql statement to be passed in to the database via the connection to be executed.
            *********************************************************/
            Statement stmt = con.createStatement();
            /********************************************************* 
             step 4: create the sql query that you wish to be placed in the Statement object (stmt) to be sent over to the database to be executed.
            **********************************************************/
            String sql;
            sql = "delete from Dentists where id = '"+getDentistId()+"'";
            System.out.println("// from the Dentist deleteDB() method.");
            System.out.println(sql);
            System.out.println("");
            /**********************************************************
             step 5: process through the data that has been placed in the result set.
             **********************************************************/
            int numberOfDeletes = stmt.executeUpdate(sql);
            if(numberOfDeletes == 1){
                System.out.println("One Dentist was successfully deleted from the database.");
                con.close();
            }// end if()
            else if(numberOfDeletes != 1){
                System.out.println("Something went wrong...");
                 /**********************************************************
                 step 6: // close the connection to the database.
                 **********************************************************/
                con.close();
            }// end if()
        }// end try
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }// end catch()
    }// end deleteDB()
    /********************************************************* 
      display() method.
     *********************************************************/
    public void display(){
        System.out.println("");
        System.out.println("Id: "+getDentistId());
        System.out.println("Password: "+getPassword());
        System.out.println("First Name: "+getFirstName());
        System.out.println("Last Name: "+getLastName());
        System.out.println("Email: "+getEmail());
        System.out.println("Office #: "+getOfficeNo());
        System.out.println("");
        System.out.println(" Your Appointments: "); 
        applist.display();
        System.out.println("");
    }// end display()
    
    /********************************************************* 
     main method used for testing
     *********************************************************/
    public static void main(String args []){
    /*********************************************************
        // creating a Dentist object
        Dentist d1 = new Dentist();
        d1.setDentistId("D205");
        d1.setPassword("Monkeyboy65");
        d1.setFirstName("Matthew");
        d1.setLastName("Wright");
        d1.setEmail("Mattwright700@yahoo.com");
        d1.setOfficeNo("720");
        d1.display(); 
      
        //testing the selectDB() method
        Dentist d2 = new Dentist();
        d2.selectDB("D203");
        d2.display();  
      
        //testing the insertDB()
        Dentist d3 = new Dentist();
        d3.insertDB("D205", "haha1", "David", "Baxter", "db@yahoo.com", "527");
        d3.display();  
      
        //testing the updateDB()
        Dentist d4 = new Dentist();
        d4.selectDB("D2305");
        d4.setFirstName("Rick");
        d4.setLastName("James");
        d4.setEmail("RickJames@yahoo.com");
        d4.setOfficeNo("560");
        d4.updateDB();
        d4.display();  
        
        // testing the deleteDB()
        Dentist d5 = new Dentist();
        d5.selectDB("D2305");
        d5.deleteDB();
        d5.display(); 
     *********************************************************/
    }// end main()
}// end Dentist class
