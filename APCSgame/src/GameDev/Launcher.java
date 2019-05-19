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
				+ "make sure the the spelling is right! Have fun!!\n\n\n");
		do {
			//test

			//we can polish the game later, maybe make a story class
			//Part0: Setting name and role
			System.out.println("You: \"Hey everyone \\(-w-)/ I am a brave Yuh-Ja in the Mills Valley.\nAnd my name is...\"");
			String username = userInput.next();
			System.out.println(username + ": \"There are many warriors and mages in the valley, and I am a...\"");
			String role = userInput.next();
			while(!(role.equalsIgnoreCase("warrior")||role.equalsIgnoreCase("mage")))
			{
				System.out.println("No way you are a "+ role + ". You must be either a warrior or a mage. Try Again!");
				role = userInput.next();
			}
			Character user;
			if(role.equalsIgnoreCase("warrior"))
			{
				user = new Warrior();
			}
			else
			{
				user = new Mage();
			}
			//More
			System.out.println(username + ": \"Here is my file. Should I take a look?\"");
			System.out.println("1. Yes. I want to review my information");
			System.out.println("2. No let's go out and get some fresh air");
			if(userInput.next().equals("1"))
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
			System.out.println(username + ": \"It is almost the time for the Holy Fight, but I felt so weird today.\"");
			System.out.println("Uncle James: \""+ username + "! HELP ME! That smlime is killin...WHERE DID YOUR PANTS GO?\"\n");
			System.out.println("1. \"I am coming now uncle James\"");
			System.out.println("2. \"????Where's my pants?!\"");
			String choice = userInput.next();
			System.out.println("Slime: \"You are disgusting\"");
			System.out.println(username + ": \"I am going to KILL YOU first, and I find my pants\"\n");
			Enemy slime = new Enemy("Slime", 1);
			game = new Game(user, slime);
			game.startEvent(userInput);
		
			System.out.println(username + " has ended the endless jurnay of finding the pants...\n");
			System.out.println("\nPlease type \"Quit\" to exit. Type any key to start a new game.");
			isQuit = userInput.next();
		} while (!isQuit.equalsIgnoreCase("quit"));
			userInput.close();
	}

}
