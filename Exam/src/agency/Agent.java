package agency;

import java.util.HashSet;

import clients.Buyer;
import clients.Seller;
import property.Property;

public class Agent {

	private String name;
	private String phone;
	private int money;
	private HashSet<Seller> sellers;
	private HashSet<Buyer> buyers;
	private HashSet<View> views;
	private Agency agency;
	
	public Agent(String name) {
		sellers = new HashSet<Seller>();
		buyers = new HashSet<Buyer>();
		views = new HashSet<View>();
		this.name = name;	}
	
	public void setAgency(Agency agency){
		this.agency = agency;
	}
	public void registerSeller(Seller seller){
		sellers.add(seller);
	}
	
	public void registerBuyer(Buyer buyer){
		buyers.add(buyer);
	}
	
	public boolean addView(View view){
		if (views.add(view))
			return true;
		return false;
	}
	public void sellProperty(Property property, int money){
		agency.takeMoney(money);
		takeMoney(money);
		agency.removeProperty(property);
		Seller seller = property.getSeller();
		seller.sellProperty(money);
	}
	private void takeMoney(int money) {
		this.money = money;
	}
}
