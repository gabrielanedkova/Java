package agency;

import java.time.LocalDate;

import clients.Buyer;
import property.Property;

public class View {

	private LocalDate date;
	private Buyer buyer;
	private Agent agent;
	private Property property;
	
	public View(LocalDate date, Buyer buyer, Agent agent, Property property) {
		this.date = date;
		this.buyer = buyer;
		this.agent = agent;
		this.property = property;
	}

	public Property getProperty() {
		return property;
	}
	
	
}
