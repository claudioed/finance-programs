package tech.claudioed.adapter.http;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import tech.claudioed.domain.analysis.CreditApplicationAnalysis;
import tech.claudioed.domain.analysis.CreditApplicationId;
import tech.claudioed.domain.analysis.services.CreditApplicationAnalysisService;

@Path("/credit-applications")
@Tag(name = "Credit Application", description = "Search credit application checks")
public class CreditApplicationController {

  private final CreditApplicationAnalysisService creditApplicationAnalysisService;

  public CreditApplicationController(
      CreditApplicationAnalysisService creditApplicationAnalysisService) {
    this.creditApplicationAnalysisService = creditApplicationAnalysisService;
  }

  @GET
  @Path("/{id}/analysis")
  @Produces(MediaType.APPLICATION_JSON)
  public List<CreditApplicationAnalysis> findAnalysis(@PathParam("id") String id){
    return this.creditApplicationAnalysisService.analysisFromApplication(new CreditApplicationId(id));
  }

}
