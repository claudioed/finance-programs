package tech.claudioed.adapter.http;

import io.smallrye.common.constraint.NotNull;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tech.claudioed.adapter.http.utils.FormatFinanceCondition;
import tech.claudioed.domain.financecondition.services.FinanceConditionService;
import tech.claudioed.port.inputs.FinanceProgramQuery;
import tech.claudioed.port.outputs.financecondition.FinanceConditionData;

@Path("/credit-delivery-finance-conditions")
public class CreditDeliveryController {

  private final FinanceConditionService financeConditionService;

  public CreditDeliveryController(FinanceConditionService financeConditionService) {
    this.financeConditionService = financeConditionService;
  }

  @POST
  @Path("/_search")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public List<FinanceConditionData> findFinanceCondition(@Valid @NotNull FinanceProgramQuery request) {
    return this.financeConditionService.find(request).stream().map(FormatFinanceCondition::from).toList();
  }

}
