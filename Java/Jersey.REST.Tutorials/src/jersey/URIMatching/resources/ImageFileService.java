package jersey.URIMatching.resources;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


@Path("/image")
public class ImageFileService {
	
	private static final String IMAGE_FILE = "/Users/horiavitcu/Downloads/4960x.png";
	
	@GET
	@Path("/getimage")
	@Produces("image/png")
	public Response getImageFile() {
		
		File file = new File(IMAGE_FILE);
		
		ResponseBuilder response = Response.ok((Object) file);
		
		response.header("Content-Disposition",
				"attachment; filename=image_from_server.png");
		
		return response.build();
		
	}
	
}
