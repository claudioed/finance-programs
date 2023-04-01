package tech.claudioed.adapter.http;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import tech.claudioed.adapter.http.utils.FormatFinanceCondition;
import tech.claudioed.domain.dealer.DealerFinanceConditionService;
import tech.claudioed.port.inputs.dealer.DealerFinanceConditionQuery;
import tech.claudioed.port.outputs.financecondition.FinanceConditionData;

@Path("/dealers")
public class DealerController {

  private final DealerFinanceConditionService dealerFinanceConditionService;

  public DealerController(DealerFinanceConditionService dealerFinanceConditionService) {
    this.dealerFinanceConditionService = dealerFinanceConditionService;
  }

  @GET
  @Path("/{id}/finance-conditions")
  @Produces(MediaType.APPLICATION_JSON)
  public List<FinanceConditionData> dealerFinanceConditions(@PathParam("id") String dealerId,@QueryParam("customerId") String customerId, @QueryParam("productLineId")String productLineId, @QueryParam("productId")String productId) {
    var query = new DealerFinanceConditionQuery(dealerId,customerId,productLineId,productId);
    return this.dealerFinanceConditionService.find(query).stream().map(FormatFinanceCondition::from).toList();
  }


}
