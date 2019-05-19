package GameDev.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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
			health = (int) (100 + (r.nextInt(21)*level));
			damage = (int) (10 + (r.nextInt(11)*level));
		}
		if(name.equalsIgnoreCase("three slimes"))
		{
			health = (int) (200 + (r.nextInt(21)*level));
			damage = (int) (10 + (r.nextInt(11)*level));
		}if(name.equalsIgnoreCase("swarm of bats"))
		{
			health = (int) (200 + (r.nextInt(21)*level));
			damage = (int) (10 + (r.nextInt(11)*level));
		}if(name.equalsIgnoreCase("giant bat"))
		{
			health = (int) (200 + (r.nextInt(21)*level));
			damage = (int) (10 + (r.nextInt(11)*level));
		}if(name.equalsIgnoreCase("bandit"))
		{
			health = (int) (200 + (r.nextInt(21)*level));
			damage = (int) (10 + (r.nextInt(11)*level));
		}if(name.equalsIgnoreCase("bear"))
		{
			health = (int) (200 + (r.nextInt(21)*level));
			damage = (int) (10 + (r.nextInt(11)*level));
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
		return names[r.nextInt(7)];
	}

	@Override
	public String getSpell() {
		return null;
	}

	@Override
	public int getSkillDMG() {
		return 0;
	}
}
