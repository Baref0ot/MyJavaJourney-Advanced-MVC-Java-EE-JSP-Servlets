package Business;
/*******************************************************************************
 
   Name: Matthew Wright
   Date: 28 November 2018
   Description: This is a business object class for Patients of the ConfidentU Java
                Enterprise Level web application.
 
  (Make them data access attributes public the Appointment class can have access.)
   
 ******************************************************************************/
public class AppointmentsList {
    
    /***********************************************
     Declarations
     ***********************************************/
    public int count = 0;
    // create an array of class type Appointment (located in the same package) that holds 10 Appointment objects.
    public Appointment appointmentsArray[] = new Appointment[20];
    
     /***************************************************
      create a method that accepts Appointment objects as parameters through 
      the variable "a" and set each object in the array at subscript "count" 
      which starts at 0 and stops at 10. 
       
      addAppointment(Appointment ap) method.
      **************************************************/
    public void addAppointment(Appointment ap){      
            appointmentsArray[count] = ap;
            count ++;        
    }// end addAppointment()
    /***************************************************
     display() method. 
     ***************************************************/
    public void display(){
        for(int x = 0; x < count; x++){
            appointmentsArray[x].display();
        }// end for()
    }// end display()
    
}// end AppointmentsList class
