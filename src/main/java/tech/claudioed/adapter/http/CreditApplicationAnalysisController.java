package tech.claudioed.adapter.http;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import tech.claudioed.port.inputs.analysis.CreditApplicationAnalysisRequest;
import tech.claudioed.port.outputs.analysis.CreditApplicationAnalysisReport;

@Path("/credit-application-analysis")
@Tag(name = "Credit Application Checks", description = "Check credit application finance configuration")
public class CreditApplicationAnalysisController {

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public CreditApplicationAnalysisReport check(CreditApplicationAnalysisRequest request){

    return null;
  }



}
