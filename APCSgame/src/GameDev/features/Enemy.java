package GameDev.features;

public class Enemy extends Character
{
	private int health;
	private int damage;
	private String name;
	private int level;
	
	public Enemy(String name, int level)
	{
		this.name = name;
		this.level = level;
		if(name.endsWith("e"))
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
