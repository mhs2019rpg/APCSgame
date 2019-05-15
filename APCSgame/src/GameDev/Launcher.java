package GameDev;

import java.util.Scanner;

import GameDev.features.Character;
import GameDev.features.Mage;
import GameDev.features.Warrior;

public class Launcher {

	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		String isQuit;
		System.out.println("Instruction: Welcome to the game! During the process of the game,\n"
				+ "you will be prompted to type you option in under the console.  \nHowever, "
				+ "you might not know what we are prompting you to type.\nIf you are stuck, "
				+ "make sure you are spelling everything right! Game Start Now!!\n\n\n");
		do {
			//we can polish the game later, maybe make a story class
			System.out.println("????: \"Hey everyone \\(-w-)/ I am a brave Yuh-Ja in the Mills Valley.\nAnd my name is...\"");
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
			System.out.println(username + ": \"It is almost the time for the Holy Fight, but I felt so weird today.\"");
			System.out.println("Uncle James: \""+ username + "! HELP ME! That smlime is killin...WHERE DID YOUR PANTS GO?\"\n");
			System.out.println("1. \"I am coming now uncle James\"");
			System.out.println("2. \"????Where's my pants?!\"");
			Game game = new Game(userRole, 640, 480);
			game.start();
			System.out.println("\nPlease type \"Quit\" to exit. Type any key to play again.");
			isQuit = userInput.next();
		} while (!isQuit.equalsIgnoreCase("quit"));
			userInput.close();
	}

}
