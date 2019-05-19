package GameDev.features;

public abstract class Character 
{

	private int health;
	private int damage;
	private String skillName;
	private int level;
	private String className;
	
	public Character()
	{
		
	}
	
	public int getHealth()
	{
		return health;
	}
	//
	public void setHealth(int dmg)
	{
		health -= dmg;
	}
	//
	public int getDamage()
	{
		return damage;
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
	public void resetVariables(int level2) {
		// TODO Auto-generated method stub
	}
	public String getName()
	{
		return className;
	}
	public abstract String getSpell();
	public abstract int getSkillDMG();
}
