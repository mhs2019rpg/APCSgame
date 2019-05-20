package GameDev.features;

import java.util.Random;

public class Warrior extends Character 
{
	
	private int HP;
	private int defaultHP;
	private int damage;
	private String spell;
	private int level;
	private Random r = new Random();//r.nextInt(x) generate a number from 0 to x-1
	private String className = "Warrior";
	
	public Warrior()
	{
		HP = 100 + r.nextInt(51);
		damage = 5 + r.nextInt(6);
		spell = "Ryujin no ken wo kurae";
		level = 1;
	}
	//return HP
	public int getHealth()
	{
		return HP;
	}
	//return the hp when the player was setup
	public int getDefaultHP()
	{
		return defaultHP;
	}
	//take dmg and subtract it from health
	public void setHealth(int dmg)
	{
		HP -= dmg;
	}
	//return damage
	public int getDamage()
	{
		return damage;
	}
	//return damage
	public void setDamage(int dmg)
	{
		damage = dmg;
	}
	//return level
	public int getLevel()
	{
		return level;
	}
	//multiply variables by difference in target level and current level
	public void updateVariables(int level) 
	{
		if(this.level < level)
		{
			int diffInLv = level - this.level;
			this.level = level;
			HP += r.nextInt(51)*diffInLv;
			damage += r.nextInt(6)*diffInLv;
		}
	}
	//return the damage of the skill
	public int getSkillDMG()
	{
			return getDamage()*10;
	}
	public String getSpell() 
	{
		return spell;
	}
	public String getName()
	{
		return className;
	}
}
