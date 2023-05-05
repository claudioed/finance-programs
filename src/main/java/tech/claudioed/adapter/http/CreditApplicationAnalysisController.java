package tech.claudioed.adapter.http;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import tech.claudioed.domain.analysis.AnalysisResult;
import tech.claudioed.domain.analysis.services.CreditApplicationAnalysisService;
import tech.claudioed.port.inputs.analysis.CreditApplicationAnalysisRequest;

@Path("/credit-application-analysis")
@Tag(name = "Credit Application Checks", description = "Check credit application finance configuration")
public class CreditApplicationAnalysisController {

  private final CreditApplicationAnalysisService creditApplicationAnalysisService;

  public CreditApplicationAnalysisController(
      CreditApplicationAnalysisService creditApplicationAnalysisService) {
    this.creditApplicationAnalysisService = creditApplicationAnalysisService;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public AnalysisResult check(CreditApplicationAnalysisRequest request){
    return this.creditApplicationAnalysisService.analyze(request);
  }

}
