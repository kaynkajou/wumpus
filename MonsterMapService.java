package edu.ilstu;

import java.util.Random;

public class MonsterMapService
{
	Random rand = new Random();
	private MazeMap mazeMap;
	private int xLocation, yLocation, oldXLocation, oldYLocation, monsterXLocation, monsterYLocation;

	public MonsterMapService()
	{
		mazeMap = new MazeMap();
	}

	public MonsterMapService(int xLength, int yLength)
	{
		mazeMap = new MazeMap(xLength, yLength);
	}

	public char getRoom(int x, int y)
	{
		return mazeMap.get(x, y);
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
		for (int y = 0; y < mazeMap.getYLength(); y++)
		{
			for (int x = 0; x < mazeMap.getXLength(); x++)
			{
				mazeMap.set(x, y, 'x');
			}
		}
		mazeMap.set(0, 0, 'o');
	}

	public void addMonster()
	{
		monsterXLocation = rand.nextInt(mazeMap.getXLength() - 3) + 2;
		monsterYLocation = rand.nextInt(mazeMap.getYLength() - 3) + 2;
		// adds new location to map

		mazeMap.set(monsterXLocation, monsterYLocation, 'w');

		if (monsterXLocation != 0)
		{
			mazeMap.set(monsterXLocation - 1, monsterYLocation, 's');
		}
		if (monsterXLocation != (mazeMap.getXLength() - 1))
		{
			mazeMap.set(monsterXLocation + 1, monsterYLocation, 's');
		}
		if (monsterYLocation != 0)
		{
			mazeMap.set(monsterXLocation, monsterYLocation - 1, 's');
		}
		if (monsterYLocation != (mazeMap.getYLength() - 1))
		{
			mazeMap.set(monsterXLocation, monsterYLocation + 1, 's');
		}
	}

	public void addMonster(char obstical, char warning)
	{
		monsterXLocation = rand.nextInt(mazeMap.getXLength() - 3) + 2;
		monsterYLocation = rand.nextInt(mazeMap.getYLength() - 3) + 2;
		// adds new location to map

		mazeMap.set(monsterXLocation, monsterYLocation, obstical);

		if (monsterXLocation != 0)
		{
			mazeMap.set(monsterXLocation - 1, monsterYLocation, warning);
		}
		if (monsterXLocation != (mazeMap.getXLength() - 1))
		{
			mazeMap.set(monsterXLocation + 1, monsterYLocation, warning);
		}
		if (monsterYLocation != 0)
		{
			mazeMap.set(monsterXLocation, monsterYLocation - 1, warning);
		}
		if (monsterYLocation != (mazeMap.getYLength() - 1))
		{
			mazeMap.set(monsterXLocation, monsterYLocation + 1, warning);
		}
	}

	public void addMultiple(int amount)
	{
		for (int i = 0; i < amount; i++)
		{
			addMonster();
		}
	}

	public void addMultiple(int amount, char obstical, char warning)
	{
		for (int i = 0; i < amount; i++)
		{
			addMonster(obstical, warning);
		}
	}

	public void showMap()
	{
		for (int space = 0; space < 30; space++)// reseting
		{
			System.out.println();
		}
		for (int y = 0; y < mazeMap.getYLength(); y++)
		{
			for (int x = 0; x < mazeMap.getXLength(); x++)
			{
				System.out.print(mazeMap.get(x, y) + " ");
			}
			System.out.println();
		}
	}
}
