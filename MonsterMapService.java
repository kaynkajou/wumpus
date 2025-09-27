package edu.ilstu;

import java.util.Random;

public class MonsterMapService
{
	Random rand = new Random();
	MazeMap mazeMap = new MazeMap();
	private int xLocation, yLocation, oldXLocation, oldYLocation, monsterXLocation, monsterYLocation;

	public MonsterMapService()
	{

	}

	public String getOptions()
	{
		String options = "\nFeel free to move: ";
		if (xLocation != 0)
			options += "\nleft(a)";
		if (yLocation != 0)
			options += "\nup(w)";
		if (xLocation != 4)
			options += "\nright(d)";
		if (yLocation != 4)
			options += "\ndown(s)";
		return options + ".";
	}

	public void setLocation(char movement)
	{
		oldXLocation = xLocation;// saves old x position
		oldYLocation = yLocation;// saves old y position

		if (movement == 'w') // movement for up
			yLocation--;
		else if (movement == 's') // movement for down
			yLocation++;
		else if (movement == 'd') // movement for right
			xLocation++;
		else if (movement == 'a') // movement for left
			xLocation--;
		// to see it is changed-for me uwu
		System.out.println(xLocation + " <- x position   " + yLocation + " <- y position   ");

		// updates map
		mazeMap.set(xLocation, yLocation, 'o');
		mazeMap.set(oldXLocation, oldYLocation, '_');
	}

	public void resetMap()
	{
		for (int y = 0; y < 5; y++)
		{
			for (int x = 0; x < 5; x++)
			{
				mazeMap.set(x, y, 'x');
			}
		}
		mazeMap.set(0, 0, 'o');
	}

	public void addMonster()
	{
		monsterXLocation = rand.nextInt(4);
		monsterYLocation = rand.nextInt(4);
		// adds new location to map

		mazeMap.set(monsterXLocation, monsterYLocation, 'w');

		if (monsterXLocation != 0)
		{
			mazeMap.set(monsterXLocation - 1, monsterYLocation, 's');
		}
		if (monsterXLocation != 4)
		{
			mazeMap.set(monsterXLocation + 1, monsterYLocation, 's');
		}
		if (monsterYLocation != 0)
		{
			mazeMap.set(monsterXLocation, monsterYLocation - 1, 's');
		}
		if (monsterYLocation != 4)
		{
			mazeMap.set(monsterXLocation, monsterYLocation + 1, 's');
		}
	}

	public void showMap()
	{
		for (int space = 0; space < 30; space++)// reseting
		{
			System.out.println();
		}
		for (int y = 0; y < 5; y++)
		{
			for (int x = 0; x < 5; x++)
			{
				System.out.print(mazeMap.get(x, y) + " ");
			}
			System.out.println();
		}
	}
}
