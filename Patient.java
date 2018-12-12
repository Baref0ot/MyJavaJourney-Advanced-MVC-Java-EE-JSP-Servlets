package Business;
import java.sql.*;
/*******************************************************************************
 
   Name: Matthew Wright
   Date: 13 November 2018
   Description: This is a business object class for Patients of the ConfidentU Java
                Enterprise Level web application.
 
 ******************************************************************************/
public class Patient {
    
    /******************************************************
     Declarations
     ******************************************************/
    private String patientId;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String insuranceCo;
    public Procedure pr1 = new Procedure();
    
    /************************************************************
     Setters and Getters
     ***********************************************************/
    public void setPatientId(String pid){
        patientId = pid;
    }// end setPatientId()
    public String getPatientId(){
        return patientId;
    }// end getPatientId()
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
    public void setAddress(String ad){
        address = ad;
    }// end setAddress()
    public String getAddress(){
        return address;
    }// end getAddress
    public void setInsuranceCo(String inco){
        insuranceCo = inco;
    }// end setInsuranceCo()
    public String getInsuranceCo(){
        return insuranceCo;
    }// end getInsuranceCo
    
    /************************************************
     Constructors
     ************************************************/
    public Patient(){
        setPatientId(" ");
        setPassword(" ");
        setFirstName(" ");
        setLastName(" ");
        setEmail(" ");
        setAddress(" ");
        setInsuranceCo(" ");
    }// end Patient empty Constructor 
    public Patient(String pid, String pw, String fn, String ln, String em, String ad, String inco){
        setPatientId(pid);
        setPassword(pw);
        setFirstName(fn);
        setLastName(ln);
        setEmail(em);
        setAddress(ad);
        setInsuranceCo(inco);
    }// end filled parameter Patient Constructor
    
    // JDBC Methods   
    /********************************************************* 
     selectDB() method. 
     *********************************************************/
    public void selectDB(String pid){
        setPatientId(pid);
        try{
            // step 1: Load the driver.
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            // step 2: Get a connection to the database.
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week8Project/DentistOfficeMDB.mdb");
            // step 3: Create a memory location for the sql statement to be passed in to the database via the connection to be executed.
            Statement stmt = con.createStatement();
            // step 4: create the sql query that you wish to be placed in the Statement object (stmt) to be sent over to the database to be executed.
            String sql;
            sql = "select * from Patients where patId = '"+getPatientId()+"'";
            System.out.println("//from the Patient selectDB() method.");
            System.out.println(sql);
            System.out.println("");
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            // step 5: process through the data that has been placed in the result set.
            rs.next();
            setPassword(rs.getString("passwd"));
            setFirstName(rs.getString("firstName"));
            setLastName(rs.getString("lastName"));
            setAddress(rs.getString("addr"));
            setEmail(rs.getString("email"));
            setInsuranceCo(rs.getString("insCo"));
            // step 6: close the connection to the database.
            con.close();
        }// end try()
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }// end catch
    }// end selectDB()
    
    /******************************************************************
     insertDB() method.
     ******************************************************************/
    public void insertDB(String pid, String pw, String fn, String ln, String ad, String em, String inco){
        try{
            setPatientId(pid);
            setPassword(pw);
            setFirstName(fn);
            setLastName(ln);
            setAddress(ad);
            setEmail(em);
            setInsuranceCo(inco);
            // step 1: Load the driver.
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            // step 2: Get a connection to the database.
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week8Project/DentistOfficeMDB.mdb");
            // step 3: Create a memory location for the sql statement to be passed in to the database via the connection to be executed.
            Statement stmt = con.createStatement();
            // step 4: create the sql query that you wish to be placed in the Statement object (stmt) to be sent over to the database to be executed.
            String sql;
            sql = "insert into Patients(patId, passwd, firstName, lastName, addr, email, insCo) values('" + getPatientId() + "', '" + getPassword() + "', '" + getFirstName() + "', '" + getLastName() + "', '" + getAddress() + "', '" + getEmail() + "', '"+getInsuranceCo()+"')";
            System.out.println("// from the Patient insertDB() method.");
            System.out.println(sql);
            System.out.println("");
            // step 5: execute the sql statement.
            int numberOfInserts = stmt.executeUpdate(sql);
            if(numberOfInserts == 1){
                System.out.println("One patient was successfully added to the database.");
                // step 6: close the connection to the database.
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
    
    /*****************************************************************
     updateDB() method. 
     *****************************************************************/
    public void updateDB(){
        try{
            // step 1: Load the Driver.
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            // step 2: Get a Connection to the database.
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week8Project/DentistOfficeMDB.mdb");
            // step 3: Create a memory location for the sql statement to be passed in to the database via the connection to be executed.
            Statement stmt = con.createStatement();
            // step 4: Create the sql query that you wish to be placed in the Statement object (stmt) to be sent over to the database to be executed.
            String sql;
            sql = "update Patients set passwd = '"+getPassword()+"', firstName = '"+getFirstName()+"', lastName = '"+getLastName()+"', addr = '"+getAddress()+"', email = '"+getEmail()+"', insCo = '"+getInsuranceCo()+"' where patId = '"+getPatientId()+"'";
            System.out.println("// from the Patient updateDB() method.");
            System.out.println(sql);
            System.out.println("");
            // step 5: execute the sql statement.
            int numberOfUpdates = stmt.executeUpdate(sql);
            if(numberOfUpdates == 1){
                System.out.println("One Patient's information was successfully updated.");
                // step 6: close the connection to the database.
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
   
    /********************************************************
     deleteDB() method. 
     ********************************************************/
    public void deleteDB(){
        try{
             // step 1: Load the Driver.
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            // step 2: Get a Connection to the database.
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week8Project/DentistOfficeMDB.mdb");
            // step 3: Create a memory location for the sql statement to be passed in to the database via the connection to be executed.
            Statement stmt = con.createStatement();
            // step 4: Create the sql query that you wish to be placed in the Statement object (stmt) to be sent over to the database to be executed.
            String sql;
            sql = "delete from Patients where patId = '"+getPatientId()+"'";
            System.out.println("// from the patient deleteDB() method.");
            System.out.println(sql);
            System.out.println("");
            // step 5: execute the sql statement.
            int numberOfDeletes = stmt.executeUpdate(sql);
            if(numberOfDeletes == 1){
                System.out.println("One patient was successfully deleted from the database.");
                con.close();
            }// end if()
            else if(numberOfDeletes != 1){
                System.out.println("Something went wrong...");
                con.close();
            }// end if()
        }// end try
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }// end catch()
    }// end deleteDB()
    
    /*********************************************************************
     display() method.
     *********************************************************************/
    public void display(){
        System.out.println("Patient ID: "+getPatientId());
        System.out.println("Password:   "+getPassword());
        System.out.println("First Name: "+getFirstName());
        System.out.println("Last Name:  "+getLastName());
        System.out.println("Email:      "+getEmail());
        System.out.println("Address:    "+getAddress());
        System.out.println("Insurance:  "+getInsuranceCo());
        System.out.println("");
    }// end display()
    
    /*********************************************************************
      main() method for testing
     *********************************************************************/
    public static void main(String [] args){
    /*********************************************************************    
        // creating a Patient object.
        Patient p1 = new Patient();
        p1.setPatientId("7295");
        p1.setPassword("MonkeyBoy65");
        p1.setFirstName("Matthew");
        p1.setLastName("Wright");
        p1.setEmail("mw@yahoo.com");
        p1.setAddress("121 example rd.");
        p1.setInsuranceCo("Kaiser Perminte");
        p1.display();  
        
        // testing the selectDB() method against the data base.
        Patient p2 = new Patient();
        p2.selectDB("A900");
        p2.display();   
                                               
        // testing the insertDB() method against the data base.
        Patient p3 = new Patient();
        p3.insertDB("A007", "7295", "Matthew", "Wright", "Adairsville", "Mattwrightjobs@yahoo.com", "Cigna");  
        p3.display();  
     
        // testing the updateDB() method against the data base.
        Patient p4 = new Patient();
        p4.selectDB("A007");
        p4.setFirstName("Tiffanie");
        p4.setLastName("Flores");
        p4.setPassword("3459");
        p4.setEmail("TFlores@yahoo.com");
        p4.updateDB();
        p4.display();   
    
        // testing the deleteDB() method against the database.
       Patient p5 = new Patient();
        p5.selectDB("A007");
        p5.deleteDB();
        p5.display();  
    *********************************************************************/
    }// end main
}// end Patient class
