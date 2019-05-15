package GameDev.features;

public abstract class Character 
{
	private int health;
	private int damage;
	private String name;
	
	public int getHeath()
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
}
