/**************************************************************
 *
 * Matthew Lee Wright
 * Java 3
 * 20 September 2018
 *
 ***************************************************************/
package Business;
import static java.lang.System.out;
import java.sql.*;

public class CustBusObj {

    // Properties and customer "AccountList object"
    private String custId;
    private String custPassWord;
    private String custFirstName;
    private String custLastName;
    private String custAddress;
    private String custEmail;
    public AccountList alist = new AccountList();
    // Method : Setters and Getters - each methods setter and getter are placed together
    private void setCustId(String cid) {
        custId = cid;
    }// end setCustID

    public String getCustId() {
        return custId;
    }// end getCustID

    private void setCustPassWord(String cpw) {
        custPassWord = cpw;
    }// end setCustPassWord

    public String getCustPassWord() {
        return custPassWord;
    }// end getCustPassWord

    private void setCustFirstName(String cfn) {
        custFirstName = cfn;
    }// end setCustFirstName

    public String getCustFirstName() {
        return custFirstName;
    }// end getCustFirstName

    private void setCustLastName(String cln) {
        custLastName = cln;
    }// end setCustLastName

    public String getCustLastName() {
        return custLastName;
    }// end getCustLastName

    private void setCustAddress(String ca) {
        custAddress = ca;
    }// end setCustAddress

    public String getCustAddress() {
        return custAddress;
    }// end getCustAddress

    private void setCustEmail(String ce) {
        custEmail = ce;
    }// end setCustEmail

    public String getCustEmail() {
        return custEmail;
    }// end getCustEmail

    private void setAlist(AccountList a){
        alist = a;
    }// end setAList 
    
    public AccountList getAlist(){
        return alist;
    }// end getAList
            
    // Constructor Methods
    public CustBusObj() {
        setCustId(" ");
        setCustPassWord(" ");
        setCustFirstName(" ");
        setCustLastName(" ");
        setCustAddress(" ");
        setCustEmail(" ");
    }// end CustBusObj empty Constructor

    public CustBusObj(String id, String password, String firstName, String lastName, String address, String email) {
        setCustId(id);
        setCustPassWord(password);
        setCustFirstName(firstName);
        setCustLastName(lastName);
        setCustAddress(address);
        setCustEmail(email);
    }// end CustBusObj Constructor
    
    public void getAccounts(){
         try {
            // step 1 and step 2: get a connection and load the driver
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week1/ChattBankMDB.mdb");
            // step 3: create a memory location for a statement in which data from the database can be placed
            Statement stmt = con.createStatement();
            // step 4: start executing sql statemtents on the database through java
            String sql;
            sql = " select AcctNo from Accounts where Cid = '"+getCustId()+"'";
            System.out.println(sql+"    // from getAccounts method in the CustBusObj class.");
            ResultSet rs = stmt.executeQuery(sql);
            String accountNumber;
            AccountBusObj a1 = null;
            while(rs.next()){
                accountNumber = rs.getString(1);
                a1 = new AccountBusObj();
                a1.selectDB(accountNumber);
                alist.addAccount(a1);
            }// end while
            }// end try
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }// end catch
    }// end AccountList

    public void selectDB(String custID){
        setCustId(custID);
        try {
            // step 1 and step 2: get a connection and load the driver
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week1/ChattBankMDB.mdb");
            // step 3: create a memory location for a statement in which data from the database can be placed
            Statement stmt = con.createStatement();
            // step 4: start executing sql statemtents on the database through java
            String sql;
            sql = " select * from Customers where CustID  = '"+getCustId()+"'";
            System.out.println(sql+"    // from selectDB method in the CustBusObj class.");
            ResultSet rs = stmt.executeQuery(sql);
            // step 5: process the result set
            rs.next();
            setCustPassWord(rs.getString(2));
            setCustFirstName(rs.getString(3));
            setCustLastName(rs.getString(4));
            setCustAddress(rs.getString(5));
            setCustEmail(rs.getString(6));
        }// end try
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }// end catch
        getAccounts();
    }//end selectDB

    public void insertDB(String custId, String custPassword, String custFirstName, String custLastName, String custAddress, String custEmail){
        try {
            setCustId(custId);
            setCustPassWord(custPassword);
            setCustFirstName(custFirstName);
            setCustLastName(custLastName);
            setCustAddress(custAddress);
            setCustEmail(custEmail);
            // step 1 and step 2: get a connection and load the driver
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week1/ChattBankMDB.mdb");
            // step 3: create a memory location for a statement in which data from the database can be placed
            Statement stmt = con.createStatement();
            // step 4: start executing sql statemtents on the database through java
            String sql;
            sql = "insert into Customers values('" + getCustId() + "', '" + getCustPassWord() + "', '" + getCustFirstName() + "', '" + getCustLastName() + "', '" + getCustAddress() + "', '" + getCustEmail() + "')";
            System.out.println(sql);
            int numOfInserts = stmt.executeUpdate(sql);
            if (numOfInserts == 1) {
                System.out.println("1 Customer row was inseted into the Customer database.");
            }// end if
            else if (numOfInserts != 1) {
                System.out.println("Something went wrong...");
            }// end else if
        }// end try
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }// end catch
    }// end insertDB  

    public void updateDB(){
        try {
            // step 1 and step 2: get a connection and load the driver
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week1/ChattBankMDB.mdb");
            // step 3: create a memory location for a statement in which data from the database can be placed
            Statement stmt = con.createStatement();
            // step 4: start executing sql statemtents on the database through java
            String sql;
            sql = "update Customers set CustPassword = '"+getCustPassWord()+"', CustFirstName = '"+ getCustFirstName()+"', CustLastName = '"+getCustLastName()+"', CustAddress = '"+getCustAddress()+"', CustEmail = '"+getCustEmail()+"' where CustID = '"+getCustId()+"'";
            System.out.println(sql);
            int numOfUpdates = stmt.executeUpdate(sql);
            if (numOfUpdates == 1) {
                System.out.println(" 1 row successfully updated. ");
            }// end if
            else if (numOfUpdates != 1) {
                System.out.println(" Something went wrong. ");
            }// end else if
        }// end try
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }// end catch
    }// end updateDB

    public void deleteDB(){
       try{
           // step 1 and step 2: get a connection and load the driver
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week1/ChattBankMDB.mdb");
            // step 3: create a memory location for a statement in which data from the database can be placed
            Statement stmt = con.createStatement();
            // step 4: start executing sql statemtents on the database through java
            String sql;
            sql = "delete from Customers where CustID = '"+getCustId()+"'";
            System.out.println(sql);
            int numberOfDeletes = stmt.executeUpdate(sql);
            if(numberOfDeletes == 1){
               System.out.println(" 1 row successfully deleted. "); 
            }// end if
            else if(numberOfDeletes != 1){
                System.out.println(" Something went wrong... ");
            }// else if
       }// end try
       catch(ClassNotFoundException | SQLException e){
           System.out.println(e);
       }// end catch
    }// end deleteDB
    
    // Display 
    public void display() {
        System.out.println("");
        System.out.println(" CUSTOMER INFORMATION: ");
        System.out.println(" Username: " + getCustId());
        System.out.println(" Password: " + getCustPassWord());
        System.out.println(" First Name: " + getCustFirstName());
        System.out.println(" Last Name: " + getCustLastName());
        System.out.println(" Address: " + getCustAddress());
        System.out.println(" Email: " + getCustEmail());
        System.out.println("");
        System.out.println(" CUSTOMER ACCOUNTS: "); 
        alist.display();
        System.out.println();
    }// end Display

    // main method for testing
    public static void main(String[] args) throws ClassNotFoundException {
        // customer 1: Testing the first Constructor
/*      CustBusObj c1 = new CustBusObj();
        c1.setCustID("1234");
        c1.setCustPassWord("password");
        c1.setCustFirstName("Matthew");
        c1.setCustLastName("Wright");
        c1.setCustAddress("121 PineRidge rd. NW White, GA 30184");
        c1.setCustEmail("Mattwright700@yahoo.com");
        c1.Display(); */

        // customer 2: Testing the second Constructor
/*      CustBusObj c2 = new CustBusObj("5678","Monkeyjump","John","Smith","222 ExampleTest Dr","JohnSmith@exmaple.com");
        c2.Display(); */
 
        // customer 3: Testing the selectDB method
        CustBusObj c3 = new CustBusObj();
        c3.selectDB("3002");
        c3.display(); 

        // customer 4: Testing the insertDB method
/*       CustBusObj c4 = new CustBusObj();
        c4.insertDB("Baref0ot","Monkeyboy65","Matthew","Wright","121 Pine Ridge Rd. NW","Mattwright700@yahoo.com");
        c4.Display(); */  
        
        // customer 5: Testing the updateDB method
/*      CustBusObj c5 = new CustBusObj();
        c5.selectDB("3001");
        c5.setCustLastName("Wright");
        c5.updateDB();
        c5.Display();  */

        // customer 6: Testing the deleteDB method
/*      CustBusObj c6 = new CustBusObj();
        c6.selectDB("Baref0ot");
        c6.deleteDB();  */

        // customer 7: Testing the getAccouts method to see if the various accounts 1 cusomer may have will displayed
/*       CustBusObj c7 = new CustBusObj();
        c7.selectDB("3003");
        c7.display(); */
        
        CustBusObj c8 = new CustBusObj();
 /*       c8.selectDB("1004");
        c8.deleteDB();  */
    }// end main
}// end class
