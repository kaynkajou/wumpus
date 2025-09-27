package edu.ilstu;

import java.util.Scanner;

public class Main01
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		char movement;
		boolean go = true;

		char[][] map = new char[5][5];
		int[] location = new int[2];
		location[0] = 0;
		location[1] = 0;
		int[] oldLocation = new int[2];
		oldLocation[0] = 0;
		oldLocation[1] = 0;

		// sets up map
		for (int o = 0; o < 5; o++)
		{
			for (int i = 0; i < 5; i++)
			{
				map[i][o] = 'x';
				System.out.print(map[i][o] + " ");
			}
			System.out.println();
		}

		while (go)
		{

			// change location
			System.out.println("\nFeel free to move up(w), down(s), left(a), or right(d)!");
			movement = input.next().charAt(0);

			oldLocation[0] = location[0];// saves old x position
			oldLocation[1] = location[1];// saves old y position

			if (movement == 'w') // movement for up
				location[1]--;
			else if (movement == 's') // movement for down
				location[1]++;
			else if (movement == 'd') // movement for right
				location[0]++;
			else if (movement == 'a') // movement for left
				location[0]--;

			System.out.println(location[0] + " <- x position   " + location[1] + " <- y position   ");

			map[location[0]][location[1]] = 'o';
			map[oldLocation[0]][oldLocation[1]] = 'x';

			// prints updated map

			for (int o = 0; o < 5; o++)
			{
				for (int i = 0; i < 5; i++)
				{
					System.out.print(map[i][o] + " ");
				}
				System.out.println();
			}
		}

	}

}
