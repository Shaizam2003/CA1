package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.Customer;

@Path("/sampleservice")
public class SampleService {
	
	private static Map<String, Customer> customers = new HashMap<String, Customer>();
	
	static {
		
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setUsername("Fabrizio");
        customer1.setPhone("0871117777");
        customer1.setAddress("30 Oaklands");
        customer1.setSalary(30000.00);
        customer1.put(customer1.getId(), customer1);
        
        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setUsername("Sarah");
        customer2.setPhone("0871119999");
        customer2.setAddress("45 Elm Park");
        customer2.setSalary(50000.00);
        customer2.put(customer2.getId(), customer2);
        
    }

	@GET
    @Path("/hello")
    @Produces("text/plain")
    public String hello(){
        return "Hello World";    
    }
	
	@GET
    @Path("/helloworld")
    @Produces("text/plain")
    public String helloWorld(){
        return "Hello World New";    
    }
	
	
	@GET
    @Path("/echo/{message}")
    @Produces("text/plain")
    public String echo(@PathParam("message")String message){
        return message;  
    }
	
	
	@GET
    @Path("/employees")
    @Produces("application/xml")
    public List<Customer> listCustomers(){
        return new ArrayList<Customer>(customers.values());
    }
	
	@GET
    @Path("/customer/{customerid}")
    @Produces("application/xml")
    public Customer getCustomer(@PathParam("customerid")String customerId){
		return customers.get(customerId);		
    }
	
	@POST
	@Path("/createxml")
    @Consumes("application/xml")
    public String addCustomer(Customer customer) {
		return "Customer added " +customer.getUsername();		
    }
	
	@POST
	@Path("/createjson")
    @Consumes("application/json")
    public String addJSONCustomer(Customer customer){
		return "Customer added " +customer.getUsername();		
    }
	
	@GET
    @Path("/json/customers/")
    @Produces("application/json")
    public List<Customer> listCustomersJSON(){
		return new ArrayList<Customer>(customers.values());
    }

	@GET
    @Path("/json/customer/{customerid}")
    @Produces("application/json")
    public Customer getCustomerJSON(@PathParam("customerid")String customerId){
		return customers.get(customerId);		
    }
	

}

