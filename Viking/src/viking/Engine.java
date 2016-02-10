package viking;

import java.util.Scanner;

public class Engine 
{
	static int players = 0;
	static String areYouSure = "x";
	static boolean done = false;
	static boolean enteredAmountOfPlayers = false;

	void act()
	{
		boolean sure = false;

		Scanner sc = new Scanner(System.in);
		Player p = new Player();

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
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					p.p1T = true;
					if(p.p1T == true)
					{
                    System.out.println("It's " + player1 + "'s turn.");
                    System.out.println("\n");
                    System.out.println("You have " + p.coins1 + " coins.");
                    System.out.println(player2 + " has " + p.coins2 + " coins.");
                    System.out.println("Please choose to either: [H]arvest, [R]aid, or [G]uard");
                    p.turn = sc.next();
                    if(p.turn.equalsIgnoreCase("h"))
                    {
                    p.p1H = true;
                    p.p1T = false;
                    p.p2T = true;
                    } else if(p.turn.equalsIgnoreCase("r"))
                    {
                        System.out.println("Who would you like to raid?");
                        System.out.println("- " + player2);
                        if(p.turn.equalsIgnoreCase(player2))
                        {
                         p.p1Raiding = player2;
                         p.p1R = true;
                         p.p1T = false;
                         p.p2T = true;
                        } else if(p.turn.equalsIgnoreCase(player1))
                        {
                         System.out.println("You cannot raid yourself!");
                        }
                    } else if(p.turn.equalsIgnoreCase("g"))
                    {
                        p.p1G = true;
                        p.p1T = false;
                        p.p2T = true;
                    }
					}
					if(p.p2T == true)
					{
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("It's " + player2 + "'s turn.");
                    System.out.println("\n");
                    System.out.println("You have " + p.coins2 + " coins.");
                    System.out.println(player1 + " has " + p.coins1 + " coins.");
                    System.out.println("Please choose to either: [H]arvest, [R]aid, or [G]uard");
                    p.turn = sc.next();
                    if(p.turn.equalsIgnoreCase("h"))
                    {
                    p.p2H = true;
                    p.p2T = false;
                    } else if(p.turn.equalsIgnoreCase("r"))
                    {
                        System.out.println("Who would you like to raid?");
                        System.out.println("- " + player1);
                        p.p1Raiding = sc.next();
                        if(p.p1Raiding.equalsIgnoreCase(player1))
                        {
                         p.p2Raiding = player1;
                         p.p2R = true;
                         p.p2T = false;
                        }
                    } else if(p.turn.equalsIgnoreCase("g"))
                    {
                        p.p2G = true;
                        p.p2T = false;
                    }
					}
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Results:");
                    System.out.println("\n");
                    if(p.p1H == true && p.p2Raiding != player1)
                    {
                        p.coins1 = p.coins1 + 4;
                        System.out.println(player1 + " harvested and gained 4 coins!");
                        p.p1H = false;
                    } else if(p.p1G == true && p.p2Raiding == player1)
                    {
                     System.out.println(player1 + " has guarded while " + player2 + " tried to raid!");
                     System.out.println(player1 + " lost 1 coin and " + player2 + " lost 5!");
                     p.p1G = false;
                     p.p2Raiding = "x";
                    } else if(p.p1G == true && p.p2Raiding != player1)
                    {
                     System.out.println(player1 + " guarded but no one attacked!");
                     System.out.println(player1 + " lost 1 coin.");
                     p.coins1 = p.coins1 - 1;
                     p.p1G = false;
                    } else if(p.p1H == true && p.p2Raiding == player1 && p.p2R == true)
                    {
                        System.out.println(player1 + " went harvesting but got raided by " + player2 + "!");
                        System.out.println("Nothing happens.");
                        p.p2Raiding = "x";
                        p.p1H = false;
                        p.p2R = false;
                    } else if(p.p1R == true && p.p1Raiding == player2 && p.p2G == false && p.p2H == false)
                    {
                        System.out.println(player1 + " raided " + player2 + "while wasn't guarding!");
                        System.out.println(player1 + " gained 3 coins.");
                        p.coins1 = p.coins1 + 3;
                        System.out.println(player2 + " lost 3 coins.");
                        p.coins2 = p.coins2 - 3;
                        p.p1R = false;
                        p.p1Raiding = "x";
                    } else if(p.p1R == true && p.p1Raiding == player2 && p.p2G == true && p.p2H == false)
                    {
                        System.out.println(player1 + " raided while " + player2 + " was guarding!");
                        System.out.println(player1 + " lost 5 coins.");
                        p.coins1 = p.coins1 - 5;
                        System.out.println(player1 + " lost 1 coin.");
                        p.coins1 = p.coins1 - 1;
                        p.p1R = false;
                        p.p2G = false;
                        p.p1Raiding = "x";
                    } else if(p.p1R == true && p.p1Raiding == player2 && p.p2G == false && p.p2H == true)
                    {
                        System.out.println(player2 + " went harvesting but got raided by " + player1 + "!");
                        System.out.println("Nothing happens.");
                        p.p1Raiding = "x";
                        p.p2H = false;
                        p.p1R = false;
                    }

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


