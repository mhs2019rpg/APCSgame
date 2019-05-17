package GameDev.features;

import GameDev.ctrl.KeyManager;

public class Warrior extends Character 
{
	
	private int health = (int) (100 + (Math.random() * 100));
	private int damage = (int) (5 + (Math.random() * 5));
	private String name;
	private int level = 1;
	
	// Warrior player = new Warrior(15221, 1251251);
	public Warrior()
	{
	}
	// 
	public int getSkill(String spell)
	{
		if (spell == "Strong Attack")
		{
			return getDamage()*10;
		}
		else
		{
			return 0;
		}
	}
}
