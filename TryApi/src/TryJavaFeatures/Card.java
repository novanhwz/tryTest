package TryJavaFeatures;

import java.util.List;

public class Card {
	
	private String bank;
	private double ammount;
	
	public Card(String bank, double ammount) {
		super();
		this.bank = bank;
		this.ammount = ammount;
	}
	
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public double getAmmount() {
		return ammount;
	}
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	
	
}
