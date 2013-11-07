package jersey.URIMatching.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jersey.URIMatching.resources.JAXB.Customer;


@Path("/xml/customer")
public class XMLService {
	
	@GET
	@Path("/{pin}")
	@Produces(MediaType.APPLICATION_XML)
	public Customer getCustomerInXML(@PathParam("pin") int pin) {
			
		Customer customer = new Customer();
		customer.setName("test");
		customer.setPin(pin);
		
		return customer;
		
	}
	
}
