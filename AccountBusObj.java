package Business;

/**************************************************************************
   
    Matthew Wright
    Java 3
    23 September 2018

 ****************************************************************************/

import static java.lang.System.out;
import java.sql.*;

public class AccountBusObj {

    // properties
    private String acctNo;
    private String custId;
    private String acctType;
    private double balance;
    private double amountDepWith;

    // Method : Setters and Getters - each methods setter and getter are placed together
    private void setAcctNo(String an) {
        acctNo = an;
    }// end setAcctNo

    public String getAcctNo() {
        return acctNo;
    }// end getAcctNo

    private void setCustId(String ci) {
        custId = ci;
    }// end setCustId

    public String getCustId() {
        return custId;
    }// end getCustId

    private void setAcctType(String at) {
        acctType = at;
    }// end setAcctType

    public String getAcctType() {
        return acctType;
    }// end getAcctType

    private void setBalance(double b) {
        balance = b;
    }// end setBalance

    public double getBalance() {
        return balance;
    }// end getBalance

    private void setAmountDepWith(double adw) {
        amountDepWith = adw;
    }// end setAmountDepWith

    public double getAmountDepWith() {
        return amountDepWith;
    }// end getAmountDepWith

    // Constructor Methods
    public AccountBusObj() {
        setAcctNo(" ");
        setCustId(" ");
        setAcctType(" ");
        setBalance(0);
        setAmountDepWith(0);
    }// end empty Constructor

    public AccountBusObj(String an, String ci, String at, double b, double adw) {
        setAcctNo(an);
        setCustId(ci);
        setAcctType(at);
        setBalance(b);
        setAmountDepWith(adw);
    }// end Constructor

    // Select
    public void selectDB(String acctNo) {
        setAcctNo(acctNo);
        try {
            // step 1 and step 2: get a connection and load the driver
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week1/ChattBankMDB.mdb");
            // step 3: create a memory location for a statement in which data from the database can be placed
            Statement stmt = con.createStatement();
            // step 4: start executing sql statemtents on the database through java
            String sql;
            sql = " select * from Accounts where AcctNo   = '" + getAcctNo() + "'";
            System.out.println(sql+"   // from selectDB method in the AccountBusObj class.");
            ResultSet rs = stmt.executeQuery(sql);
            // step 5: process the result set
            rs.next();
            setCustId(rs.getString(2));
            setAcctType(rs.getString(3));
            setBalance(rs.getDouble(4));
        }// end try
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }// end catch
    }// selectDB

    // Insert
    public void insertDB(String accntNo, String custId, String type, double bal) {
        try {
            setAcctNo(accntNo);
            setCustId(custId);
            setAcctType(type);
            setBalance(bal);
            // step 1 and step 2: get a connection and load the driver
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("net.ucanaccess.jdbc.UcanaccessDriver");
            // step 3: create a memory location for a statement in which data from the database can be placed
            Statement stmt = con.createStatement();
            // step 4: start executing sql statemtents on the database through java
            String sql;
            sql = "insert into Accounts values('" + getAcctNo() + "', '" + getCustId() + "', '" + getAcctType() + "', '" + getBalance() + "')";
            System.out.println(sql);
            int numOfUpdates = stmt.executeUpdate(sql);
            if (numOfUpdates == 1) {
                System.out.println(" 1 customer account was successfully created. ");
            }// end if
            else if (numOfUpdates != 1) {
                System.out.println(" Something went wrong... ");
            }// end else if
        }// end try
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }// end catch
    }// end insertDB

    // Update
    public void updateDB() {
        try {
            // step 1 and step 2: get a connection and load the driver
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week1/ChattBankMDB.mdb");
            // step 3: create a memory location for a statement in which data from the database can be placed
            Statement stmt = con.createStatement();
            // step 4: start executing sql statemtents on the database through java
            String sql;
            sql = "update Accounts set Type = '" + getAcctType() + "', Balance = " + getBalance() + " where AcctNo = '" + getAcctNo() + "'";
            System.out.println(sql);
            int numOfUpdates = stmt.executeUpdate(sql);
            if (numOfUpdates == 1) {
                System.out.println(" 1 account successfully updated. ");
            }// end if
            else if (numOfUpdates != 1) {
                System.out.println(" Something went wrong. ");
            }// end else if
        }// end try
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }// end catch
    }// end updateDB

    public void deleteDB() {
        try {
            // step 1 and step 2: get a connection and load the driver
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Mattw/Desktop/Java3/Week1/ChattBankMDB.mdb");
            // step 3: create a memory location for a statement in which data from the database can be placed
            Statement stmt = con.createStatement();
            // step 4: start executing sql statemtents on the database through java
            String sql;
            sql = " delete from Accounts where AcctNo = '" + getAcctNo() + "'";
            System.out.println(sql);
            int numOfDeletes = stmt.executeUpdate(sql);
            if (numOfDeletes == 1) {
                System.out.println(" 1 account successfully deleted. ");
            }// end if
            else if (numOfDeletes != 1) {
                System.out.println(" Something went wrong. ");
            }// end else if
        }// end try 
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }// end catch
    }// end deleteDB
    // Delete

    public void dep(double ad) {
        setAmountDepWith(ad);
        balance = getBalance() + getAmountDepWith();
    }// end deposit

    public void with(double aw) {
        setAmountDepWith(aw);
        balance = getBalance() - getAmountDepWith();
    }// end withdrawal

    public void deposit(String accountNum, double amount) {
        selectDB(accountNum);
        dep(amount);
        updateDB();
        display();
    }// end deposit

    public void withdrawal(String accountNum, double amount) {
        selectDB(accountNum);
        with(amount);
        updateDB();
        display();
    }// end withdrawal

    // Display
    public void display() {
        System.out.println(" Account Number: " + getAcctNo());
        System.out.println(" Username: " + getCustId());
        System.out.println(" Account Type: " + getAcctType());
        System.out.println(" Balance: $" + getBalance());
        System.out.println("");
    }// end Display

    public static void main(String[] args) {
        
        // Account 1: Testing selectDB method
    /*  AccountBusObj a1 = new AccountBusObj();
        a1.selectDB("90001");
        a1.display();                     */

        // Account 2: Testing insertDB method
    /*  AccountBusObj a2 = new AccountBusObj();
        a2.insertDB("34095", "3007", "CHK", 199992884.00);
        a2.display();                     */

        // Account 3: Testing updateDB method
    /*  AccountBusObj a3 =  new AccountBusObj();
        a3.selectDB("34095");
        a3.setBalance(1999928.00);
        a3.updateDB();
        a3.display();                     */

        // Account 4: Testing deleteDB method
    /*  AccountBusObj a4 = new AccountBusObj();
        a4.selectDB("34095");
        a4.deleteDB();
        a4.display();                      */ 

        // Account 5: Testing dep method
    /*  AccountBusObj a5 = new AccountBusObj();
        a5.selectDB("90000");
        a5.dep(5000000); 
        a5.updateDB();
        a5.display();                      */

        // Account 6: Testing with method
    /*  AccountBusObj a6 = new AccountBusObj();
        a6.selectDB("90000");
        a6.with(1000000);
        a6.updateDB();
        a6.display();                       */

        // Account 7: Testing deposit method
    /*  AccountBusObj a7 = new AccountBusObj();
        a7.deposit("90000", 30000000.00);   */ 

        // Account 8: Testing withdrawal method
    /*  AccountBusObj a8 = new AccountBusObj();
        a8.withdrawal("90000", 27000000.00); */    
    }// end main
}// end class
