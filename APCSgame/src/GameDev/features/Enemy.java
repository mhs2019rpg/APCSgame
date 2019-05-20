package GameDev.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Enemy extends Character
{
	// event after enemy
	// some options 
	// checks strength or intelligence
	// if true option occurs and you gain/lose something add health or damage higher/lower
	//otherwise text saying nothing happens
	// when you hit 1 and enter to continue
	//enemy repeat
	private int health;
	private int damage;
	private int level;
	
	private String name;
	private String[] names = {"slime", "three slimes", "swarm of bats", "giant bat", "bandit", "bear"}; 
	
	private Random r = new Random(); //Just treat this like a Math.random()
	
	public Enemy(String name, int level)
	{
		this.name = name;
		this.level = level;
		if(name.equalsIgnoreCase("slime"))
		{
			health = 100 + 3* level + r.nextInt(21)*level;
			damage = 10 + r.nextInt(11)*level;
		}
		else if(name.equalsIgnoreCase("three slimes"))
		{
			health = 150 + r.nextInt(21)*level;
			damage = 12 + r.nextInt(11)*level;
		}
		else if(name.equalsIgnoreCase("swarm of bats"))
		{
			health = 80 + r.nextInt(21)*level;
			damage = 11 + r.nextInt(11)*level;
		}
		else if(name.equalsIgnoreCase("giant bat"))
		{
			health = 200 + r.nextInt(21)*level;
			damage = 10 + r.nextInt(11)*level;
		}
		else if(name.equalsIgnoreCase("bandit"))
		{
			health = 200 + r.nextInt(21)*level;
			damage = 10 + r.nextInt(11)*level;
		}
		else if(name.equalsIgnoreCase("bear"))
		{
			health = 250 + r.nextInt(21)*level;
			damage = 25 + r.nextInt(11)*level;
		}
	}
	
	public int getHealth()
	{
		return health;
	}
	public void setHealth(int damage)
	{
		health -= damage;
	}
	public int getDamage()
	{
		return damage;
	}
	public void setDamage(int dmg)
	{
		damage = dmg;
	}
	public String getName()
	{
		return name;
	}
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int level)
	{
		this.level = level;
	}
	public String getEnemy()
	{
		return names[r.nextInt(6)];
	}

	@Override
	public String getSpell() {
		return null;
	}

	@Override
	public int getSkillDMG() {
		return 0;
	}
	//take in a username to be used in dialog, turn true if battle is triggered
	public boolean triggerBattle(Character user, Scanner userInput)
	{
		if(name.equalsIgnoreCase("slime"))
		{
			return slimeEvent(user, userInput);
		}
		else if(name.equalsIgnoreCase("three slimes"))
		{
			return slime3Event(user, userInput);
		}
		else if(name.equalsIgnoreCase("swarm of bats"))
		{
			return batsEvent(user, userInput);
		}
		else if(name.equalsIgnoreCase("giant bat"))
		{
			return batEvent(user, userInput);
		}
		else if(name.equalsIgnoreCase("bandit"))
		{
			return banditEvent(user, userInput);
		}
		else if(name.equalsIgnoreCase("bear"))
		{
			return bearEvent(user, userInput);
		}
		else
		{
			return true;
		}
		
	}

	private boolean slimeEvent(Character user, Scanner userInput) 
	{
		System.out.println("Slime: \"You are disgusting\"\n");
		String choice;
		do
		{
			System.out.println("1. \"I AM KILLING YOU\"");
			System.out.println("2. \"Whats that? you little cutie slime\"");
			choice = userInput.nextLine();
			if (choice.equals("2"))
			{
				System.out.println("Slime: \"Now you piss me off\"");
				setHealth(r.nextInt(5)*level);
				setDamage(damage*(1 + r.nextInt(4)));
				System.out.println("(Enemy Slime cut down its HP and increased its damage)\n");
			}
			return true;
		}
		while(!(choice.equals("1")||choice.equals("2")));
	}
	
	private boolean slime3Event(Character user, Scanner userInput) 
	{
		System.out.println("Slimes: \"Hey hey hey look Who's here. Aren't you the " + user.getName() +" that killed our brother?\"\n");
		String choice;
		do
		{
			System.out.println("1. \"Yes. And you guys will meet him in the heaven\"");
			System.out.println("2. \"No. My name is Van. I am from Japan. I am 21 years old\"");
			System.out.println("3. (Sprinting away...)");
			choice = userInput.nextLine();
			if (choice.equals("3"))
			{
				System.out.println("Slimes: \"He has fast legs\"\n");
				return false;
			}
			else
			{
				System.out.println("Slimes: \"Lets beat him up\"\n");
				return true;
			}
		}
		while(!(choice.equals("1")||choice.equals("2")||choice.equals("3")));
	}
	
	private boolean batsEvent(Character user, Scanner userInput) 
	{
		System.out.println("Bats: \"You looks delicious. Can we take a bite of you?\"\n");
		String choice;
		do
		{
			System.out.println("1. \"No. You should KYS\"");
			System.out.println("2. \"Yes I will love to!\"");
			System.out.println("3. \"I think you guys look delicious\"");
			choice = userInput.nextLine();
			if (choice.equals("1"))
			{
				System.out.println("Bats: \"Nani the f***?!\"\n");
				return true;
			}
			else if (choice.equals("2"))
			{
				System.out.println("Bats: \"You are so kind!\"");
				setHealth(-(r.nextInt(100)));
				setDamage(damage-(level + r.nextInt(4)));
				System.out.println("(Enemies Bats have increased it HP but lost some damage)\n");
				return true;
			}
			else
			{
				System.out.println("Bats: \"He's so mean.\"");
				System.out.println("(Enemies Bats flied away)");
				return false;
			}
		}
		while(!(choice.equals("1")||choice.equals("2")||choice.equals("3")));
	}
	
	private boolean batEvent(Character user, Scanner userInput) 
	{
		System.out.println("Bat: \"I am the king of this reign. You come here and let me take a bite of you\"\n");
		String choice;
		do
		{
			System.out.println("1. \"I want to take a bit of you\"");
			System.out.println("2. \"Yes sir\"");
			System.out.println("3. (You found yourself stepping on poop poop)");
			choice = userInput.nextLine();
			if (choice.equals("1"))
			{
				System.out.println("Bat: \"That's mean\"\n");
				return true;
			}
			else if (choice.equals("2"))
			{
				System.out.println("Bats: \"That's Right!\"");
				user.setHealth(user.getHealth()/2);
				user.setDamage(user.getDamage()*2);
				System.out.println("(You have lost HP and gain damage significantly)\n");
				return true;
			}
			else
			{
				System.out.println("Bat: \"OMG is that poopoo\"");
				System.out.println("(Enemies Bat flied away)\n");
				return false;
			}
		}
		while(!(choice.equals("1")||choice.equals("2")||choice.equals("3")));
	}
	
	private boolean banditEvent(Character user, Scanner userInput) 
	{
		System.out.println("Bandit: \"Yo man. Give me your underwear or I kill you\"\n");
		String choice;
		do
		{
			System.out.println("1. \"No way man I lost my pants already\"");
			System.out.println("2. \"Why would you want my underwear?\"");
			System.out.println("3. (You give your underwear to the bandit)");
			choice = userInput.nextLine();
			if (choice.equals("1"))
			{
				System.out.println("Bandit: \"So you to die right\"\n");
				return true;
			}
			else if (choice.equals("2"))
			{
				System.out.println("Bandit: \"You talk too much. I am tried of talking\"");
				System.out.println("(Bandit walk home with his exhausted shadow...)\n");
				return false;
			}
			else
			{
				System.out.println("(Fortunely you got another underwear)");
				System.out.println("Bandit: \"Thank you!\"");
				System.out.println("(Enemies Bandit walk away with a sated look)\n");
				return false;
			}
		}
		while(!(choice.equals("1")||choice.equals("2")||choice.equals("3")));
	}
	
	private boolean bearEvent(Character user, Scanner userInput) 
	{
		System.out.println("Bear: \"Beaaaaaaaaaaaaaarrrrrrrrrr\"\n");
		String choice;
		do
		{
			System.out.println("1. \"I suppose you want to fight\"");
			System.out.println("2. \"What are you saying?\"");
			System.out.println("3. \"In the Avengers 4.....\"");
			choice = userInput.nextLine();
			if (choice.equals("1"))
			{
				System.out.println("Bear: \"Pika Pika PIKAAAAAA\"\n");
				return true;
			}
			else if (choice.equals("2"))
			{
				System.out.println("Bear: \"bear?be bear bearrrr a bearber~\"");
				System.out.println("Bear's friend Tarzan: \"She said she want to you guess a number\""); 
				int answer = r.nextInt(101);
				int guess;
				do
				{
					 guess = userInput.nextInt();
					 if(guess < answer)
					 {
						 System.out.println("Bear: \"bear bear\"");
						 System.out.println("Bear's friend Tarzan: \"She said too low\"\n");
					 }
					 else if(guess > answer)
					 {
						 System.out.println("Bear: \"bear bear\"");
						 System.out.println("Bear's friend Tarzan: \"She said too high\"\n");
					 }
				}
				while(guess != answer);
				System.out.println("Bear: \"bearBer! Berberber bear!\"");
				user.updateVariables(user.getLevel() + r.nextInt(51));
				System.out.println("(Enemy Bear just gives you some exp and walk away)\n");
				return false;
			}
			else
			{
				System.out.println("Bear: \"BEARRRRRRRRRR\"");
				System.out.println("(Enemies Bear covered its ears and ran away)\n");
				return false;
			}
		}
		while(!(choice.equals("1")||choice.equals("2")||choice.equals("3")));
	}
}

