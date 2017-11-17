package agency;

import java.util.ArrayList;
import java.util.Random;

import property.Property;

public class Agency {

	private String name;
	private String phone;
	private int money;
	private String address;
	private ArrayList<Agent> agents;
	private Catalog catalog;
	
	
	public Agency(String name, ArrayList<Agent> agents) {
		this.name = name;
		this.agents = agents;
		this.money = 0;
		catalog = new Catalog();
	}

	public void addAgent(Agent agent){
		agents.add(agent);
	}
	public Agent randomAgent(){
		int random = new Random().nextInt(agents.size());
		return agents.get(random);
	}
	
	public Property randomProperty(){
		return catalog.randomProperty();
	}
	
	public void addInCatalog(Property property){
		catalog.addProperty(property);
	}
	
	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public int getMoney() {
		return money;
	}

	public void takeMoney(int money){
		this.money += money;
	}

	public void removeProperty(Property property) {
		catalog.removeProperty(property);
		
	}
}
