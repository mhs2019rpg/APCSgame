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
			Character userRole;
			if(role.equalsIgnoreCase("warrior"))
			{
				userRole = new Warrior();
			}
			else
			{
				userRole = new Mage();
			}
			// sys.outprint("event text")
			// things
			//Part1: Story Start
			System.out.println(username + ": \"It is almost the time for the Holy Fight, but I felt so weird today.\"");
			System.out.println("Uncle James: \""+ username + "! HELP ME! That smlime is killin...WHERE DID YOUR PANTS GO?\"\n");
			System.out.println("1. \"I am coming now uncle James\"");
			System.out.println("2. \"????Where's my pants?!\"");
			String choice = userInput.next();
			if(choice.equals("1"))
			{
				System.out.println("Slime: \"You are disgusting\"\n" + username + ": \"I AM KILLING YOU.\"\n");
				Enemy slime = new Enemy("Slime", 1);
				game = new Game(userRole, slime);
				do
				{
					game.start();
				} while(game.getRunning());
			}
			System.out.println(username + ": \"Now I should find my pants.\"");
			System.out.println("\nPlease type \"Quit\" to exit. Type any key to play again.");
			isQuit = userInput.next();
		} while (!isQuit.equalsIgnoreCase("quit"));
			userInput.close();
	}

}
