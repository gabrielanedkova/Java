package clients;

import agency.Agency;
import property.Property;

public class Seller extends Client{

	private Property property;
	private int money;

	public Seller(String name, Property property) {
		super(name);
		this.property = property;
		this.money = 0;
	}

	public void registerProperty(Agency agency){
		setAgent(agency.randomAgent());
		this.property.setAgent(this.agent);
		agency.addInCatalog(this.property);
		this.agent.registerSeller(this);
	}

	public void sellProperty(int money) {
		// TODO Auto-generated method stub
		takeMoney(money);
		this.property = null;	
	}
	
	private void takeMoney(int money){
		this.money += property.getPrice() + money;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + money;
		result = prime * result + ((property == null) ? 0 : property.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		if (money != other.money)
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		return true;
	}
	
	
}
