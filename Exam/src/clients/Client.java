package clients;

import agency.Agent;

public abstract class Client {

	private String name;
	private String phone;
	protected Agent agent;
	
	
	public Client(String name) {
		this.name = name;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	
	
}
