package jersey.URIMatching.resources;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;



@Path("/excel")
public class ExcelFileService {

	private static final String EXCEL_FILE = "/Users/horiavitcu/Downloads/test.xlsx";
	
	@GET
	@Path("/getexcel")
	@Produces("application/vnd-ms.excel")
	public Response getExcelFile() {
		
		File file = new File(EXCEL_FILE);
		
		ResponseBuilder response = Response.ok((Object) file);
		
		response.header("Content-Disposition",
				"attachment; filename=new-excel-file.xls");
		
		return response.build();
		
	}
}
