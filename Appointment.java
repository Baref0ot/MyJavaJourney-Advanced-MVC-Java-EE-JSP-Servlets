package Business;
import java.sql.*;
/*******************************************************************************
 
   Name: Matthew Wright
   Date: 15 November 2018
   Description: This is a business object class for Appointments of the ConfidentU Java
                Enterprise Level web application.
                 
                 
   Last updated: 11-26-2018: You were trying to figure out what the primary key was (rather the apptDateTime or a combination of patId and dentId) in order
   to properly query the updateDB method. 
        * for the sake of this project the patId is the primary key but for a real world application it would be a combination of patId and apptDateTime.
        * work on deleteDB() method. [Completed]
        * retest Patient, Dentist Business objects. [Completed]

 ******************************************************************************/
public class Appointment {
    
     /*********************************************************
      Declarations
      ********************************************************/
    private String apptDateTime;
    private String patientId; 
    private String dentistId;
    private String procCode;
    
     /*********************************************************
      Setters and Getters
      ********************************************************/
    public void setApptDateTime(String adt){
        apptDateTime = adt;
    }// end setApptDateTime()
    public String getApptDateTime(){
        return apptDateTime;
    }// end getApptDateTime()
    public void setPatientId(String pid){
        patientId = pid;
    }// end setPatientId()
    public String getPatientId(){
        return patientId;
    }// end getPatientId()
    public void setDentistId(String did){
        dentistId = did;
    }// end setDentistId()
    public String getDentistId(){
        return dentistId;
    }// end getDentistId()
    public void setProcCode(String pc){
        procCode = pc;
    }// end setProcCode()
    public String getProcCode(){
        return procCode;
    }// end getProcCode()
    
     /*********************************************************
      Constructors
      *********************************************************/
    public Appointment(){
        setApptDateTime("");
        setProcCode("");
        setPatientId("");
        setDentistId("");
    }// end empty Appointments Constructor
    public Appointment(String adt, String pc, String pid, String did){
        setApptDateTime(adt);
        setProcCode(pc);
        setPatientId(pid);
        setDentistId(did);
    }// end parameter filled Appointments Consrtuctor
     /*********************************************************
      selectDB() method. 
      *********************************************************/
    public void selectDB(String pid){
        setPatientId(pid);
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
            sql = "select * from Appointments where patId = '"+getPatientId()+"'";
            System.out.println("//from the Appointments selectDB() method.");
            System.out.println(sql);
            System.out.println("");
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            /**********************************************************
             step 5: process through the data that has been placed in the result set.
             **********************************************************/
            rs.next();
            setApptDateTime(rs.getString("apptDateTime"));
            setDentistId(rs.getString("dentId"));
            setProcCode(rs.getString("procCode"));
            /**********************************************************
                 step 6: close the connection to the database.
            **********************************************************/
            con.close();
        }// end try()
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }// end catch
    }// end selectDB()
    /******************************************************************
     insertDB() method.
     ******************************************************************/
    public void insertDB(String adt, String pid, String did, String pc){
        try{
            setApptDateTime(adt);
            setPatientId(pid);
            setDentistId(did);
            setProcCode(pc);
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
            sql = "insert into Appointments(apptDateTime, patId, dentId, procCode) values('"+getApptDateTime()+"', '"+getPatientId()+"', '"+getDentistId()+"', '"+getProcCode()+"')";
            System.out.println("// from the Appointment insertDB() method.");
            System.out.println(sql);
            System.out.println("");
            int numOfInserts = stmt.executeUpdate(sql);
            if(numOfInserts == 1){
                System.out.println("One Appointment was successfully scheduled.");
            }// end if()
            else if(numOfInserts != 1){
                System.out.println("Something went wrong...");
            }// end else if()
        }// end try
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }// end catch()
    }// end insertDB()
    /*****************************************************************
     updateDB() method. 
     *****************************************************************/
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
            sql = "update Appointments set apptDateTime = '"+getApptDateTime()+"', dentId = '"+getDentistId()+"', procCode = '"+getProcCode()+"' where patId = '"+getPatientId()+"'";
            System.out.println("// from the Appointment updateDB() method.");
            System.out.println(sql);
            System.out.println("");
            /**********************************************************
             step 5: process through the data.
             **********************************************************/
            int numberOfUpdates = stmt.executeUpdate(sql);
            if(numberOfUpdates == 1){
                System.out.println("One Appointment was successfully updated.");
               /**********************************************************
                 step 6: close the connection to the database.
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
    /********************************************************
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
            sql = "delete from Appointments where patId = '"+getPatientId()+"'";
            System.out.println("// from the Appointment deleteDB() method.");
            System.out.println(sql);
            System.out.println("");
            int numOfDeletes = stmt.executeUpdate(sql);
            if(numOfDeletes == 1){
                System.out.println("One Appointment was successfully deleted.");
            }// end if()
            else if(numOfDeletes != 1){
                System.out.println("Something went wrong...");
            }// end else if()
        }// end try
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }// end catch()
    }// end deleteDB()
    /*********************************************************************
     display() method.
     *********************************************************************/
    public void display(){
        System.out.println("Appointment Date, Time: "+getApptDateTime());
        System.out.println("Patient Id: "+getPatientId());
        System.out.println("Dentist Id: "+getDentistId());
        System.out.println("Procedure Code: "+getProcCode());
    }// end display()
    
    /*********************************************************************
      main() method for testing
     *********************************************************************/
    public static void main(String[] args){
    /********************************************************************
        // creating an Appointment Object
        Appointment a1 = new Appointment();
        a1.setApptDateTime("May 7, 2018, 2pm");
        a1.setPatientId("A900"); 
        a1.setDentistId("D201");
        a1.setProcCode("p321");
        a1.display();  
        
        // testing the selectDB() method
        Appointment a2 = new Appointment();
        a2.selectDB("A888");
        a2.display();   
    
        // testing the insertDB() method
        Appointment a3 = new Appointment();
        a3.insertDB("May 8, 2018, 8am", "A888", "D300", "P114");
        a3.display();  

        //testing the insertDB() method();
        Appointment a4 = new Appointment();
        a4.selectDB("A888");
        a4.setDentistId("D202");
        a4.updateDB();
        a4.display();  
    
        //testing the deleteDB() method.
        Appointment a5 = new Appointment();
        a5.selectDB("A888");
        a5.deleteDB();
        a5.display();  
    **********************************************************************/
    }// end main()
}// end Appointments class
