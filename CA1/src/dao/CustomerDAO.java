package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Customer;


public class CustomerDAO {
	
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("ShaizasPU"); 	
	
	public CustomerDAO() {
		
	}

	
	public void persist(Customer customer) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Customer customer) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(customer));
		em.getTransaction().commit();
		em.close();
	}
	
	public Customer merge(Customer customer) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Customer updatedCustomer = em.merge(customer);
		em.getTransaction().commit();
		em.close();
		return updatedCustomer;
	}
	
	
	public List<Customer> getAllCustomers() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Customer> customersFromDB = new ArrayList<Customer>();
		customersFromDB = em.createNamedQuery("Customer.findAll").getResultList();
		em.getTransaction().commit();
		em.close();
		return customersFromDB;
	}
	
	public Customer getCustomerByUsername(String username){
		EntityManager em = emf.createEntityManager();
		List<Customer> customers = (List<Customer>) 
				em.createNamedQuery("Customer.findByUsername").
				setParameter("username", username).getResultList();
		em.close();
		Customer cus = new Customer();
		for(Customer c: customers) {
			cus = c;
		}
		return cus;

}

}
