/**

  Magali Gutierrez  z1915336
  02/12/2025

  Assignment 2 part 2 ASCII ART

  User interactive program. 
 	
  Manualy input an int
  to display a shape in ascii. Outputs the 
  shape through matching switch case. If user does not input 1-5 int
  error message prints. 

 */			




//for user inpout
import java.util.Scanner;


//class called ASCIIArt
public class ASCIIArt
{
	public static void main(String[] Args)
	{

		Scanner userIn = new Scanner(System.in);

		//shows what integers are what shape. 1-5
		System.out.println("1. Triangle\n"
				  +"2. Square\n"
				  +"3. Rectangle\n"
				  +"4. Trapezoid\n"
				  +"5. Hexagon\n");  
			//Asks the user to input a choice. 
			System.out.print("What shape do you want to see in ASCII Art?: ");
				int shape = userIn.nextInt();//collects the value.
				

					switch (shape)
					{	//if shape is number 1 = triangle 
						case 1:
						
						  //displays a triangle  
						  //used \t for better spacing
					     	  System.out.println("Triangle:");
				 		  System.out.println("\t     *\n"
						                    +"\t    * *\n"
				  	  	                    +"\t   *   *\n"
						                    +"\t  *     *\n"
					   	                    +"\t *       *\n"
						                    +"\t***********\n");
						  break;
						
						//if shape is 2 = square  
						case 2:

						  //displays a square
						  System.out.println("Square:");
						  System.out.println("\t**********\n"    
						 		    +"\t*        *\n"
						 		    +"\t*        *\n"
								    +"\t*        *\n"
						 		    +"\t**********\n");	
						  break;

						//if shape is 3 = rectangle
						case 3:

						  //displays a rectangle
						  System.out.println("Rectangle:\n");
						  System.out.println("\t**************\n"           
				 				    +"\t*            *\n"          
				 				    +"\t*            *\n"
				 				    +"\t**************\n");     
						  break;

						//if shape is 4 = trapezoid
						case 4:  

						  //displays a trapezoid 
						  System.out.println("Trapezoid:");
						  System.out.println("\t    *********\n"
								    +"\t   *         *\n"			
								    +"\t  *           *\n"
							      	    +"\t *             *\n"
								    +"\t*****************\n");	
						  break;

						//if shape is 5 = hexagon  
						case 5:  

						  //displays a hexagon
						  System.out.println("Hexagon:");
						  System.out.println("\t   **********\n"
								    +"\t  *          *\n"
								    +"\t *            *\n"
								    +"\t*              *\n"
								    +"\t *            *\n" 	   	
								    +"\t  *          *\n"
								    +"\t   **********\n");
						  break;

					       //if shape is not 1-5   
					       default:
						  //invalid. 
						  System.out.println("\tError: Invalid Choice!");
						  break;	  

					}//endof switch		
	}//end of method
}//end of Class

