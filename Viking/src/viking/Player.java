package viking;

import java.util.Scanner;
import static viking.Engine.*;

public class Player 
{
//	public static void main(String[] args) 
	void act()
	{
		int coins = 10;
		
		Scanner sc = new Scanner(System.in);
		while (players >= 2 || players <= 4)
		{
			Engine.enteredAmountOfPlayers = true;

			if (Engine.enteredAmountOfPlayers == true && !Engine.sure) 
			{
				System.out.println("Are you sure you want " + players + " servants, my lord? (Y or N)");
				Engine.areYouSure = sc.next();

				if(Engine.areYouSure.equalsIgnoreCase("n"))
				{
					Engine.sure = false;
					Engine.enteredAmountOfPlayers = false;
				}
				else if(Engine.areYouSure.equalsIgnoreCase("y"))
				{
					Engine.sure = true;
					Engine.enteredAmountOfPlayers = true;
					System.out.println("You have chosen " + players + " servants, my lord.");
					Engine.done = true;
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
				if(Engine.enteredAmountOfPlayers == false)
				{

					if(Engine.areYouSure.equalsIgnoreCase("n"))
					{
						System.out.println("Choose players (2-4)");
						players = sc.nextInt();
					}
					if(players < 2 || players > 4)
					{
						Engine.enteredAmountOfPlayers = false;
						System.out.println("That is an invalid amount of servants, my lord!");
						System.out.println("Choose players (2-4)");
						players = sc.nextInt();
					}
				}
			}
		}
	}				
}

