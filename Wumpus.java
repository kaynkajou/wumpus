package edu.ilstu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Wumpus
{ 

	public static void main(String[] args)
	{
		// sets up main variables
		Random rand = new Random();
		boolean go = true;
		int x, y;

		// gets a random x value and y value
		x = rand.nextInt(10) + 5;
		y = rand.nextInt(10) + 5;
		// sets up visible map
		MazeMapService wumpusWorld = new MazeMapService(x, y);
		wumpusWorld.resetMap();
		wumpusWorld.showMap();
		// sets up hidden map
		MonsterMapService hiddenWorld = new MonsterMapService(x, y);
		hiddenWorld.resetMap();
		
		// adds several bottomless pits and Wumpus' based on the size of the world
		if (x + y < 20)
		{
			hiddenWorld.addMultiple(3);
			hiddenWorld.addMultiple(2, 'p', 'b');
		} else
		{
			hiddenWorld.addMultiple(6);
			hiddenWorld.addMultiple(4, 'p', 'b');
		}
		
		//System.out.println("Hidden Map: ");
		//hiddenWorld.showMap(); // for testing

		while (go)
		{
			// moves player and updates display
			updateDisplay(wumpusWorld, hiddenWorld);
			
			// checks end game conditions
			if (hiddenWorld.getRoom(wumpusWorld.getX(), wumpusWorld.getY()) == 'w') {
				System.out.println("YOU BEEN WUMPUSSED!!!");
				go = false;
			}
			else if (hiddenWorld.getRoom(wumpusWorld.getX(), wumpusWorld.getY()) == 'p')
			{
				System.out.println("You feel into a BOTTOMLESS PIT!!!");
				go = false;
			}
		}
		
		

	}
	
	public static void updateDisplay(MazeMapService visible, MonsterMapService hidden) {
		Scanner input = new Scanner(System.in);
		ArrayList<Character> options;
		boolean isValid = false;
		char userMovement = ' ';
		char location;
		
		// moves player and updates display
		
		// gets a valid movement based on options available
		options = visible.getOptions();
		while (!isValid) {
			userMovement = input.next().charAt(0);
			if (options.indexOf(userMovement) == -1) {
				System.out.print("The walls are preventing you from moving that way.\nPick a new direction: ");
			}
			else {
				isValid = true;
			}
		}
		
		visible.setLocation(userMovement, hidden.getRoom(visible.getX(), visible.getY()));// sets location
		visible.showMap();
		
		// gives warning based on where player is at
		location = hidden.getRoom(visible.getX(), visible.getY());
		System.out.print("Currently there is: ");
		if (location == 's') {
			System.out.println("a strange smell...");
		}
		else if (location == 'b') {
			System.out.println("a soft breeze ~~");
		}
		else if (location == 'w') {
			System.out.println("oh no.");
		}
		else if (location == 'p') {
			System.out.println("nothing... absolutely nothing beneath you");
		}
		else {
			System.out.println("nothing to worry about!");
		}
	}

}
