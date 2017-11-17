package property;

import clients.Seller;

public class Plot extends Property{
	
	enum TypeOfPlot{MEADOW, FIELD, FOREST};
	private TypeOfPlot typeOfPlot;
	private boolean isInRegulation;
	
	public Plot(int price, String address, int area) {
		super(price, address, area);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "plot";
	}
	

}
