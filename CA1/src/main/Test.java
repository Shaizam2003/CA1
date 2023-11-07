package main;

import java.util.ArrayList;
import java.util.List;

import dao.CustomerDAO;
import dao.DepositDAO;
import dao.LoanDAO;
import entities.Customer;
import entities.Deposit;
import entities.Loan;

public class Test {

	public Test() {
		

		CustomerDAO cDAO = new CustomerDAO();

				DepositDAO dDAO = new DepositDAO();

				LoanDAO lDAO = new LoanDAO();


				

				Deposit d1 = new Deposit(1000.00, "22/05/2018");

				Deposit d2 = new Deposit(1500.00, "22/05/2018");

			    Deposit d3 = new Deposit(3000.00, "22/05/2018");

		

				dDAO.persist(d1);

				dDAO.persist(d2);

			    dDAO.persist(d3);

		


				List<Deposit> deposits = new ArrayList<Deposit>();

				deposits.add(d1);

				deposits.add(d2);

			 	deposits.add(d3);


				Loan loan = new Loan("Taking out loan for Mortgage", 100000.00, deposits);

				lDAO.persist(loan);


				

				Customer customer = new Customer("Sheila","0856789908", "88 The Grove", 50000.00, loan );

				cDAO.persist(customer);



				ArrayList<Customer> customers = (ArrayList<Customer>) cDAO.getAllCustomers();

				for(Customer c : customers) {

					System.out.println("Customers name is "+c.getUsername());

					System.out.println("Loan description "+ c.getLoan().getDescription() + " and the amount taken out is " + c.getLoan().getLoanAmount());

					

					System.out.println("Customers first deposit was on "+c.getLoan().getDeposits().get(0).getDate() + " amount was " +c.getLoan().getDeposits().get(0).getAmount());

					System.out.println("Customers second deposit was on "+c.getLoan().getDeposits().get(1).getDate() + " amount was " +c.getLoan().getDeposits().get(1).getAmount());


				}		
		
		
		
	}
	
	public static void main(String[] args) {
		new Test();
	}

}


