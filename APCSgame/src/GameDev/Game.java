package GameDev;

import java.util.Random;
import java.util.Scanner;

import GameDev.features.Character;
import GameDev.features.Enemy;

//test
public class Game {
	
	private Character user;
	private Enemy enemy;
	private int enemyHP, userHP, enemyDMG, userDMG;
	private String enemyName;
	private boolean running = false;
	private Random r = new Random();
	
	public Game(Character userRole, Enemy opponent){
		user = userRole;
		userHP = user.getHealth();
		userDMG = user.getDamage();
		
		enemy = opponent;
		enemyHP = enemy.getHealth();
		enemyName = enemy.getName();
		enemyDMG = enemy.getDamage();
	}
	
	//the turn battle. if the health reach 0, running = false and the battle "end"
		public void battle(Scanner userInput)
		{
			running = true;
			System.out.println("==============================Battle start!=============================\n");
			do 
			{
				userTurn(userInput);
				if(running)
				{
					enemyTurn(userInput);
				}
			} while(running);
		}
	//Prompt player for an attack or skill,
	//returns actions the player made
	//progreses to next stage if enemy is defeated
	public void userTurn(Scanner userInput)
	{
		System.out.println("----------Your Turn!----------\n");
		System.out.println("Lv." + enemy.getLevel() + " " + enemyName + 
		"\nHP: " + enemy.getHealth() + "/" + enemyHP +
		"\nDMG:" + enemyDMG + "\n");
		String attackOption = "1. Attack:                                             ".substring(0, 36) + user.getDamage() + " dmg";
		String skillOption = ("2. " + user.getSpell() +":                              ").substring(0, 36) + user.getSkillDMG() + " dmg\n";
		System.out.println("Lv." + user.getLevel() + " " +user.getName());
		System.out.println(attackOption);
		System.out.println(skillOption);
		String cmd = userInput.nextLine();
		
		if(cmd.equalsIgnoreCase("attack"))
		{
			System.out.println(cmd);
			enemy.setHealth(userDMG);
			System.out.println("\nYou attacked with " + userDMG + " dmg");
			isEnemyDefeated(userInput);
		}
		else if(cmd.equalsIgnoreCase(user.getSpell()))
		{
			enemy.setHealth(user.getSkillDMG());
			System.out.println("\nYou used \""+user.getSpell()+"\" and made " + user.getSkillDMG() + " dmg to " + enemyName);
			isEnemyDefeated(userInput);
		}
		else
		{
			System.out.println("\nOops Sadly you missed your attack...");
			System.out.println("Make sure you spell the option correctly");
			System.out.println("After all, spelling is important!\n");
		}
	}
	//print out all action the enemy made, trigger playerDefeated option if player is dead
	public void enemyTurn(Scanner userInput)
	{
		System.out.println("----------" + enemyName + " Turn!----------\n");
		user.setHealth(enemyDMG);
		System.out.println(enemyName + " used \"ATTACK\" and made " + enemyDMG + " dmg to you");
		if(user.getHealth() <= 0)
		{
			System.out.println("Your current HP is 0/" + userHP + "\n");
			userDefeated(userInput);
		}
		else
		{
			System.out.println("Your current HP is " + user.getHealth() + "/" + userHP + "\n");
		}
	}

	public void userDefeated(Scanner userInput) 
	{
		running = false;
		System.out.println("==============================Battle End================================\n");
		System.out.println("Unfortunely you are dead! Here are you options:");
		System.out.println("1. I would like to battle monster in my level");
		System.out.println("2. I would like to train with monster in lower level");
		System.out.println("3. I would like to challenge monster in higher level");
		System.out.println("4. I want to quit");
		user.setHealth(userHP);
		String cmd;
		Enemy nextEnemy;
		Game newGame;
		do
		{
			cmd = userInput.nextLine();
			if (cmd.equals("1")||cmd.equals("2")||cmd.equals("3"))
			{
				int level = user.getLevel();
				if(cmd.equals("2"))
				{
					level--;
				}
				else if(cmd.equals("3"))
				{
					level++;
				}
				user.updateVariables(user.getLevel());
				nextEnemy = new Enemy(enemy.getEnemy(), level);
				newGame = new Game(user,nextEnemy);
				newGame.startEvent(userInput);
			}
			else if (cmd.equals("4"))
			{
				break;
			}
		}
		while(!(cmd.equals("1")||cmd.equals("2")||cmd.equals("3")||cmd.equals("4")));
		
		
	}
	//start new game when enemy is defeated
	public void enemyDefeated(Scanner userInput) 
	{
		running = false;
		System.out.println("==============================Battle End================================\n");
		user.updateVariables(enemy.getLevel() + 1);
		System.out.println("Hey you defeated "+ enemy.getName()+"! But it did not have your pants...");
		System.out.println("1. I want to battle the next monster for the next level");
		System.out.println("2. I want to fight a monster that will probably murder me horribly");
		System.out.println("3. I want to quit because I'm bored and this game obviously sucks");
		String cmd;
		Enemy nextEnemy;
		Game newGame;
		do {
			cmd = userInput.nextLine();
			if (cmd.equals("1")||cmd.equals("2")) {
				int level = user.getLevel() + 1;
				if(cmd.equals("2")) {
					level += 1 + r.nextInt(5);
				}
				nextEnemy = new Enemy(enemy.getEnemy(), level);
				newGame = new Game(user,nextEnemy);
				newGame.startEvent(userInput);
			}
			else if (cmd.equals("3")) {
				break;
			}
		}
		while(!(cmd.equals("1")||cmd.equals("2")||cmd.equals("3")));
	}
	//if enemy is dead, print different text and go to next stage
	public void isEnemyDefeated(Scanner userInput) {
		if(enemy.getHealth() <= 0) {
			System.out.println(enemyName + "'s current HP is 0/" + enemyHP + "\n");
			enemyDefeated(userInput);
			} else {
			System.out.println(enemyName + "'s current HP is " + enemy.getHealth() + "/" + enemyHP + "\n");
		}
	}
	//Start event, and battle if battle are triggered, else just start another game
	public void startEvent(Scanner userInput) {
		if (enemy.triggerBattle(user, userInput)) {
			battle(userInput);
		} else {
			Enemy foe = new Enemy(enemy.getEnemy(), user.getLevel());
			Game newGame = new Game(user, foe);
			newGame.startEvent(userInput);
		}
	}
}

