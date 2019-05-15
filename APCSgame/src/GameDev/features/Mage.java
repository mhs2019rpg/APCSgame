package GameDev.features;

public class Mage extends Character 
{
	private int health;
	private int damage;
	private String name;
	private int level;
	
	public Mage()
	{
		this.level = level;
		if(name.endsWith("e"))
		{
			health = 200 + 20*(level);
			damage = 10 + 10*(level);
		}
	}

	public int getHealth()
	{
		return health;
	}
	public void setHealth(int health)
	{
		this.health = health;
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