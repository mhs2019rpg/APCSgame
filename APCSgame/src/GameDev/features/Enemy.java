package GameDev.features;

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
	private String name;
	private int level;
	private String [] names = {"slime", "three slimes", "swarm of bats", "giant bat", "bandit", "bear"}; 
	public Enemy(String name, int level)
	{
		this.name = name;
		this.level = level;
		if(name.equalsIgnoreCase("slime"))
		{
			health = (int) (100 + (Math.random()*20*level));
			damage = (int) (10 + (Math.random()*10*level));
		}
		if(name.equalsIgnoreCase("three slimes"))
		{
			health = (int) (200 + (Math.random()*20*level));
			damage = (int) (10 + (Math.random()*10*level));
		}if(name.equalsIgnoreCase("swarm of bats"))
		{
			health = (int) (200 + (Math.random()*20*level));
			damage = (int) (10 + (Math.random()*10*level));
		}if(name.equalsIgnoreCase("giant bat"))
		{
			health = (int) (200 + (Math.random()*20*level));
			damage = (int) (10 + (Math.random()*10*level));
		}if(name.equalsIgnoreCase("bandit"))
		{
			health = (int) (200 + (Math.random()*20*level));
			damage = (int) (10 + (Math.random()*10*level));
		}if(name.equalsIgnoreCase("bear"))
		{
			health = (int) (200 + (Math.random()*20*level));
			damage = (int) (10 + (Math.random()*10*level));
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

}
