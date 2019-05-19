package GameDev.features;

import java.util.Random;

public class Mage extends Character 
{
	private int health;
	private int damage;
	private String spell; 
	private int level;
	
	private Random r = new Random();
	
	private String className = "Mage";
	//private int intelligence;
	//private int strength;
	
	public Mage() 
	{
		
		health = 50 + r.nextInt(101);
		damage = 1 + r.nextInt(3);
		spell = "Ryuu ga wa ga teki wo kurau"; 
		level = 1;
	}
	//return HP
	public int getHealth()
	{
		return health;
	}
	//take dmg and subtract it from health
	public void setHealth(int dmg)
	{
		health -= dmg;
	}
	//return damage
	public int getDamage()
	{
		return damage;
	}
	//return level
	public int getLevel()
	{
		return level;
	}
	//multiply variables by difference in target level and current level
	public void updateVariables(int level) 
	{
		int diffInLv = level - this.level;
		this.level = level;
		health += r.nextInt(11)*diffInLv;
		damage += r.nextInt(3)*diffInLv;
	}
	public int getSkillDMG()
	{
		return getDamage()*50;
	}
	@Override
	public String getSpell() {
		return spell;
	}
	public String getName()
	{
		return className;
	}
}