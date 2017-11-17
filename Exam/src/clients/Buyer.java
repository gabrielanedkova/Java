package clients;

import java.time.LocalDate;
import java.util.ArrayList;

import agency.Agency;
import agency.View;
import property.Property;

public class Buyer extends Client{

	private int budget;
	private ArrayList<View> views;
	
	public Buyer(String name,int budget) {
		super(name);
		if (budget > 0)
			this.budget = budget;
		this.views = new ArrayList<View>();
	}
	
	public void registerSearch(Agency agency){
		setAgent(agency.randomAgent());
		this.agent.registerBuyer(this);
	}
	
	public boolean buyProperty(Property property){
		for (View v : views){
			if (v.getProperty().equals(property)){
				int price = property.getPrice();
				int threePercent = (price/100) * 3;
				if (price + threePercent > budget)
					return false;
				this.budget -= price + threePercent;
				agent.sellProperty(property, threePercent);
				return true;
			}
		}
		return false;
	}
	public boolean view(Property property){
		int price = property.getPrice();
		if (price > this.budget)
			return false;
		else {
			View view = new View(LocalDate.now(), this, this.agent, property);
			if (this.agent.addView(view)){
				views.add(view);
				return true;
			}
			return false;
		}
	}
	
}
