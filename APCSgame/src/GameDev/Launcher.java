package GameDev;

import java.util.Scanner;

import javax.swing.JFrame;

import GameDev.features.Character;
import GameDev.features.Enemy;
import GameDev.features.Mage;
import GameDev.features.Warrior;

public class Launcher {
// enemies
// events after a fight
// enemy
	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		String isQuit;
		Game game;
		System.out.println("Welcome to the best game ever made! \n"
				+ "Heres how to play: You will be prompted to type your option under the console.  \nHowever, "
				+ "you might not know what we are prompting you to type.\nIf you're stuck, "
				+ "make sure the the spelling is right! No seriously make sure its right. Have fun!!\n\n\n");
		do {
			//test

			//we can polish the game later, maybe make a story class
			//Part0: Setting name and role
			System.out.println("You: \"Hey everyone \\(-w-)/ I am a mere peasant in the Mills Valley.\nAnd my name is...\"");
			String username = userInput.nextLine();
			System.out.println(username + ": \"There are many warriors and mages in this land, and I am a...\"");
			String role = userInput.nextLine();
			int level = 1;
			while(!(role.equalsIgnoreCase("warrior")||role.equalsIgnoreCase("mage")||role.equals("admin"))) {
				System.out.println("Nope, you can't be a "+ role + ". You have to be either a warrior or a mage. Try Again!");
				role = userInput.nextLine();
			}
			Character user;
			if(role.equalsIgnoreCase("warrior"))
			{
				user = new Warrior();
			}
			//For me to test out stuff
			else if(role.equals("admin"))
			{
				user = new Warrior();
				System.out.println("\n1. Set user to Lv.99");
				System.out.println("2. Set enemy to Lv.99");
				System.out.println("3. Log out");
				String adminCMD = userInput.nextLine();
				if (adminCMD.equals("1"))
				{
					user.updateVariables(99);
				}
				else if(adminCMD.equals(2))
				{
					level = 99;
				}
			}
			else
			{
				user = new Mage();
			}
			//info on the characters
			System.out.println(username + ": \"Here is my file. Should I take a look?\"");
			System.out.println("1. Yes. I want to review my information");
			System.out.println("2. No let's go out and get some fresh air");
			if(userInput.nextLine().equals("1"))
			{
				System.out.println("============================Profile Opened==============================\n");
				System.out.println("Class: " + user.getName());
				System.out.println("Lv: " + user.getLevel());
				System.out.println("HP: " + user.getHealth());
				System.out.println("Attack DMG: " + user.getDamage());
				System.out.println("Skill Spell: " + user.getSpell());
				System.out.println("Skill DMG: " + user.getSkillDMG());
				System.out.println("\n============================Profile Closed==============================\n");
			}
			//Part1: Story Start
			System.out.println(username + ": \"Its time for an adventure, but where do I start?\"");
			System.out.println("(A mysterious figure suddenly barges into your room and steals your pet goldfish)");
			System.out.println("Uncle James: \"little "+ username + "! HELP ME! That smlime is killin...WHERE DID YOUR GOLDFISH GO?\"\n");
			
			Enemy slime = new Enemy("Slime", level);
			game = new Game(user, slime);
			game.startEvent(userInput);
		
			System.out.println(username + " has finally found his pet goldfish unharmed... but who stole his pet?\n");
			System.out.println("\nPlease type \"Quit\" to exit. Type any key to start a new game.");
			isQuit = userInput.nextLine();
		} while (!isQuit.equalsIgnoreCase("quit"));
			userInput.close();
			System.out.println("\nThank You for trying our game!");
	}

}
