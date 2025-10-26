package edu.ilstu;

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

	public String getOptions(char roomAt)
	{
		String options = "\nFeel free to move: ";
		if (roomAt != 'w' && roomAt != 'p')
		{
			if (xLocation != 0)
			{
				options += "\nleft(a)";
			}
			if (yLocation != 0)
			{
				options += "\nup(w)";
			}
			if (xLocation != (mazeMap.getXLength() - 1))
			{
				options += "\nright(d)";
			}
			if (yLocation != (mazeMap.getYLength() - 1))
			{
				options += "\ndown(s)";
			}
			if (roomAt == 's')
			{
				options += "\nyou smell something...";
			}
			if (roomAt == 'b')
			{
				options += "\nyou feel a soft breeze ~~";
			}
		} else if (roomAt == 'w')
		{
			return "YOU BEEN WUMPUSSED!!!";
		} else
		{
			return "You feel into a... a... BOTTOMLESS PIT!!!";
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

		/*
		 * if version of same code ----------------------------------------------------
		 * if (movement == 'w') // movement for up yLocation--; else if (movement ==
		 * 's') // movement for down yLocation++; else if (movement == 'd') // movement
		 * for right xLocation++; else if (movement == 'a') // movement for left
		 * xLocation--;
		 */
		// to see it is changed-for me uwu
		// System.out.println(xLocation + " <- x position " + yLocation + " <- y
		// position ");

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
	}
}
