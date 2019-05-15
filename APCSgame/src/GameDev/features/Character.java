package GameDev.features;

public abstract class Character 
{
	/*
	private int health;
	private int damage;
	private String name;
	private int level;
	*/
	
	public abstract int getHealth();
	
	public abstract void setHealth(int health);
	
	public abstract int getDamage();
	
	public abstract String getName();
	
	public abstract int getLevel();
	
	public abstract void setLevel(int level);
}
