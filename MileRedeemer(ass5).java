/*-------------------------------------------------------------------------
 Magali Gutierrez   z1915336   04/25/2025

	MileRedeemer  Class
 
 Purpose: 
 Redeemes milage. encapsulates private instance variables for an 
 array (MileTicket) objects.
 shows remaining miles.  
--------------------------------------------------------------------------*/
import java.util.*;

public class MileRedeemer{
  private int remainingMiles = 0;	//remaing miles after redeem.    

  //class for normal milage descending - sorting 
   class TicketComparator implements Comparator<MileTicket>{
    public int compare(MileTicket t1, MileTicket t2){
      return (t2.getNormalMiles() - t1.getNormalMiles());
    }
  }

//---------------------------------------------------------------
//	MileTicket[] readDestinations method
//Purpose: 
//   Uses Scanner object to read and parse the data into 
//   array MileTicket then sorts by their normal Mileage. 
//-------------------------------------------------------------
  public MileTicket[] readDestinations(Scanner fileScanner){
    ArrayList<MileTicket> destinationList = new ArrayList<>();	//created array for list from file. 
    
    while(fileScanner.hasNextLine()){
      String line = fileScanner.nextLine();	//gets the lines data.
      String[] parts = line.split(";");		//splits at ; to index the data as list. 
      
        String destination = parts[0];	//the first string of data is the city name
	int normalMiles = Integer.parseInt(parts[1].trim()); //indexes the miles to index 1 of the array.
        int supersaverMiles = Integer.parseInt(parts[2].trim()); //index 2. 
        int upgradeMiles = Integer.parseInt(parts[3].trim()); //index 3. 

	//for last part of data (-); new trim 
	String[] months = parts[4].split("-");
	int startMonth = Integer.parseInt(months[0].trim());	//position 0.
	int endMonth = Integer.parseInt(months[1].trim());	//position 1. 

	//arrayy MileTicket is added to Destination List. 
	MileTicket ticket = new MileTicket(destination, normalMiles, supersaverMiles, upgradeMiles, startMonth, endMonth);
            destinationList.add(ticket);
     }

        MileTicket[] destinationArray = destinationList.toArray(new MileTicket[0]);
        Arrays.sort(destinationArray, new TicketComparator()); // Sort by normal mileage descending

	return destinationArray;
  }//end of class

//---------------------------------------------------------------
//	REDEEM METHOD
//	 
// Purpose: 
//     Calls other methods for subtasks. 
//-------------------------------------------------------------
  public void redeem(int miles, int month, MileTicket[] des){
    int[] results = new int[des.length];	
    remainingMiles = getRemainingMiles(miles, month, des, results);
    printTickets(des, results, remainingMiles);    
  }//end of redeem
  
//---------------------------------------------------------------
//	Get Remaining Miles  method
//
//Purpose: 
//    available miles to redeem. Determines economy or first class tickets. 
//    returns remaining miles.
//-------------------------------------------------------------
  public int getRemainingMiles(int miles, int month, MileTicket[] des, int[] results){
    int remaining = miles;
  
    //redeems economy class tickets. 
    for(int i = 0; i < des.length; i++){
      MileTicket ticket = des[i];
      //checks month for supersaver. 
      boolean isSupersaver = (month >= ticket.getStartMonth()&& month <= ticket.getEndMonth());
      //cheapest option  
      int requiredMiles = isSupersaver ? ticket.getSupersaverMiles() : ticket.getNormalMiles();

      if(remaining >= requiredMiles){
        results[i] = 1;		//economy class
        remaining -= requiredMiles;
      }
    }

    //upgrades economy tickets to first class. 
    for(int i = 0; i < des.length; i++){
	    //redeemed tickets for economy
        if (results[i] == 1 && remaining >= des[i].getUpgradeMiles()) {
            results[i] = 2;	//first class.
            remaining -= des[i].getUpgradeMiles(); 
        }
    }
     return remaining;    //left over miles after redeeming. 
  } 	//end of class
  
//---------------------------------------------------------------
//	PRINT TICKETS  method
//
//Purpose:
//    prints ticket information
//-------------------------------------------------------------
  public void printTickets(MileTicket[] sortedDes, int[] results, int remainMiles){
 
    System.out.println("Your accumulated miles can be used to redeem the following tickets:");

    //loop that goes through each ticket info once redeemed. 
    for(int i = 0; i < sortedDes.length; i++){
        MileTicket ticket = sortedDes[i]; //current
        if(results[i] == 1){	//economy is 1.
           System.out.println("*A trip to " + ticket.getDestination() + ", economy Class");
         }else if(results[i] == 2){ // first class is 2. 
	      System.out.println("*A trip to " + ticket.getDestination() + ", first Class");       
      } 
    }
    System.out.println("Your remaining miles: " + remainingMiles);	//remaining
  }//end of class
}//end of file class.
