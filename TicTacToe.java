import java.util.Scanner;
public class TicTacToe {

	public static void main(String[] args) {
		// creating the grid for this tic-tac-toe
	    char[][] grid = new char[3][3];
	    // there are three states:
	    // 'X' -> it is occupied by X
	    // 'O' -> it is occupied by O
	    // '.' -> it is an empty box

	    // filled up our grid with empty blocks
	    for (int i = 0; i < 3; i++){
	    	for (int j = 0; j < 3; j++){
	    		grid[i][j] = '.';
	    	}
	    }

	    boolean playing = true; // this is true as long as the game is still going

	    while (playing){
	    	// outputing the grid here
	    	for (int i = 0; i < 3; i++){
	    		for (int j = 0; j < 3; j++){
	    			System.out.print(grid[i][j]);
	    		}
	    		System.out.println();
	    	}
	    	playing = false;
	    	
	    	// ask the user where to place their next move (alternating)
	    	
	    	
	    	// check whether the place is valid
	    	
	    	
	    	// update the grid with the new move 
	    	
	    	
	    	// check if there is a win, or tie (set playing to false)
	    }
	  
	  
	}
    
}