/*--------------------------------------------------------------
 Magali Gutierrez   z1915336   04/10/2025

	Item Class
 
 Purpose: 
 Maintains information about a particular instance item.
--------------------------------------------------------------*/

//---Attributes---\\
public class Item{
  private String name; 
  private int quantity;
  private double price; 
  private String upc; 

//------------------------------------------------------------------

  //Default constructor for Item Class. 
  private Item(){

  }
//Second public constructor, initializing this.
   public Item(String name, int qty, double price, String upc){
	this.name = name; 
	this.quantity = qty; 
	this.price = price;
	this.upc = upc; 
  }
  //returning methods
  public String getName(){
	return name; 
  }
  public int getQuantity(){
	return quantity; 
  }
  public double getPrice(){
	return price;
  }
  public String getUPC(){
	return upc; 
  }
}//end of class




