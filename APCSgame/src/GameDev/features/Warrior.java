package GameDev.features;

import java.util.Random;

import GameDev.ctrl.KeyManager;

public class Warrior extends Character 
{
	
	private int health;
	private int damage;
	private String spell;
	private int level;
	private Random r = new Random();//r.nextInt(x) generate a number from 0 to x-1
	private String className = "Warrior";
	
	public Warrior()
	{
		health = 100 + r.nextInt(51);
		damage = 5 + r.nextInt(6);
		spell = "Ryujin no ken wo kurae";
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
		health += r.nextInt(51)*diffInLv;
		damage += r.nextInt(6)*diffInLv;
	}
	//return the damage of the skill
	public int getSkillDMG()
	{
			return getDamage()*10;
	}
	@Override
	public String getSpell() 
	{
		return spell;
	}
	public String getName()
	{
		return className;
	}
}
