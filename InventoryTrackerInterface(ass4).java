/*--------------------------------------------------------------
 Magali Gutierrez   z1915336   04/10/2025

	InventoryTrackerInterface Class

 Purpose: 
 creates an instance of inventory and user interactive. 
 Performs operations from main class method. 
--------------------------------------------------------------*/

import java.util.Scanner;
import java.io.IOException;

//---MainMethod--\\ 

public class InventoryTrackerInterface{
  public Inventory inv; 

  public static void main(String[] args) throws IOException{
    Scanner userInput = new Scanner(System.in); //Creating scanner for user input

    Inventory inv = new Inventory(); 
  
    int selection = 0; 
 
    //The menu to perform interaction
    while (selection != 5){
            System.out.println("1. Add an item to the inventory");
            System.out.println("2. Get an items info");
            System.out.println("3. Save inventory to file");
            System.out.println("4. Load inventory from file");
            System.out.println("5. Exit");
	    selection = userInput.nextInt(); 
	    userInput.nextLine();

	    //compares the user selection to switch statment case
	    switch (selection){
		    //asks user for information entry. 
		    case 1: 
	            System.out.print("Enter the new items name\n");
                    String name = userInput.nextLine();

                    System.out.print("Enter the new items quantity\n");
                    int quantity = userInput.nextInt();

                    System.out.print("Enter the new items price\n");
                    double price = userInput.nextDouble();

                    System.out.print("Enter the new items upc\n");
                    String upc = userInput.next();

                    Item newItem = new Item(name, quantity, price, upc);
                    inv.addItem(newItem);
                    break;
		   
		    //Asks user to view information entered. 
		    case 2: 
		    //base on item number if its 0, no item was saved. 
		    int total = inv.getTotalNumberOfItems();
		    if(total == 0){
			    System.out.println("No items in inventory.");
			    break;
		    }

		    System.out.print("Which item would you like info for? [0-" + (inv.getTotalNumberOfItems() - 1) + "]? \n");
		    int index = userInput.nextInt();
		    userInput.nextLine(); 
		    Item item = inv.getItem(index);
		    
		    //Displays information for the item selected. 
		    if(item != null){
			System.out.println("Name:     " + item.getName());
                        System.out.println("Quantity: " + item.getQuantity());
                        System.out.println("Price:    " + item.getPrice());
                        System.out.println("UPC:      " + item.getUPC());
		    } else{
			System.out.println("Item not found");
		    }
		    break;
		    
		    //saves entry to .txt
		    case 3: 
		    inv.saveInventoryToFile("inventory.txt");
		    System.out.println("Inventory Saved");
		    break; 

		    //loads the entry from the .txt
		    case 4: 
		    inv.loadInventoryFromFile("inventory.txt");
		    System.out.println("Inventory Loaded");
		    break;

                    //Exits from the loop and program. 
		    case 5: 
		    System.out.println("Goodbye!");
		    break; 

		    //if no switch meets case number. 
		    default: 
		    System.out.println("Invalid. Select 1-5");
	    }//end of switch
      }
  }
}//end of class

