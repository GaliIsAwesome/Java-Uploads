/*  	Magali Gutierrez z1915336

	Assignment 3 Part 2 Winner Program. 

	Create multiple functions/methods 
	to sort or search through an array list. 
 */


import java.io.File;
import java.util.Scanner;

public class MainClass {

	public static Winner [] listOfWinners;
	
	public static void loadFromFile() {
		try{
			//Create instance of Scanner and provide instance of File pointing to the txt file
			Scanner input = new Scanner(new File("Winners.txt"));
			
			//Get the number of teams
			int years = input.nextInt();
			input.nextLine();//move to the next line
			
			//Create the array
			listOfWinners = new Winner[years];
			
			//for every year in the textfile
			for(int index = 0; index<years; index++)
			{
				//Get the year
				int year = input.nextInt();
				input.skip("	");

				//Get the team
				String team = input.nextLine();
				
				//Create an instance of Winner and add it to the next spot in the array
				listOfWinners[index] = new Winner(team,year);
			}
		} catch(Exception e) {
			System.out.println("Something wrong in the loadFromFile method happened!");
			System.out.println(e.toString());
			System.exit(0);
		}
	}


	/*---------------------------------------------
	 *	Sorts the list of teams from the array 
	 *	In alphabetical order. 
	 *--------------------------------------------
	 */
	public static void sortByTeamName() {

		//loops through the array depending on the size of content length.  
		for(int i = 0; i < listOfWinners.length - 1; i++){
			//Swaps elements by comparing 
			for(int j = 0; j < listOfWinners.length - i - 1; j++){
				//compares the name alphabetically. 
				if(listOfWinners[j].getTeam().compareTo(listOfWinners[j + 1].getTeam()) > 0){	
					//swapsthe element with temporary index 
					Winner idx = listOfWinners[j];
					listOfWinners[j] = listOfWinners[j + 1];
					listOfWinners[j + 1] = idx;
				}
			}
		}
	}

	/*---------------------------------------------
	 *	Sorts the list of teams from the array 
	 *	by year. 
	 *--------------------------------------------
	 */
	public static void sortByYear() {
		//Loops through the array 
		for(int i = 0; i < listOfWinners.length - 1; i++){
			//i is the earliest year. 
			int index = i;
			//searches for the smallest year thats not already in order. 
			for(int j = i + 1; j < listOfWinners.length; j++){
				if(listOfWinners[j].getYear() < listOfWinners[index].getYear()){
					index = j;//updates 
				}
			}
			//sorts by swapping with temporary index element
			Winner idx = listOfWinners[index];
			listOfWinners[index] = listOfWinners[i];
			listOfWinners[i] = idx;			
		}
	}
	 
	public static void printArray() {
		//Print the array
		for(int index=0; index<listOfWinners.length; index++) {
			System.out.println(listOfWinners[index].getYear()+" Winners " + listOfWinners[index].getTeam());
		}
	}
	
	/*---------------------------------------------
	 *	Searches for a winner by year
	 *--------------------------------------------
	 */
	public static void searchForWinnerByYear(int year) {	
		boolean found = false; 

		//Loops to find the year asked. 
		for(int i = 0; i < listOfWinners.length; i++){
			//compares the years to the input. 
			if(listOfWinners[i].getYear() == year){
				//prints out the match. 
				System.out.println("Winning team: " + year + " " + listOfWinners[i].getTeam());
				found = true; 
				break;

			}	
		}
		//when a year is not found 
		if(!found){
			System.out.println("No Winner Found");
		}
	}
	
	/*---------------------------------------------
	 *	Searches for the years a team won
	 *--------------------------------------------
	 */
	public static void searchForYearsATeamWon(String team) {
		boolean found = false; 

		//loops list
		for(int i = 0; i < listOfWinners.length; i++){
			//compares to find input match
			if(listOfWinners[i].getTeam().equalsIgnoreCase(team)){
				//displays results. 
				System.out.println(team + " won in " + listOfWinners[i].getYear());
				found = true; 
			}	
		}
		//if not found 
		if(!found){
		    System.out.println("No Winner Found");
		}
	}


	public static void main(String[] args) {
		
		int choice;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("World Series Program");
		
		//Load textfile 
		loadFromFile();
		do{
			System.out.println("1.........Print out the Winner List sorted by team name");
			System.out.println("2.........Print out the Winner List sorted by years");
			System.out.println("3.........Print out the Winner of a particular year");
			System.out.println("4.........Print out the years a particular team won");
			System.out.println("5.........Exit the Program");
			System.out.println("Which Choice Would You Like?");
			choice = keyboard.nextInt();
			
			switch(choice) {
			case 1:
				//Option 1, sort array by name and print out.
				sortByTeamName();
				printArray();
				break;
			case 2:
				//Option 2, sort array by year and print out.
				sortByYear();
				printArray();
				break;
			case 3:
				//Option 3 Search for winner by year
				System.out.println("What year would you like to find the winner?");
				int year = keyboard.nextInt();
				searchForWinnerByYear(year);
				break;
			case 4:
				//Option 4 Search for years a team won
				System.out.println("What team would you like to check for years won?");
				keyboard.nextLine();
				String team = keyboard.nextLine();
				searchForYearsATeamWon(team);
				break;
			case 5://Exit
				break;
			default:
				System.out.println("Invalid Choice");
			}
		} while(choice != 5);
		
		System.out.println("Goodbye!");
	}
}

