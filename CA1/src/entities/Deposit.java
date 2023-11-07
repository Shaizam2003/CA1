package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Deposit {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private double amount;
	private String date;
	




public Deposit() {
}

public Deposit(double amount, String date) {
	this.amount = amount;
	this.date = date;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

}