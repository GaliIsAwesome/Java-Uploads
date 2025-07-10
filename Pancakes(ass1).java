/**
 *	Magali Gutierrez 
 *
 *	Assigment 1 - Ingredient Adjuster
 *
 *	Uses user inout to display the number of ingredients 
 *	needed to make enough pankcakes for the user. 
 *
 */

	//Scanner class
	import java.util.Scanner;


public class Pancakes
{
	public static void main(String[] args)
	{
		//creates scanner object
		Scanner userIn = new Scanner(System.in);
		
		//the cups of ingredients for 26 pancakes. 
		double sugar  = 3;
		double butter = 1;
		double flour  = 7;


			//will store users input 
			int numPancakes;
	
			//asks user for a number 
			System.out.print("How many Pankes do you want to make? ");
			numPancakes = userIn.nextInt();

			//Double values for division 
			double need_sugar  = (sugar/26) * numPancakes;
			double need_butter = (butter/26) * numPancakes; 
			double need_flour  = (flour/26) * numPancakes; 

			//Results in formated rounded decimal fro more accuracy. 
			System.out.println("\nTo make " + numPancakes + " pancakes, you will need: \n");
			System.out.printf(" %.2f cups of Sugar\n", need_sugar);
			System.out.printf(" %.2f cups of Butter\n", need_butter);
			System.out.printf(" %.2f cups of Flour\n", need_flour);
	}
}

