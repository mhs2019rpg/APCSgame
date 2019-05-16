package GameDev.features;

public class Mage extends Character 
{
	private int health;
	private int damage;
	private String name;
	private int level;
	private int intelligence;
	private int strength;
	public Mage() {
		
		health = (int) (50 + (Math.random() * 100));
		damage = (int) (1 + (Math.random() * 1));
		}
	//
	public int getHealth()
	{
		return health;
	}
	//
	public void setHealth(int health)
	{
		this.health = health;
	}
	//
	public int getDamage()
	{
		return damage;
	}
	//
	public String getName()
	{
		return name;
	}
	//
	public int getLevel()
	{
		return level;
	}
	//
	public void setLevel(int level)
	{
		this.level = level;
	}
	public int getSkill(String spell)
	{
		if (spell == "Strong Attack")
		{
			return getDamage()*20;
		}
		else
		{
			return 0;
		}
	}
}