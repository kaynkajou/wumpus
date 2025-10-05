package edu.ilstu;

import java.util.Scanner;

public class Wumpus
{

	public static void main(String[] args)
	{
		// sets up main variables
		Scanner input = new Scanner(System.in);
		boolean go = true;

		// sets up visible map
		MazeMapService wumpusWorld = new MazeMapService();
		wumpusWorld.resetMap();
		wumpusWorld.showMap();
		// sets up hidden map
		MonsterMapService hiddenWorld = new MonsterMapService();
		hiddenWorld.resetMap();
		hiddenWorld.addMonster();
		System.out.println(wumpusWorld.getOptions(hiddenWorld.getRoom(wumpusWorld.getX(), wumpusWorld.getY())));
		// System.out.println("Hidden Map: ");
		// hiddenWorld.showMap(); for testing

		while (go)
		{
			wumpusWorld.setLocation(input.next().charAt(0),
					hiddenWorld.getRoom(wumpusWorld.getX(), wumpusWorld.getY()));// sets location
			wumpusWorld.showMap();
			System.out.println(wumpusWorld.getOptions(hiddenWorld.getRoom(wumpusWorld.getX(), wumpusWorld.getY())));// gives
			// options
			if (hiddenWorld.getRoom(wumpusWorld.getX(), wumpusWorld.getY()) == 'w')
			{
				go = false;
			}
		}

	}

}
