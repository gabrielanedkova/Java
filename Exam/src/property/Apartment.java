package property;

import clients.Seller;

public class Apartment extends Property{
	
	
	enum BuildingType{EPK, TUHLA, PANEL, KIRPICH};
	enum TypeOfApartment{STUDIO, GARSONIERA, DVUSTAEN, TRISTAEN, MEZONET};
	
	private BuildingType buildingType;
	private TypeOfApartment typeOfApartment;
	
	public Apartment(int price, String address, int area) {
		super(price, address, area);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "apartment";
	}
	

}
