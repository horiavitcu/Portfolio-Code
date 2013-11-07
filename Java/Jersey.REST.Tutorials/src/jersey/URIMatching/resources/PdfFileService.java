package jersey.URIMatching.resources;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;



@Path("/pdf")
public class PdfFileService {

	private static final String PDF_FILE = "/Users/horiavitcu/Downloads/test.pdf";
	
	@GET
	@Path("/getpdf")
	@Produces("application/pdf")
	public Response getPdfFile() {
		
		File file = new File(PDF_FILE);
		
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachement; filename = new-test-book.pdf");
		
		return response.build();
	}
	
}
