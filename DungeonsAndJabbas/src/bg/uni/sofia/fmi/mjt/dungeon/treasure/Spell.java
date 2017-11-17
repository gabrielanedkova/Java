package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class Spell extends Power {

	private int manaCost;

	public Spell(String name, int damage, int manaCost) {
		super(name, damage);
		this.manaCost = manaCost;
	}

	public int getManaCost() {
		return manaCost;
	}

	@Override
	public String collect(Hero hero) {
		hero.learn(this);
		return "Spell found! Damage points: " + damage + ", Mana cost: " + manaCost;
	}

}
