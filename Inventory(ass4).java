/*--------------------------------------------------------------
 Magali Gutierrez   z1915336   04/10/2025

	Inventory  Class
 
 Purpose: 
 Has an array to maintain items in inventory. 
--------------------------------------------------------------*/
import java.io.*;

public class Inventory{
  //Array
  private Item[] itemArray = new Item[100]; 
  private int totalItems = 0; 

  //Keeps track of how many itmes have been added to the array. 
  public int getTotalNumberOfItems(){
	  return totalItems;
  }

//Error checking index from the array. 
//Array has 100 spots to stor items.
public Item getItem(int index){
    if(index < 0 || index >= totalItems)
    {
	return null; 
    }
    else{ 
	return itemArray[index]; 
    }
  }

//Ensures instance that it is an instance of Item before being added to array. 
  public void addItem(Item newItem){
    if(newItem == null)
    {
	System.out.println("Item not added");
    }
    else{
    	itemArray[totalItems] = newItem; 
	totalItems++; 
    }
  }

  //Stores/saves infomTION PROVIDED INTO A file
  public void saveInventoryToFile(String fileName) throws IOException{					
    PrintWriter outputFile = new PrintWriter(fileName);//"FILENAME TO OPEN"
    for(int i = 0; i < totalItems; i++)
    {
	Item item = itemArray[i];
	outputFile.println(item.getName() + ", " + item.getQuantity() + ", " +item.getPrice() + ", " + item.getUPC());
    }

    outputFile.close(); //CLOSES FILE
  }
  //reads inventory info into itemArray
  public void loadInventoryFromFile(String fileName) throws IOException{
     BufferedReader readFile = new BufferedReader(new FileReader(fileName));
     totalItems = 0; 
     String line;

     //Splits the array by parts 
     while((line = readFile.readLine()) != null){
	String[] parts = line.split(",");
	itemArray[totalItems] = new Item(parts[0], Integer.parseInt(parts[1]), Double.parseDouble(parts[2]), parts[3]);
     totalItems++; 
     }
   readFile.close(); 
  }
}//end of class
