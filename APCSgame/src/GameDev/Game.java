package GameDev;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import GameDev.display.Assets;
import GameDev.display.Display;
import GameDev.display.ImageLoader;
import GameDev.features.Character;
import GameDev.features.Enemy;
import GameDev.ctrl.KeyManager;


public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;
	
	private Character user;
	private Enemy enemy;
	private int enemyHP,userHP,enemyDMG,userDMG;
	private String enemyName;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	private BufferedImage bg;
	
	//Input
	private KeyManager keyManager;
	
	public Game(Character userRole, Enemy opponent){
		this.width = 640;
		this.height = 480;
		this.title = "The Werid YuH-Ja";
		keyManager = new KeyManager();
		user = userRole;
		userHP = user.getHealth();
		userDMG = user.getDamage();
		
		enemy = opponent;
		enemyHP = enemy.getHealth();
		enemyName = enemy.getName();
		enemyDMG = enemy.getDamage();
	}
	
	//No need to worry now
	private void init(){
		display = new Display(title, width, height);
		bg = ImageLoader.loadImage("/textures/MinSlime.png");
		display.getFrame().addKeyListener(keyManager);

		Assets.init();
		
		/*handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState); */
	}
	//No need to worry now
	private void tick(){
		if (enemy.getHealth() <= 0)
		{
			//System.out.println(enemy.getName()+" is defeated!");
			stop();
		}
		//state
	}
	//No need to worry now
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		
		g.drawImage(bg, 0, 0, null);
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	//No need to worry now
	public void run(){
		
		init();
		double fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println(enemy.getName() + "'s Current HP: " + enemy.getHealth());
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	//No need to worry now
	public KeyManager getKeyManager(){
		return keyManager;
	}
	//No need to worry now
	public int getWidth(){
		return width;
	}
	//No need to worry now
	public int getHeight(){
		return height;
	}
	//No need to worry now
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	//No need to worry now
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//take turn battle. if health reach 0, game end
		public void battle(Scanner userInput)
		{
			System.out.println("==============================Battle Begin==============================\n");
			do 
			{
				userTurn(userInput);
				enemyTurn(userInput);
			} while(enemy.getHealth() > 0||user.getHealth() > 0);
		}
	//Prompt player for attack and skill, print out all action the player made, go to next stage if enemy is defeated
	public void userTurn(Scanner userInput)
	{
		System.out.println("----------Your Turn!----------\n");
		System.out.println("Lv." + enemy.getLevel() + " " + enemyName + "\nHP:          "
		+ enemy.getHealth() + "/" + enemyHP + "\nDMG:         " + enemyDMG + "\n");
		System.out.println("1. Attack: " + userDMG + " dmg");
		System.out.println("2. " + user.getSpell() +": "+user.getSkillDMG()+" dmg\n");
		String cmd = userInput.next();
		
		if(cmd.equalsIgnoreCase("attack"))
		{
			enemy.setHealth(userDMG);
			System.out.println("\nYou used \"ATTACK\" and dealed with " + userDMG + " dmg");
			isEnemyDefeated(userInput);
		}
		else if(cmd.equalsIgnoreCase(user.getSpell()))
		{
			enemy.setHealth(user.getSkillDMG());
			System.out.println("\nYou used \""+user.getSpell()+"\" and made " + user.getSkillDMG() + " dmg to" + enemyName);
			isEnemyDefeated(userInput);
		}
		else
		{
			System.out.println("\nOops looks like you just miss your turn...\n");
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
		System.out.println("==============================Battle End================================\n");
		System.out.println("Unfortunely you are dead! Here are you options:");
		System.out.println("1. I would like to battle monster in my level");
		System.out.println("2. I would like to train with monster in lower level");
		System.out.println("3. I would like to challenge monster in higher level");
		System.out.println("4. I want to quit");
		String cmd;
		Enemy nextEnemy;
		Game newGame;
		do
		{
			cmd = userInput.next();
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
				nextEnemy = new Enemy(enemy.getEnemy(), level);
				newGame = new Game(user,nextEnemy);
				//newGame.startEvent
				newGame.battle(userInput);
			}
		}
		while(!(cmd.equals("1")||cmd.equals("2")||cmd.equals("3")||cmd.equals("4")));
		
		
	}
	
	public void enemyDefeated(Scanner userInput) 
	{
		System.out.println("==============================Battle End================================\n");
		
	}
	//if enemy is dead, print different text and go to next stage
	public void isEnemyDefeated(Scanner userInput) 
	{
		if(enemy.getHealth() <= 0)
		{
			System.out.println(enemyName + "'s current HP is 0/" + enemyHP + "\n");
			enemyDefeated(userInput);
		}
		else
		{
			System.out.println(enemyName + "'s current HP is " + enemy.getHealth() + "/" + enemyHP + "\n");
		}
	}
	//
	public void startEvent(Scanner userInput)
	{
		battle(userInput);
	}
}

