package viking;

import java.util.Scanner;

public class Engine 
{
	public static int players = 0;
	public static boolean done = false;
        public static boolean enteredAmountOfPlayers = false;
	public static boolean sure = false;
        public static String areYouSure = "x";

	//	public static void main(String[] args) 
	//	{
	void act()
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome, my lord. Choose how many servants you desire.");
		System.out.println("Choose players (2-4)");
		players = sc.nextInt();

		while (players < 2 || players > 4) 
		{
			System.out.println("That is an invalid amount of servants, my lord!");
			System.out.println("Choose players (2-4)");
			players = sc.nextInt();
		}

		while (players >= 2 || players <= 4)
		{
			enteredAmountOfPlayers = true;

			if (enteredAmountOfPlayers == true && !sure) 
			{
				System.out.println("Are you sure you want " + players + " servants, my lord? (Y or N)");
				areYouSure = sc.next();

				if(areYouSure.equalsIgnoreCase("n"))
				{
					sure = false;
					enteredAmountOfPlayers = false;
				}
				else if(areYouSure.equalsIgnoreCase("y"))
				{
					sure = true;
					enteredAmountOfPlayers = true;
					System.out.println("You have chosen " + players + " servants, my lord.");
					done = true;
				}
				
				if(Engine.players == 2 && Engine.done == true)
				{
					String player1 = "Player 1";
					String player2 = "Player 2";

					System.out.println("Choose the name of " + player1);
					player1 = sc.next();
					System.out.println("Player 1 is now called: " + player1);
					System.out.println("\n");

					System.out.println("Choose the name of " + player2);
					player2 = sc.next();
					System.out.println("Player 2 is now called: " + player2);
					System.out.println("\n");

				}
				else if(Engine.players == 3 && Engine.done == true)
				{
					String player1 = "Player 1";
					String player2 = "Player 2";
					String player3 = "Player 3";

					System.out.println("Choose the name of " + player1);
					player1 = sc.next();
					System.out.println("Player 1 is now called: " + player1);
					System.out.println("\n");

					System.out.println("Choose the name of " + player2);
					player2 = sc.next();
					System.out.println("Player 2 is now called: " + player2);
					System.out.println("\n");

					System.out.println("Choose the name of " + player3);
					player3 = sc.next();
					System.out.println("Player 3 is now called: " + player3);
					System.out.println("\n");
				}
				else if(Engine.players == 4 && Engine.done == true)
				{
					String player1 = "Player 1";
					String player2 = "Player 2";
					String player3 = "Player 3";
					String player4 = "Player 4";

					System.out.println("Choose the name of " + player1);
					player1 = sc.next();
					System.out.println("Player 1 is now called: " + player1);
					System.out.println("\n");

					System.out.println("Choose the name of " + player2);
					player2 = sc.next();
					System.out.println("Player 2 is now called: " + player2);
					System.out.println("\n");

					System.out.println("Choose the name of " + player3);
					player3 = sc.next();
					System.out.println("Player 3 is now called: " + player3);
					System.out.println("\n");

					System.out.println("Choose the name of " + player4);
					player4 = sc.next();
					System.out.println("Player 4 is now called: " + player4);
					System.out.println("\n");
				}
				if(enteredAmountOfPlayers == false)
				{

					if(areYouSure.equalsIgnoreCase("n"))
					{
						System.out.println("Choose players (2-4)");
						players = sc.nextInt();
					}
					if(players < 2 || players > 4)
					{
						enteredAmountOfPlayers = false;
						System.out.println("That is an invalid amount of servants, my lord!");
						System.out.println("Choose players (2-4)");
						players = sc.nextInt();
					}
				}
			}
		}
	}
}
