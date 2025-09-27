package edu.ilstu;

import java.util.Scanner;

public class Wumpus
{

	public static void main(String[] args)
	{
		// sets up main variables
		Scanner input = new Scanner(System.in);
		char movement;
		boolean go = true;

		// sets up map
		MazeMapService wumpusWorld = new MazeMapService();
		wumpusWorld.resetMap();
		wumpusWorld.showMap();

		while (go)
		{
			System.out.println(wumpusWorld.getOptions());
			wumpusWorld.setLocation(input.next().charAt(0));
			wumpusWorld.showMap();
		}

	}

}