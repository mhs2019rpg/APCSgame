package GameDev;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

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
	
	Character user;
	Enemy enemy;
	
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
		enemy = opponent;
	}
	
	private void init(){
		display = new Display(title, width, height);
		bg = ImageLoader.loadImage("/textures/Slime Load.png");
		display.getFrame().addKeyListener(keyManager);

		Assets.init();
		
		/*handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState); */
	}
	
	private void tick(){
		keyManager.tick();
		//if()
		//state
	}
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
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
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
	public boolean getRunning()
	{
		return running;
	}
	
}

