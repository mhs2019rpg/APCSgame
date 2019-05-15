package GameDev.features;

public class Warrior extends Character 
{
	private int health;
	private int damage;
	private String name;
	private int level = 1;
	
	public Warrior()
	{
		health = (int) (100 + (Math.random() * 100));
		damage = (int) (5 + (Math.random() * 5));
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
