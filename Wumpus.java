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

		// sets up visible map
		MazeMapService wumpusWorld = new MazeMapService();
		wumpusWorld.resetMap();
		wumpusWorld.showMap();
		// sets up hidden map
		MonsterMapService hiddenWorld = new MonsterMapService();
		hiddenWorld.resetMap();
		hiddenWorld.addMonster();// doesn't add monster correctly when near edge
		System.out.println("Hidden Map: ");
		hiddenWorld.showMap();

		while (go)
		{
			System.out.println(wumpusWorld.getOptions());
			wumpusWorld.setLocation(input.next().charAt(0));
			wumpusWorld.showMap();
		}

	}

}
