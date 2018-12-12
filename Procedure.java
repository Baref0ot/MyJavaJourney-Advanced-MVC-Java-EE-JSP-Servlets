package Business;
import java.sql.*;
/*******************************************************************************
 
   Name: Matthew Wright
   Date: 15 November 2018
   Description: This is a business object class for Patients of the ConfidentU Java
                Enterprise Level web application.
 
   Last updated: 11-28-2018: 
   
 ******************************************************************************/
public class Procedure {
    
     /******************************************************
     Declarations
     ******************************************************/
    private String procCode;
    private String procName;
    private String procDesc;
    private double cost;
    
    /************************************************************
     Setters and Getters
     ***********************************************************/
    public void setProcCode(String pc){
        procCode = pc;
    }// end setProcCode()
    public String getProcCode(){
        return procCode;
    }// end getProcCode()
    public void setProcName(String pn){
        procName = pn;
    }// end setProcName()
    public String getProcName(){
        return procName;
    }// end getProcName()
    public void setProcDesc(String pd){
        procDesc = pd;
    }// end setProcDesc()
    public String getProcDesc(){
        return procDesc;
    }// end getProcDesc()
    public void setCost(double co){
        cost = co;
    }// end setCost()
    public double getCost(){
        return cost;
    }// end getCost()
    
    /************************************************
     Constructors
     ************************************************/
    public Procedure(){
        setProcCode("");   
        setProcName("");
        setProcDesc("");
        setCost(0.0);
    }//end Procedure()
    public Procedure(String pc, String pn, String pd, double co){
         setProcCode(pc);   
        setProcName(pn);
        setProcDesc(pd);
        setCost(co);
    }//end Procedure()
   
    /********************************************************* 
     selectDB() method. 
     *********************************************************/
    public void selectDB(String pc){
        setProcCode(pc);
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
            sql = "select * from Procedures where procCode = '"+getProcCode()+"'";
            System.out.println("// from the Procedure selectDB() method");
            System.out.println(sql);
            System.out.println("");
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            // step 5: process through the data that has been placed in the result set.
            rs.next();
            setProcName(rs.getString("procName"));
            setProcDesc(rs.getString("procDesc"));
            setCost(Double.parseDouble(rs.getString("cost")));
            // step 6: close the connection to the database.
            con.close();
        }//end try
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }// end catch()
    }//end selectDB()
    
    /******************************************************************
     insertDB() method.
     ******************************************************************/
    public void insertDB(String pc, String pn, String pd, double co){
        setProcCode(pc);
        setProcName(pn);
        setProcDesc(pd);
        setCost(co);
        try{
            // step 1: Load the driver.
            String driver ="net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            // step 2: Get a connection to the database.
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week8Project/DentistOfficeMDB.mdb");
            // step 3: Create a memory location for the sql statement to be passed in to the database via the connection to be executed.
            Statement stmt = con.createStatement();
            // step 4: create the sql query that you wish to be placed in the Statement object (stmt) to be sent over to the database to be executed.
            String sql;
            sql = "insert into Procedures(procCode, procName, procDesc, cost) values('"+getProcCode()+"', '"+getProcName()+"', '"+getProcDesc()+"', "+getCost()+")";
            System.out.println("// from the Procedure insertDB() method.");
            System.out.println(sql);
            System.out.println("");
            // step 5: execute the sql using the stmt object.
            int numOfInserts = stmt.executeUpdate(sql);
            if(numOfInserts == 1){
                System.out.println("One procedure was added to the datebase.");
                con.close();
            }// end if()
            else if(numOfInserts != 1){
                System.out.println("Something went wrong...");
                con.close();
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
            // step 1: Load the Driver.
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            // step 2: Get a Connection to the database.
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week8Project/DentistOfficeMDB.mdb");
            // step 3: Create a memory location for the sql statement to be passed in to the database via the connection to be executed.
            Statement stmt = con.createStatement();
            // step 4: Create the sql query that you wish to be placed in the Statement object (stmt) to be sent over to the database to be executed.
            String sql;
            sql = "update Procedures set procName = '"+getProcName()+"', procDesc = '"+getProcDesc()+"', cost = '"+getCost()+"' where procCode = '"+getProcCode()+"'";
            System.out.println("// from the Procedure updateDB() method.");
            System.out.println(sql);
            System.out.println("");
            // execute the sql using the Statement object stmt.
            int numOfUpdates = stmt.executeUpdate(sql);
            if(numOfUpdates == 1){
                System.out.println("One Procedure has been updated.");
                // step 6: close the connection to the database.
                con.close();
            }// end if()
            else if(numOfUpdates != 1){
                System.out.println("Something went wrong...");
                // step 6: close the connection to the database.
                con.close();
            }// end else if()
        }// end try
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }// end catach()
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
            sql = "delete from Procedures where procCode = '"+getProcCode()+"'";
            System.out.println("// from the Procedure deleteDB() method.");
            System.out.println(sql);
            System.out.println("");
            // step 6: execute the sql with the Statement object stmt.
            int numOfDeletes = stmt.executeUpdate(sql);
            if(numOfDeletes == 1){
                System.out.println("One Procedure has been deleted.");
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
        System.out.println("Procedure Code: "+getProcCode());
        System.out.println("Procedure Name: "+getProcName());
        System.out.println("Procedure Description: "+getProcDesc());
        System.out.println("Cost: "+getCost());
    }// end display()
    
    /*********************************************************************
      main() method for testing
     *********************************************************************/
    public static void main(String[] args){
    /*********************************************************************
        // creating a Procedure Object.
        Procedure p1 = new Procedure();
        p1.setProcCode("P800");
        p1.setProcName("Whitening");
        p1.setProcDesc("Teeth Whitening");
        p1.setCost(129.99);
        p1.display();  
        
        // testing the selectDB() method.
        Procedure p2 = new Procedure();
        p2.selectDB("P114");
        p2.display();  
        
        // testing the insertDB() method.
        Procedure p3 = new Procedure();
        p3.insertDB("P800", "Meani Henkel", "DESCRIPTION!!!", 99.99);
        p3.display();  
    
        // testing the updateDB() method.
        Procedure p4 = new Procedure();
        p4.selectDB("P800");
        p4.setProcName("TestName");
        p4.updateDB();
        p4.display(); 
        
        // testing the deleteDB() method.
        Procedure p6 = new Procedure();
        p6.selectDB("P800");
        p6.deleteDB();
        p6.display();  
    *********************************************************************/
    }// end main()
}// end Procedure class
