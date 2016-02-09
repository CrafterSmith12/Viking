package viking;

public class Main 
{
	public static void main(String[] args) 
	{
		Engine  eng =new Engine();
		Player p = new Player();
		eng.act();
		if(eng.done)
		{
		p.act();
		}
	}
}
