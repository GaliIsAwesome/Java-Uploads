/**
 	Magali Gutierrez
	Assignment 1 - Word Game
 
	Asks users for input and demonstrates the way input is used. 
 */


	//scanner class
	import java.util.Scanner;

	
public class wordGame {

	public static void main (String[] args)
	{

		//declared strings and integer value for age. 
		String  name;
		int  	age; 
		String  country;
		String  model;
		String 	make;

		//creating scanner object
		Scanner userIn = new Scanner (System.in);
	
			//asks user for input and stores in name.
			System.out.print("Enter a Persons Name: ");	
			name  = userIn.nextLine();

			//stores input in int age. 
			System.out.print("Enter an  Age: ");
			age = userIn.nextInt();

			//moves to next line after an integer. 
			userIn.nextLine();

			//country input
			System.out.print("Enter the Name of a Country: ");
			country = userIn.nextLine();

			//car model input 
			System.out.print("Enter a Car Model: ");
			model = userIn.nextLine();

			//car make input
			System.out.print("Enter the Cars Make: ");
			make = userIn.nextLine();

			//printing story. 
			System.out.printf("\n%s lived in %s. " 
					 + "At the age of %d, "
					 + "%s purchased a %s made by %s\n\n"
			       		 , name, country, age, name , model, make); 	

			//Additional silly story 
			System.out.println(name + " accidentally drove the "
				         + age + " year old "	
					 + make + " " + model + " into the " + country + " ocean.\n"); 
					 
	}	
}
