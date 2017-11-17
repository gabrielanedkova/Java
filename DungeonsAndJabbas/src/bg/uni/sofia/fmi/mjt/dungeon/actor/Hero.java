package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Treasure;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class Hero extends Player {

	private final int maxHealth;
	private final int maxMana;
	private Position position;

	public Hero(String name, int health, int mana, Position position) {
		super(name, health, mana, null, null);
		this.position = position;
		maxHealth = health;
		maxMana = mana;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public Position getPosition() {
		return position;
	}

	public void takeHealing(int healingPoints) {
		if (isAlive()) {
			health += healingPoints;
			if (health > maxHealth) {
				health = maxHealth;
			}
		}
	}

	public void takeMana(int manaPoints) {
		mana += manaPoints;
		if (mana > maxMana) {
			mana = maxMana;
		}
	}

	public void equip(Weapon weapon) {
		if (weapon == null)
		{
			return;
		}
		if (this.weapon == null || this.weapon.getDamage() < weapon.getDamage())
		{
			this.weapon = weapon;
		}
	}

	public void learn(Spell spell) {
		if (spell == null)
		{
			return;
		}
		if(this.spell == null || this.spell.getDamage() < spell.getDamage())
		{
			this.spell = spell;
		}
	}

	public void changePosition(Position position) {
		this.position = position;
	}

	public String takeTreasure(Treasure treasure) {
		return treasure.collect(this);
	}

	public String fightEnemy(Enemy enemy) {
		
		while (isAlive() && enemy.isAlive()) {
			enemy.takeDamage(attack());
			if (enemy.isAlive()) {
				takeDamage(enemy.attack());
			}
		}
		return (isAlive() ? "Enemy died." : "Hero is dead! Game over!");
	}

}
