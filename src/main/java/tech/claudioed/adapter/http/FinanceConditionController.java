package tech.claudioed.adapter.http;

import io.smallrye.common.constraint.NotNull;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tech.claudioed.adapter.http.utils.FormatFinanceCondition;
import tech.claudioed.domain.financecondition.services.FinanceConditionService;
import tech.claudioed.port.inputs.financecondition.NewFinanceCondition;
import tech.claudioed.port.outputs.financecondition.FinanceConditionData;

@Path("/finance-conditions")
public class FinanceConditionController {

  private final FinanceConditionService financeConditionService;

  public FinanceConditionController(FinanceConditionService financeConditionService) {
    this.financeConditionService = financeConditionService;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public FinanceConditionData createFinanceCondition(@Valid @NotNull NewFinanceCondition request) {
    var fc = this.financeConditionService.newFinanceCondition(request);
    return FormatFinanceCondition.from(fc);
  }

}
