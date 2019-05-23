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
	private String[] names = {"slime", "three slimes", "swarm of bats", "giant bat", "bandit", "bear", "trump", "spaghetti cult", "commy",
							  "skelly", "poke", "gryphon", "button"}; 
	
	private Random r = new Random(); //Just treat this like a Math.random()
	
	public Enemy(String name, int level)
	{
		this.name = name;
		this.level = level;
		if(name.equalsIgnoreCase("slime"))
		{
			health = 100 + 3* level + r.nextInt(21)*level;
			damage = 5 + r.nextInt(11)*level;
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
			damage = 15 + r.nextInt(11)*level;
		}
		else if(name.equalsIgnoreCase("bandit"))
		{
			health = 200 + r.nextInt(21)*level;
			damage = 8 + r.nextInt(11)*level;
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
		else if(name.equalsIgnoreCase("spaghetti cult"))
		{
			health = 50 + r.nextInt(21)*level;
			damage = 20 + r.nextInt(11)*level;
		}
		else if(name.equalsIgnoreCase("commy"))
		{
			health = 100 + r.nextInt(21)*level;
			damage = 5 + r.nextInt(11)*level;
		}
		else if(name.equalsIgnoreCase("skelly"))
		{
			health = 20 + r.nextInt(21)*level;
			damage = 2 + r.nextInt(11)*level;
		}
		else if(name.equalsIgnoreCase("poke"))
		{
			health = 50 + r.nextInt(21)*level;
			damage = 10 + r.nextInt(11)*level;
		}
		else if(name.equalsIgnoreCase("gryphon"))
		{
			health = 100 + r.nextInt(21)*level;
			damage = 17 + r.nextInt(11)*level;
		}
		else if(name.equalsIgnoreCase("gryphon"))
		{
			health = 100 + r.nextInt(21)*level;
			damage = 17 + r.nextInt(11)*level;
		}
		else if(name.equalsIgnoreCase("button"))
		{
			health = 1 + r.nextInt(21)*level;
			damage = 1 + r.nextInt(11)*level;
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
	// pulls an event/enemy from the array
	public String getEnemy()
	{
		return names[r.nextInt(13)];
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
		else if(name.equalsIgnoreCase("spaghetti cult"))
		{
			return spaghettiEvent(user, userInput);
		}
		else if(name.equalsIgnoreCase("commy"))
		{
			return communistEvent(user, userInput);
		}
		else if(name.equalsIgnoreCase("skelly"))
		{
			return skeletonEvent(user, userInput);
		}
		else if(name.equalsIgnoreCase("poke"))
		{
			return pokemonEvent(user, userInput);
		}
		else if(name.equalsIgnoreCase("gryphon"))
		{
			return gryphonEvent(user, userInput);
		}
		else if(name.equalsIgnoreCase("button"))
		{
			return buttonEvent(user, userInput);
		}
		else
		{
			return true;
		}
		
	}
	// starter event
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
	// follow up to starter
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
	// a group of bats
	private boolean batsEvent(Character user, Scanner userInput) 
	{
		System.out.println("As you walk along the path, a swarm of bats approaches you");
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
				System.out.println("(You offer your arm to the swarm of bats");
				System.out.println("Bats: \"You are so kind!\"");
				setHealth(-(r.nextInt(100)));
				setDamage(damage-(level + r.nextInt(4)));
				System.out.println("(The bats have increased their HP but do less damage since they are now significantly fatter)\n");
				return true;
			}
			else
			{
				System.out.println("Bat 1: \"Your so kind!\"");
				System.out.println("Bat 2: \"I know right?\"");
				System.out.println("(The bats fly away)\n");
				return false;
			}
		}
		while(!(choice.equals("1")||choice.equals("2")||choice.equals("3")));
	}
	// a bat king enemy
	private boolean batEvent(Character user, Scanner userInput) 
	{
		System.out.println("Bat: \"I am the bat king of this realm. I command you to come here and let me take a bite of you\"\n");
		String choice;
		do
		{
			System.out.println("1. \"I want to take a bite of you\"");
			System.out.println("2. \"Yes sir\"");
			System.out.println("3. (Find a way to quickly get out of the situation)");
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
				user.getHealth();
				user.getDamage();
				System.out.println("(You have lost some HP and but gained twice the amount of damage!)\n");
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
	// robs the player or attacks
	private boolean banditEvent(Character user, Scanner userInput) 
	{
		System.out.println("Bandit: \"Hey you. Give me your pants or else\"\n");
		String choice;
		do
		{
			System.out.println("1. \"No way man I lost my pants already\"");
			System.out.println("2. \"Why would you want my pants?\"");
			System.out.println("3. (Give your pants to the bandit)");
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
				System.out.println("(Thankfully you always have a spare pair of pants)");
				System.out.println("Bandit: \"Thank you!\"");
				System.out.println("(The bandit walk away with a sated look)\n");
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
				System.out.println("Bear: \"bear?be bear bearrrr a bearber\"");
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
		System.out.println("As you step through a forest you hear a bigly and very strong voice behind the nearby trees");
		System.out.println("Orange Man: We need to build a wall and it has to built quickly and I don't mind having \n"
						+ "a big beutiful door in that wall so people can come in legally" + " But some of them are not good people,\n"
						+ "they are bringing in drugs, they're bringing drugs, " + "they're bringing crime and some, I assume, are\n"
						+ "good people.\" ");
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
	//non combat even designed to lower/improve stats
	private boolean spaghettiEvent(Character user, Scanner userInput) {
		System.out.println("As you travel through a valley you come across a group of hooded figures gathering around");
		System.out.println("what appears to be a flying spaghetti monster");
		System.out.println("Hooded Figure: \"In the Name of the Pasta, and of the Sauce, and of the Holy Meatballs ");
		System.out.println("Accept His Noodly Magnificence into your heart, into your soul, and ye shall forever be free. R'Amen\"\n");
		System.out.println("The group has still not noticed you. Do you...\n");
		String choice;
		do
		{
			System.out.println("1. Ambush the holy ritual");
			System.out.println("2. Wait things out");
			System.out.println("3. Join the worship");
			choice = userInput.nextLine();
			if (choice.equals("1"))
			{
				System.out.println("Spaghetti cult: May his noodly appendage protect us!");
				return true;
			}
			else if (choice.equals("2"))
			{
				System.out.println("\"Our saucer which art in a colander, draining be Your noodles. Thy noodle come, \n"
						+ "Thy meatballness be done on earth, as it is meaty in heaven. Give us this day our daily sauce, \n"
						+ "and forgive us our lack of piracy, as we pirate and smuggle against those who lack piracy with us. \n"
						+ "And lead us not into vegetarianism,but deliver us from non-red meat sauce. For thine is the colander, \n"
						+ "the noodle, and the sauce, forever and ever. R'Amen. ");
				System.out.println("The flyinging spaghetti and its worshippers suddenly dissappear in a flash of light.\n"); 
				return false;
			}
			else
			{
				System.out.println("As you walk torwards the group they take notice of you immediately.");
				System.out.print("Hooded Figure: \"Welcome\"");
				user.getName();
				System.out.println("You feel at ease as the worship continues and feel oddly enough, slightly stronger");
				user.setHealth(user.getHealth()+40);
				user.setDamage(user.getDamage()+6);
				System.out.println("Health: " + user.getHealth());
				System.out.println("DMG: " + user.getDamage());
				return false;
			}
		}
		while(!(choice.equals("1")||choice.equals("2")||choice.equals("3")));
	}
	// russian/chinese dude that you can fight
	private boolean communistEvent(Character user, Scanner userInput) {
		System.out.println("You come across what appears to be a bearded man wearing a ushanka and fur coat.");
		System.out.println("He quickly takes notice of you and begins to speak.");
		System.out.println("Bearded Man: \"Greetings comrade, do you need any help? I know you have lost something.\"\n");
		String choice;
		do
		{
			System.out.println("1. Attack the commy");
			System.out.println("2. Accept his help");
			System.out.println("3. Run away before he does something");
			choice = userInput.nextLine();
			if (choice.equals("1"))
			{
				System.out.println("The bearded man readies his fist.\n");
				return true;
			}
			else if (choice.equals("2"))
			{
				System.out.println("Take this friend you will need it.");
				System.out.println("Item get: Ushanka");
				user.setHealth(user.getHealth()+5);
				user.setDamage(user.getDamage()+2);
				System.out.println("Health: " + user.getHealth());
				System.out.println("DMG: " + user.getDamage());
				System.out.println("You are now a Communist! Congrats!\n");
				return false;
			}
			else
			{
				System.out.println("Nothing good ever comes out of negotiating with the red terror. Good call.\n");
				return false;
			}
		}
		while(!(choice.equals("1")||choice.equals("2")||choice.equals("3")));
	}
	// generic enemy
	private boolean skeletonEvent(Character user, Scanner userInput) {
		System.out.println("Oh wonderful a skeleton. You know what this means.");
		String choice;
		do
		{
			System.out.println("1. Attack the skeleton");
			System.out.println("2. Steal its bones");
			System.out.println("3. Run away before it notices you");
			choice = userInput.nextLine();
			if (choice.equals("1"))
			{
				System.out.println("The skeleton raises its sword and begins to run torwards you");
				return true;
			}
			else if (choice.equals("2"))
			{
				System.out.println("(You use your agility to take the skeletons legs)");
				System.out.println("Really, you took the legs?");
				System.out.println("Item get: Skeleton legs");
				user.setDamage(user.getDamage()+5);
				System.out.println("DMG: " + user.getDamage());
				System.out.println("You now do additional damage by somehow fusing your weapon with bones!\n");
				return false;
			}
			else
			{
				System.out.println("Wow you ran away from a skeleton?");
				return false;
			}
		}
		while(!(choice.equals("1")||choice.equals("2")||choice.equals("3")));
	}
	// a pokemon event that may increase dmg
	private boolean pokemonEvent(Character user, Scanner userInput) {
		System.out.println("Hey look, theres a pokeball but its slightly cracked. Would you like to pick it up?");
		String choice;
		do
		{
			System.out.println("1. Pick up the pokeball");
			System.out.println("2. Break the ball");
			System.out.println("3. Don't do it");
			choice = userInput.nextLine();
			if (choice.equals("1"))
			{
				double randomizer = Math.random()*10;
				if(randomizer<5) {
					System.out.println("The ball opens and a Magikarp suddenly appears!");
					System.out.println("Unfortunately its absolutely useless!\n");
					return false;
				} else {
					System.out.println("The ball opens and a Pikachu suddenly appears!\n");
					user.setDamage(user.getDamage()+10);
					System.out.println("DMG: " + user.getDamage());
					return false;
				}
			}
			if (choice.equals("2")) {
				System.out.println("The ball opens and a very angry Charizard attacks!");
				return true;
			}
			else
			{
				System.out.println("Best to stay away from unsafe balls\n");
				return false;
			}
		}
		while(!(choice.equals("1")||choice.equals("2")));
	}
	// generic enemy
	private boolean gryphonEvent(Character user, Scanner userInput) {
		System.out.println("As you stroll along the road a very angry gryphon charges at you");
		System.out.println("It doesn't look like it wants to talk either");
		String choice;
		do
		{
			System.out.println("1. Attack the angry bird");
			System.out.println("2. Run away and hope that your athletic enough");
			choice = userInput.nextLine();
			if (choice.equals("1"))
			{
				System.out.println("The Gryphon roars.\n");
				return true;
			}
			else
			{
				System.out.println("The Gryphon roars.\n");
				return true;
			}
		}
		while(!(choice.equals("1")||choice.equals("2")));
	}
	// chance event
	private boolean buttonEvent(Character user, Scanner userInput) {
		System.out.println("Hey a button! Want to press it?");
		String choice;
		do
		{
			System.out.println("1. Press the button");
			System.out.println("2. Fight the button");
			System.out.println("3. NOPE");
			choice = userInput.nextLine();
			if (choice.equals("1"))
			{
				double randomizer = Math.random()*10;
				if(randomizer<5) {
					System.out.println("A super star drops on your head.");
					System.out.println("You feel slightly stronger.\n");
					user.setHealth(user.getHealth()+100);
					user.setDamage(user.getDamage()+50);
					System.out.println("Health: " + user.getHealth());
					System.out.println("DMG: " + user.getDamage());
					return false;
				} else {
					System.out.println("The button explodes!\n");
					user.setHealth(user.getHealth()-30);
					System.out.println("Health: " + user.getHealth() + "-30");
					return false;
				}
			} else if (choice.equals("2")) {
				System.out.println("A button.");
				return true;
			}
			else
			{
				System.out.println("Nothing good ever comes out of pressing random buttons. Good call.\n");
				return false;
			}
		}
		while(!(choice.equals("1")||choice.equals("2")||choice.equals("3")));
	}
	/* WIP
		// non combat event based on chance
	private boolean houseEvent(Character user, Scanner userInput) {
	}
	*/
}
