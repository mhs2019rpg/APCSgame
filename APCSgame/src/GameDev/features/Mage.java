package GameDev.features;

import java.util.Random;

public class Mage extends Character 
{
	private int HP;
	private int defaultHP;
	private int damage;
	private String spell; 
	private int level;
	
	private Random r = new Random();
	
	private String className = "Mage";
	
	//private int intelligence;
	//private int strength;
	
	public Mage() 
	{
		
		HP = 50 + r.nextInt(101);
		damage = 10 + r.nextInt(3);
		spell = "omae wa mou shindeiru"; 
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
			HP += r.nextInt(11)*diffInLv;
			damage += r.nextInt(3)*diffInLv;
		}
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