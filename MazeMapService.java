package edu.ilstu;

import java.util.ArrayList;

public class MazeMapService
{
	MazeMap mazeMap;
	MonsterMapService monsterMap = new MonsterMapService();
	private int xLocation, yLocation, oldXLocation, oldYLocation;

	public MazeMapService()
	{
		mazeMap = new MazeMap();
	}

	public MazeMapService(int xLength, int yLength)
	{
		mazeMap = new MazeMap(xLength, yLength);
	}

	public ArrayList<Character> getOptions()
	{
		ArrayList<Character> options = new ArrayList<>();
		
		if (xLocation != 0)
		{
			options.add('a');
		}
		if (yLocation != 0)
		{
			options.add('w');
		}
		if (xLocation != (mazeMap.getXLength() - 1))
		{
			options.add('d');
		}
		if (yLocation != (mazeMap.getYLength() - 1))
		{
			options.add('s');
		}
			
		return options;
	}

	public int getX()
	{
		return xLocation;
	}

	public int getY()
	{
		return yLocation;
	}

	public int getOldX()
	{
		return oldXLocation;
	}

	public int getOldY()
	{
		return oldYLocation;
	}

	public void setLocation(char movement, char roomUnder)
	{
		oldXLocation = xLocation;// saves old x position
		oldYLocation = yLocation;// saves old y position

		switch (movement)
		{
		case 'w':
			yLocation--;// up movement
			break;
		case 's':
			yLocation++;// down movement
			break;
		case 'd':
			xLocation++;// right movement
			break;
		case 'a':
			xLocation--;// left movement
		}

		// updates map
		mazeMap.set(xLocation, yLocation, 'o');

		if (roomUnder == 'x' || roomUnder == 'o')
		{
			mazeMap.set(oldXLocation, oldYLocation, '_');
		} else
		{
			mazeMap.set(oldXLocation, oldYLocation, roomUnder);
		}

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
		// Shows controls: 
		System.out.println("To Move: wasd");
	}
}
