package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQueries({
	@NamedQuery(name="Customer.findAll", query="select o from Customer o"), 
	@NamedQuery(name = "Customer.findByUsername", query = "select o from Customer o where o.username=:username")
})

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String username;
	private String phone;
	private String address;
	private double salary;


	@OneToOne
	private Loan loan;

public Customer () {
	
}

public Customer(String username, String phone, String address, double salary, Loan loan) {
	this.username = username;
	this.phone = phone;
	this.address = address;
	this.salary = salary;
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public Double getSalary() {
	return salary;
}

public void setSalary(Double salary) {
	this.salary = salary;
}

public Loan getLoan() {
	return loan;
}

public void setLoan(Loan loan) {
	this.loan = loan;
}

public void put(int id2, Customer customer1) {
	// TODO Auto-generated method stub
	
}



}

