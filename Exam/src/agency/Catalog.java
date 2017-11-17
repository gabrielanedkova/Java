package agency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeSet;

import property.Property;

public class Catalog {

	enum Type{APARTMENT, HOUSE, PLOT};
	private HashMap<Type, TreeSet<Property>> properties;
	
	public Catalog() {
		properties = new HashMap<Type, TreeSet<Property>>();
		properties.put(Type.APARTMENT, null);
		properties.put(Type.HOUSE,null);
		properties.put(Type.HOUSE, null);
	}
	
	public Property randomProperty(){
		Random r = new Random();
		int rnd = r.nextInt(3);
		if (rnd == 0){
			TreeSet<Property> p = properties.get(Type.APARTMENT);
			int random = r.nextInt(p.size());
			for(Property pr : p){
				if(random == 0)
					return pr;
				random--;
			}	
		}
		else if (rnd == 1){
			TreeSet<Property> p = properties.get(Type.HOUSE);
			int random = r.nextInt(p.size());
			for(Property pr : p){
				if(random == 0)
					return pr;
				random--;
			}
		}
		else {
			TreeSet<Property> p = properties.get(Type.PLOT);
			int random = r.nextInt(p.size());
			for(Property pr : p){
				if(random == 0)
					return pr;
				random--;
			}
		}
		return null;
		
	}
	
	public void addProperty(Property property){
		TreeSet<Property> p = new TreeSet<Property>();
		if (property.getType().compareTo("apartment") == 0){
			p = properties.get(Type.APARTMENT);
			if (p == null){
				p = new TreeSet<Property>();
			}
			p.add(property);
			properties.put(Type.APARTMENT, p);
		}
		else if (property.getType().compareTo("house") == 0){
			p = properties.get(Type.HOUSE);
			if (p == null){
				p = new TreeSet<Property>();
			}
			p.add(property);
			properties.put(Type.HOUSE, p);
		}
		else if (property.getType().compareTo("plot") == 0){
			p = properties.get(Type.PLOT);
			if (p == null){
				p = new TreeSet<Property>();
			}
			p.add(property);
			properties.put(Type.PLOT, p);
		}
	}

	public void removeProperty(Property property) {
		TreeSet<Property> p;
		if (property.getType().compareTo("apartment") == 0){
			p = properties.get(Type.APARTMENT);
			p.remove(property);
			properties.put(Type.APARTMENT, p);
		}
		else if (property.getType().compareTo("house") == 0){
			p = properties.get(Type.HOUSE);
			p.remove(property);
			properties.put(Type.HOUSE, p);
		}
		else if (property.getType().compareTo("plot") == 0){
			p = properties.get(Type.PLOT);
			p.remove(property);
			properties.put(Type.PLOT, p);
		}
		
	}
	
	
}
