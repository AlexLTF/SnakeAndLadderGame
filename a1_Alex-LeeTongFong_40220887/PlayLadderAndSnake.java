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
public class PlayLadderAndSnake {
/**
 * 
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub		

//Sets the amount of players		
		Scanner in = new Scanner(System.in);
		System.out.println("Please set the amount of players: ");
		int players = in.nextInt();
		
		if (players > 2) {
			System.out.println("Warning, the amount of players must be 2.");
			players = 2;
			}
		else if (players < 2) {
			System.out.println("Program has been terminated, exiting...");
			System.exit(0);
		}
		
//Initialize play of game	
	
		LadderAndSnake start = new LadderAndSnake();
		start.play();
	
		
		
		
	}

}
