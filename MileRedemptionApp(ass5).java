/*--------------------------------------------------------------
 Magali Gutierrez   z1915336   04/25/2025

	MileRedemptionApp  Class
 
 Purpose: 
 Main method with a loop for user interaction and input. 
 --------------------------------------------------------------*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;
    
public class MileRedemptionApp{
  public static void main(String[] args){
     //check matching file name
     if(args.length != 1){
	 System.out.println("File Not Found");
          return;
     }

     //scanner to read
     Scanner fileScanner;
     try{  //scanner reads the file. 
            fileScanner = new Scanner(new File(args[0]));
     }catch(FileNotFoundException e){
          System.out.println("Error: File not found ");
          return;
     }

      //instance of Mileredeemer. 
       MileRedeemer redeemer = new MileRedeemer();
       MileTicket[] tickets = redeemer.readDestinations(fileScanner);
 
       fileScanner.close(); //closed file

       System.out.println("-----------------------------");
       System.out.println("List of destination cities you can travel to:");
       for(MileTicket ticket : tickets){
	  System.out.println(ticket.getDestination());
       }
       System.out.println("-----------------------------");
  
       //user input scanner. 
        Scanner userinput = new Scanner(System.in);
        boolean entry = true;

        while(entry){
            int miles = 0;
            int month = 0;

	    //asks user input
           try{
                System.out.print("Please input your total accumulated miles: ");
                miles = userinput.nextInt();

                System.out.print("Please input your month of departure (1-12): ");
                month = userinput.nextInt();

                redeemer.redeem(miles, month, tickets);
            }catch(InputMismatchException e){ //handling exception
                System.out.println("Invalid input. Please enter numbers for miles and month.");
                userinput.nextLine(); 
	    }

            System.out.print("Do you want to continue (y/n)? ");
            userinput.nextLine(); 
	    String choice = userinput.nextLine().trim();

            if(!choice.equalsIgnoreCase("y")){
                entry = false;
            }
        }

        userinput.close();
    }
}

