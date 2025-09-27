package edu.ilstu;

import java.util.Random;

public class Enemy
{
	Random rand = new Random();
	private int[] location = new int[2];
	private int[] oldLocation = new int[2];

	private int number;

	public Enemy()
	{

	}

	public void setLocation()
	{
		oldLocation[0] = location[0];// saves old x position
		oldLocation[1] = location[1];// saves old y position

		number = rand.nextInt(4 - 0 + 1) + 0;// (high - low + 1) + low
	}
}
