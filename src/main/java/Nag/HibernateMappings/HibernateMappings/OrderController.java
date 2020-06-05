package Nag.HibernateMappings.HibernateMappings;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController
{
	@Autowired
  private CustomerRepo customerRepo;
	@Autowired
  private ProductRepo productRepo;


	@PostMapping("/placeOrder")
  public Customer placeOrder(@RequestBody Customer customer)
  
	{ 
		/*
		 * Product product = new Product();
		 * 
		 * product.setPrice(201); product.setProductName("Laptop"); product.setQty(200);
		 * product.setPid(203); product.setPrice(48000); Product product1 = new
		 * Product(); product1.setPrice(201); product1.setProductName("Mobile");
		 * product1.setQty(100); product1.setPid(204); product1.setPrice(19000);
		 * customer.setEmailId("Aarya@gmail.com"); customer.setGender("Male");
		 * customer.setName("Arya");
		 * customer.setProduct(Arrays.asList(product,product1));
		 */
		
	return customerRepo.save(customer);
	  
  }
	
	@SuppressWarnings("null")
	@GetMapping("/GetFiedsOnCondtion/{emailId}") 
	  public List<OrderResponse> feidsInfonCondtion(@PathVariable("emailId") String emailId) 
	     { 
		List<OrderResponse> orderResponse = customerRepo.getSomefiledsOnCondition(emailId);
		    if(orderResponse==null)
		    {
		    	orderResponse.get(0).setEmailId("Arya@gmail.com");
		       
		    }
		    else
		    	System.out.println("No Columns Found");
		    return orderResponse;
	  
	         }
	@GetMapping("/GetFiedsOnCondtion/{emailId}/{name}") 
	  public List<OrderResponse> feidsInfonCondtions(@PathVariable("emailId") String emailId,@PathVariable("name") String name) 
	     { 
		List<OrderResponse> orderResponse = customerRepo.getSomefiledsOnCondition(emailId,name);
		return orderResponse;
	     }
	
	@GetMapping("/GetAllOrders")
	  public List<Customer> findallOrdrs()
	  {
		return customerRepo.findAll();
		  
	  }
		
		
		  @GetMapping("/GetSomeFieds") 
		  public List<OrderResponse> feidsInfo() { 
			  return customerRepo.getSomefileds();
		  
		  }
		  
		  
}
