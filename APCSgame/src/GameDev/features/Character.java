package GameDev.features;

public abstract class Character 
{

	private int HP;
	private int defaultHP;
	private int damage;
	private String skillName;
	private int level;
	private String className;
	private String spell;
	
	public Character()
	{
		
	}
	
	public int getHealth() {
		return HP;
	}
	//
	public int getDefaultHP() {
		return defaultHP;
	}
	//
	public void setHealth(int dmg) {
		HP -= dmg;
	}
	//
	public int getDamage() {
		return damage;
	}
	public void setDamage(int dmg) {
		damage = dmg;
	}
	//
	public int getLevel() {
		return level;
	}
	//
	public void setLevel(int level) {
		this.level = level;
	}
	public void updateVariables(int level) 
	{

	}
	public String getName() {
		return className;
	}

	public String getSpell() {
		return spell;
	}
	public abstract int getSkillDMG();
}
