/**
 	Magali Gutierrez 	Z1915336 
 	02/12/2025

 	Assignment 2 Part 1 FBMI calculator 
 
 	uses Scanner for user input and 
 	calculates the FBMI to output a 
 	status on a cats weight. 

 */




import java.util.Scanner;


//Class Called FBMICalc
public class FBMICalc
{

	public static void main(String[] args)
	{
		//Variables needed from user
		String Cat_Name;
		double Rib_Circumference;
		double Leg_Length;
	
		//creates input scanner. 
		Scanner userIn = new Scanner(System.in);


			//Asks user for information input. 
			System.out.print("Whats the Cats Name?: "); 
				Cat_Name = userIn.nextLine();
			System.out.print("Enter the Cats Ribcage Circumference: ");
				Rib_Circumference = userIn.nextDouble();
			System.out.print("Enter the Length of the Cats Leg: ");
	       			Leg_Length = userIn.nextDouble();	
	
	
		//Calculates the FBMI with the formula and input answers. 
		//Formula Provided
		double FBMI = ((Rib_Circumference / 0.7062) - Leg_Length) / 0.9156 - Leg_Length;

			//Shows the FBMI, i used it for testing
			//System.out.printf("The FBMI is %.2f \n", FBMI);

				//the category range using If statments to determine the cats weight. 
				if(FBMI >= 40)
				{
					System.out.println(Cat_Name + " is Very Obese");
				}
				else if(FBMI >= 35 && FBMI < 40)
				{	
					System.out.println(Cat_Name + " is Obese");
				}
				else if(FBMI >= 30 && FBMI < 35)
				{
					System.out.println(Cat_Name + " is Overweight");
				}
				else if(FBMI >= 15 && FBMI < 30)
				{
					System.out.println(Cat_Name + " is Normal");
				}
				else if (FBMI >= 10 && FBMI < 15)
				{
					System.out.println(Cat_Name + " is Underweight");
				}
				else if (FBMI < 10)
				{
					System.out.println(Cat_Name + " is Very Underweight");
				}

	}//end of main. 
}//end of class

