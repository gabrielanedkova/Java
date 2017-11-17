package property;

import clients.Seller;

public class House extends Property{


	enum TypeOfHouse{FLOOR, WHOLE};
	
	private TypeOfHouse typeOfHouse;
	private int parkPlaces;
	private int yardArea;
	
	public House(int price, String address, int area) {
		super(price, address, area);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "house";
	}
}
