package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class Player implements Actor {
	protected String name;
	protected int health;
	protected int mana;
	protected Weapon weapon;
	protected Spell spell;

	public Player(String name, int health, int mana, Weapon weapon, Spell spell) {
		this.name = name;
		this.health = health;
		this.mana = mana;
		this.weapon = weapon;
		this.spell = spell;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public int getMana() {
		return mana;
	}

	@Override
	public boolean isAlive() {
		return health > 0;
	}

	@Override
	public Weapon getWeapon() {
		return weapon;
	}

	@Override
	public Spell getSpell() {
		return spell;
	}

	@Override
	public void takeDamage(int damagePoints) {
		if (health >= damagePoints)
			health -= damagePoints;
		else
			health = 0;
	}

	@Override
	public int attack() {
		if(spell != null)
		{
			if(weapon == null || weapon.getDamage() < spell.getDamage())
			{
				if(mana >= spell.getDamage())
				{
					mana-=spell.getDamage();
				 	return spell.getDamage();
				}
			}
			return weapon.getDamage();
		}
		else if (weapon != null)
		{
			return weapon.getDamage();
		}
		else return 0;
	}
	
}
