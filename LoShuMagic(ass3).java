/*
 *	Magali Gutierrez Z1915336
 *
 *	Assignment 3 Part 1 LoShuMagic Square 
 
	Creating a method test to loop through a 4x4 array. 



*/
public class LoShuMagic {

	public static boolean test(int[][] grid){


	//Checks if array is not 4x4 array returning false
	if(grid.length != 4 || grid[0].length != 4){
		return false; 
	}	

	//known sum 
	int total = 34;

	//loops through each row and column
	for ( int i = 0; i < 4; i++){
		int row = 0;
		int col = 0; 
		//calculates sum of row and column 
		for(int j = 0; j < 4; j++){
			row += grid[i][j]; 
			col += grid[j][i];
		
		}
		//compares if it is equal to 34. 
		if(row != total || col != total){
			return false; //if not == 34
		}	
	}


	//Checking diagnals of the array. 
	int diag_1 = 0;
	int diag_2 = 0;

	//loops through \ diagnol and / diagnal. 
	for(int i = 0; i < 4; i++){
		//gets the sum 
		diag_1 += grid[i][i];
		diag_2 += grid[i][3-1];
	}
	//compares the diagnals sum to total 34. returning false if not equal 
	if( total != diag_1 || total != diag_2){
		return false; 
	}

	//completed
	return true; 

	}//end of method
}//end of class
