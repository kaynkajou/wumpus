package edu.ilstu;

public class MazeMapService
{
	MazeMap mazeMap = new MazeMap();
	private int xLocation, yLocation, oldXLocation, oldYLocation;

	public MazeMapService()
	{

	}

	public String getOptions(char roomAt)
	{
		String options = "\nFeel free to move: ";
		if (roomAt != 'w')
		{
			if (xLocation != 0)
			{
				options += "\nleft(a)";
			}
			if (yLocation != 0)
			{
				options += "\nup(w)";
			}
			if (xLocation != 4)
			{
				options += "\nright(d)";
			}
			if (yLocation != 4)
			{
				options += "\ndown(s)";
			}
			if (roomAt == 's')
			{
				options += "\nyou smell something...";
			}
		} else
		{
			return "YOU BEEN WUMPUSSED!!!";
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
		if (roomUnder == 's')
		{
			mazeMap.set(oldXLocation, oldYLocation, 's');
		} else if (roomUnder == 'w')
		{
			mazeMap.set(oldXLocation, oldYLocation, 'w');
		} else
		{
			mazeMap.set(oldXLocation, oldYLocation, '_');
		}

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
