package edu.ilstu;

public class MazeMap
{
	private char[][] map;

	public MazeMap()
	{
		this(5, 5);
	}

	public MazeMap(int number1, int number2)
	{
		map = new char[number1][number2];
	}

	public char get(int x, int y)
	{
		return map[x][y];
	}

	public void set(int x, int y, char type)
	{
		map[x][y] = type;
	}

}