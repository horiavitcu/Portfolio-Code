package jersey.URIMatching.resources;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


@Path("/users")
public class UserService {
	
	
	@POST
	@Path("/add")
	public Response addUser(@FormParam("name") String name,
							@FormParam("age") int age) {
		
		return Response.status(200)
				.entity("add user is called, name: " + name + ", age: " + age).build();
	}
	
	@GET
	@Path("/get")
	public Response addUser(@Context HttpHeaders headers) {
		
		String userAgent = headers.getRequestHeader("user-agent").get(0);
		
		return Response.status(200)
				.entity("addUser is called, userAgent : " + userAgent)
				.build();
		
	}
	
}
