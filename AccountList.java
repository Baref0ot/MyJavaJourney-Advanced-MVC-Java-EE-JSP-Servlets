/******************************************************************************
 
   Matthew Wright
   Java 3
   26  September 2018
   
 ******************************************************************************/
package Business;

public class AccountList {

    // properties and objects
    public int count = 0;
    /* creates an array that is able to hold 10 objects of the type 
    AccountBusObj class. */
    public AccountBusObj aArry[] = new AccountBusObj[10]; 
    
    
    /* create a method that accepts AcountBusObj objects as parameters through 
       the variable "a" and set each object in the array at subscript "count" 
       which starts at 0 and stops at 10. */
    public void addAccount(AccountBusObj a) {
            aArry[count] = a;
            count++;
    }// end addAccount

    /* create a display method that prints out the database data of each
       AccountBusObj Object listed in all the subscripts 0 through 10. 
       Since you are accessing the AccountBusObj class you can use its
       display method as aArry[x] ".display()". */
    public void display() {
        for (int x = 0; x < count; x++) {
            aArry[x].display();
        }// end for
    }// end display
}// end class
