package property;

import agency.Agent;
import clients.Seller;

public abstract class Property implements Comparable<Property>{

	private int price;
	private String description;
	private String address;
	private int area;
	private Agent agent;
	private Seller seller;
	
	
	public Property(int price, String address, int area) {
		this.price = price;
		this.description = description;
		this.address = address;
		this.area = area;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	public int getPrice() {
		return price;
	}

	@Override
	public int compareTo(Property o) {
		// TODO Auto-generated method stub
		return this.price - o.price;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((agent == null) ? 0 : agent.hashCode());
		result = prime * result + area;
		result = prime * result + price;
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
		Property other = (Property) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (agent == null) {
			if (other.agent != null)
				return false;
		} else if (!agent.equals(other.agent))
			return false;
		if (area != other.area)
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	public abstract String getType();
}
