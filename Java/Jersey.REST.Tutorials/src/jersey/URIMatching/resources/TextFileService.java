package jersey.URIMatching.resources;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
 
@Path("/file")
public class TextFileService {
	
	private static final String FILE_PATH = "/Users/horiavitcu/Downloads/test.txt";
	
	@GET
	@Path("/getfile")
	@Produces("text/plain")
	public Response getFile() {
		
		File file = new File(FILE_PATH);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=\"file_from_server.log\"");
		
		return response.build();
		
	}
}
