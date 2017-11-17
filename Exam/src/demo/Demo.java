package demo;

import java.util.ArrayList;
import java.util.Random;

import agency.Agency;
import agency.Agent;
import agency.Catalog;
import clients.Buyer;
import clients.Seller;
import property.Apartment;
import property.House;
import property.Plot;
import property.Property;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random r = new Random();
		String[] names = {"Ivan", "Marina", "Petur", "Simeon", "Denis"};
		String[] addresses = {"Mladost", "Studentski grad", "Iztok"};
		ArrayList<Agent> agents = new ArrayList<Agent>();
		for (int i = 0; i < 5; i++) {
			agents.add(new Agent(names[r.nextInt(names.length)]));
		}
		Agency agency = new Agency("Talents Estate", agents);
		for (int i = 0; i < names.length; i++) {
			agency.addAgent(agents.get(i));
			agents.get(i).setAgency(agency);
		}
		Catalog catalog = new Catalog();
		ArrayList<Seller> sellers = new ArrayList<Seller>();
		for(int i = 0; i < 30; i++){
			int random = r.nextInt(3);
			if(random == 0){
				Apartment apartment = new Apartment(r.nextInt(80000) + 70000, 
						addresses[r.nextInt(addresses.length)], r.nextInt(100));
				Seller seller = new Seller(names[r.nextInt(names.length)], apartment);
				sellers.add(seller);
			}
			else if (random > 1){
				House house = new House(r.nextInt(30000) + 50000, 
						addresses[r.nextInt(addresses.length)], r.nextInt(1000));
				Seller seller = new Seller(names[r.nextInt(names.length)], house);
				sellers.add(seller);
			}
			else{
				Plot plot = new Plot(r.nextInt(55000) + 30000, 
						addresses[r.nextInt(addresses.length)], r.nextInt(1000));
				Seller seller = new Seller(names[r.nextInt(names.length)], plot);
				sellers.add(seller);
			}
		}
		for(Seller s : sellers){
			s.registerProperty(agency);
		}
		
		ArrayList<Buyer> buyers = new ArrayList<Buyer>();
		for(int i = 0; i < 10; i++){
			buyers.add(new Buyer(names[r.nextInt(names.length)], r.nextInt(120000) + 30000));
		}
		
		for(Buyer b : buyers){
			b.registerSearch(agency);
			b.view(agency.randomProperty());
			b.view(agency.randomProperty());
			b.view(agency.randomProperty());
		}
		
	
		
	}

}
