//-------------------------------
// Assignment 1
// Question 1
// Written by: Alex Lee Tong Fong Student id 40220887
//-------------------------------

/** Alex Lee Tong Fong ID 40220887
 * COMP249
 * Assignment #1
 * Due Date Feb.6 2023
 */



import java.util.Scanner;
import java.util.Arrays;

// Class with object and board initialization
/**
 * 
 * @author Alex
 *
 */
public class LadderAndSnake {
	int dice1;
	int dice2;
	
	int player1pos = 0;
	int player2pos = 0;
/**
* This constructs a player position with a specified initial position value
* @param player1pos the position of player 1
* @param player2pos the position of player 2
*/
	

	Scanner in = new Scanner(System.in);

	
// Constructor
public LadderAndSnake() {
	
}

// Creates a dice that randomly returns a value between 1-6 inclusively
/**
 * This returns a random number from 1-6
 * @return a dice number
 */
public int flipDice() {
	double RandomNumber = Math.random() *6+1;
	int randomnumber = (int) RandomNumber;
	return randomnumber;
}

// Initiates core engine of the game
/**
 * This starts the game core
 * @param play
 */
public void play() {
	
Scanner in = new Scanner (System.in);
int tie =0;

// Setting initial board

int LadderAndSnake [] [] = new int [10] [10];
int count = 1;

//Initialize our 2D array with numbers 1-100 and reverse even rows
	for (int i = 9; i >=0; i--) {
		if (i%2 ==0) {
			for (int j = 9; j>=0; j--) {
				LadderAndSnake[i][j] = count;
				count++;
			}
		}
		else {
			for (int j=0; j<10; j++) {
				LadderAndSnake[i][j] = count;
				count++;
			}
		}
	}
	
// Setting Ladders and Snakes
int player1 [] [] = new int [10] [10];	
player1 = LadderAndSnake;	
//Ladders	

	player1 [9] [0] = player1 [6][2];
	player1 [9] [3] = player1 [8][6];
	player1 [9] [8] = player1 [6][9];
	player1 [7] [0] = player1 [5][1];
	player1 [7] [7] = player1 [1][3];
	player1 [6] [4] = player1 [5][3];
	player1 [4] [9] = player1 [3][6];
	player1 [2] [0] = player1 [0][0];
	player1 [2] [9] = player1 [0][9];
	
//Snakes
	player1 [8] [4] = player1 [9][5];
	player1 [3] [1] = player1 [8][1];
	player1 [0] [5] = player1 [7][3];
	player1 [5] [7] = player1 [7][9];
	player1 [3] [3] = player1 [4][0];
	player1 [0] [7] = player1 [3][7];
	player1 [0] [3] = player1 [2][4];
	player1 [0] [2] = player1 [2][2];
	
int player2 [] [] = new int [10] [10];	
player2 = player1;
	

// referring to flipDice() method to determine dice number of player 1 
	
while (true) {	
	
	System.out.println("Player 1, please press \"enter\" to roll the dice");
	in.nextLine();
	dice1 = flipDice();
	System.out.println("Player 1's number is "+dice1+"\n");
		
	
// referring to flipDice() method to determine dice number of player 2
	
	System.out.println("Player 2, please press \"enter\" to roll the dice");
	in.nextLine();
	dice2 = flipDice();
	System.out.println("Player 2's number is "+dice2+"\n");
	

//if statement to compare dice of player 1 and 2 to determine order
	if (dice1 > dice2 ) {
	System.out.println("Player 1 has a higher number, they start first!\n");
	break;
	}

	else if (dice1 < dice2) {
	System.out.println("Player 2 has a higher number, they start first!\n");
	break;
	}

	else {
		tie++;
	System.out.println("It's a tie, try again! Ties so far: " +tie);
		 } 
   }// while true end

// Initiate play
	
		while (dice1 > dice2 && player1pos < 100 && player2pos < 100) {
			System.out.println("Player 1's turn: \nPlease press \"enter\" to roll the dice!\n");
			in.nextLine();
			int diceroll1 =flipDice(); 
			player1pos += diceroll1;
			int row = 9-((player1pos-1)/10);
			int col = (player1pos-1)%10;
			System.out.println("Player 1 has rolled a "+diceroll1+" and is now at position "+player1[row][col]+"\n");
			player1pos = player1[row][col];
			
			System.out.println("Player 2's turn: \nPlease press \\\"enter\\\" to roll the dice!\n");
			in.nextLine();
			int diceroll2 = flipDice();
			player2pos += diceroll2;
			int row2 = 9-((player2pos-1)/10);
			int col2 = (player2pos-1)%10;
			System.out.println("Player 2 has rolled a "+diceroll2+" and is now at position "+player2[row2][col2]+"\n");
			player2pos = player2[row2][col2];
			System.out.println("Game not over yet, continue!\n");
		   }
	
		while (dice2 > dice1 && player1pos < 100 && player2pos < 100) {
			System.out.println("Player 2's turn: \nPlease press \\\"enter\\\" to roll the dice!\n");
			in.nextLine();
			int diceroll2 = flipDice();
			player2pos += diceroll2;
			int row2 = 9-((player2pos-1)/10);
			int col2 = (player2pos-1)%10;
			System.out.println("Player 2 has rolled a "+diceroll2+" and is now at position "+player2[row2][col2]+"\n");
			player2pos = player2[row2][col2];
			
				
			System.out.println("Player 1's turn: \nPlease press \"enter\" to roll the dice!\n");
			in.nextLine();
			int diceroll1 = flipDice();
			player1pos += diceroll1;
			int row = 9-((player1pos-1)/10);
			int col = (player1pos-1)%10;
			System.out.println("Player 1 has rolled a "+diceroll1+" and is now at position "+player1[row][col]+"\n");
			player1pos = player1[row][col];
			System.out.println("Game not over yet, continue!\n");
			}
			
// when a player reaches 100 or over
		if (player1pos == 100 || player2pos ==100) {
			System.out.println("Congratulations, you have won!");
		}
		else if (player1pos > 100 ) {
			int extra = player1pos - 100;
			player1pos = 100 - extra;
		}
		
		else if (player2pos > 100) {
			int extra2 = player2pos - 100;
			player2pos = 100 - extra2;
		}
		
		else if (player1pos == player2pos) {
			player1pos =0;
		}
		else if (player2pos == player1pos) {
			player2pos = 0;
		}

}//end of play method

public int getPlayer1pos() {
	return player1pos;
}

public void setPlayer1pos(int player1pos) {
	this.player1pos = player1pos;
}

public int getPlayer2pos() {
	return player2pos;
}

public void setPlayer2pos(int player2pos) {
	this.player2pos = player2pos;
}


}




