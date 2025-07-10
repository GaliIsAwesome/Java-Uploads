/*--------------------------------------------------------------
 Magali Gutierrez   z1915336   04/25/2025

	MileTicket  Class
 
 Purpose: 
   contains private istance variables. public methods and constructor.
 --------------------------------------------------------------*/
public class MileTicket{

	//Private instance variables
	private String destination;	//destination city name. 
	private int normalMiles;	//normal miles needed for an economy class ticket.
	private int supersaverMiles;		//supersavermiles needed for an economy class ticket.
	private int upgradeMiles;	//additional miles for a first class ticket. 
	private int startMonth;		//start month of supersaver program. 
	private int endMonth;  		//end month of supersaver program. 

//Constructor + Public Methods. 
  public MileTicket(String destination, int normalMiles, int supersaverMiles, int upgradeMiles, int startMonth, int endMonth){
    this.destination = destination;
    this.normalMiles = normalMiles;
    this.supersaverMiles = supersaverMiles;
    this.upgradeMiles = upgradeMiles; 
    this.startMonth = startMonth;
    this.endMonth = endMonth; 
  }//end of constructor. 
  
  public String getDestination(){
    return destination;
  }
  public int getNormalMiles(){
    return normalMiles;
  }
  public int getSupersaverMiles(){
    return supersaverMiles;
  }
  public int getUpgradeMiles(){
    return upgradeMiles;
  }
  public int getStartMonth(){
    return startMonth;
  }
  public int getEndMonth(){
    return endMonth;
  }
}//end of class
