package edu.ilstu;

import java.util.Random;
import java.util.Scanner;

public class Wumpus
{

	public static void main(String[] args)
	{
		// sets up main variables
		Scanner input = new Scanner(System.in);
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
		if (x + y < 20)
		{
			hiddenWorld.addMultiple(3);
			hiddenWorld.addMultiple(2, 'p', 'b');
		} else
		{
			hiddenWorld.addMultiple(6);
			hiddenWorld.addMultiple(4, 'p', 'b');
		}
		System.out.println(wumpusWorld.getOptions(hiddenWorld.getRoom(wumpusWorld.getX(), wumpusWorld.getY())));
		// System.out.println("Hidden Map: ");
		hiddenWorld.showMap(); // for testing

		while (go)
		{
			wumpusWorld.setLocation(input.next().charAt(0),
					hiddenWorld.getRoom(wumpusWorld.getX(), wumpusWorld.getY()));// sets location
			wumpusWorld.showMap();
			System.out.println(wumpusWorld.getOptions(hiddenWorld.getRoom(wumpusWorld.getX(), wumpusWorld.getY())));// gives
			// options
			if (hiddenWorld.getRoom(wumpusWorld.getX(), wumpusWorld.getY()) == 'w'
					|| hiddenWorld.getRoom(wumpusWorld.getX(), wumpusWorld.getY()) == 'p')
			{
				go = false;
			}
		}

	}

}
