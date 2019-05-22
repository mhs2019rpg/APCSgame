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
		else if(name.equalsIgnoreCase("trump"))
		{
			health = 500 + r.nextInt(21)*level;
			damage = 5 + r.nextInt(11)*level;
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
		// WIP
		else if(name.equalsIgnoreCase("trump"))
		{
			return orangemanEvent(user, userInput);
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
			System.out.println("2. \"Nope. My name is Bob Ross. I'm just a regular old painter\"");
			System.out.println("3. (Quickly run away before you get beat up by slimes)");
			choice = userInput.nextLine();
			if (choice.equals("3"))
			{
				System.out.println("Slimes: \"Who is this?! Sonic?!\"\n");
				return false;
			}
			else if (choice.equals("2"))
			{
				System.out.println("(A small slime detaches itself from the group and moves torwards you)");
				System.out.println("Slime: \"Hello, my name is Inigo Montoya, you killed my father, prepare to die!\n");
				return true;
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
			System.out.println("1. \"How about I eat you instead?\"");
			System.out.println("2. \"Yes I would love to!(What could possibly go wrong)\"");
			System.out.println("3. (Offer the bats some food from your inventory)");
			choice = userInput.nextLine();
			if (choice.equals("1"))
			{
				System.out.println("Bats: \"Not if we eat you first!\"\n");
				return true;
			}
			else if (choice.equals("2"))
			{
				System.out.println("(you offer your arm to the swarm of bats");
				System.out.println("Bats: \"You are so kind!\"");
				setHealth(-(r.nextInt(100)));
				setDamage(damage-(level + r.nextInt(4)));
				System.out.println("(The bats have increased their HP but do less damage since they are now significantly fatter)\n");
				return true;
			}
			else
			{
				System.out.println("Bat 1: \"He's so kind!\"");
				System.out.println("Bat 2: \"I know right?\"");
				System.out.println("(The bats fly away)");
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
	//not trump
	private boolean orangemanEvent(Character user, Scanner userInput) {
		System.out.println("As you step through the forest you hear a bigly and very strong voice behind the nearby trees");
		System.out.println("Orange Man: We need to build a wall and it has to built quickly and I don't mind having \n"
						+ "a big beutiful door in that wall so people can come in legally");
		System.out.println("But some of them are not good people, they are bringing in drugs, they're bringing drugs, \n" 
				+ "they're bringing crime and some, I assume, are good people.\" ");
		String choice;
		do
		{
			System.out.println("1. \"fight the rambling orange man\"");
			System.out.println("2. \"offer a big trade deal\"");
			System.out.println("3. \"covfefe.....\"");
			choice = userInput.nextLine();
			if (choice.equals("1"))
			{
				System.out.println("Orange Man: \"This right here is one of those bad people\"\n");
				return true;
			}
			else if (choice.equals("2"))
			{
				System.out.println("Orange Man: \"Those shoes, I like those shoes, give them to me\"");
				System.out.println("(with reluctance you quickly take off your shoes and hand them over to the orange man)");
				System.out.println("(after all you wouldn't want to anger the rambling orange)\n");
				return false;
			}
			else
			{
				System.out.println("(You decide to listen in more to this fascinating speech)");
				System.out.println("Orange Man: \"Look, my uncle very smart man, very good genes, went to MIT, the Wharton School of Finance...\"");
				System.out.println("(After a while, the orange man walks away with a smug look on his face)");
				System.out.println("Intelligence: -1 \n");
				return false;
			}
		}
		while(!(choice.equals("1")||choice.equals("2")||choice.equals("3")));
	}
	/*
	//non combat even designed to lower/improve stats
	private boolean spaghettiEvent(Character user, Scanner userInput) {
		
	}
	// russian/chinese dude that you can fight
	private boolean communistEvent(Character user, Scanner userInput) {
		
	}
	// non combat event based on chance
	private boolean houseEvent(Character user, Scanner userInput) {
		
	}
	// generic enemy
	private boolean skeletonEvent(Character user, Scanner userInput) {
		
	}
	// a pokemon event that may increase dmg
	private boolean pokemonEvent(Character user, Scanner userInput) {
		
	}
	// generic enemy
	private boolean gryphonEvent(Character user, Scanner userInput) {
		
	}
	// chance event
	private boolean buttonEvent(Character user, Scanner userInput) {
		
	}
	*/
}
