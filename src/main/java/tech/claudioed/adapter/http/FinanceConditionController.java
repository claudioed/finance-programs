package tech.claudioed.adapter.http;

import io.smallrye.common.constraint.NotNull;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import tech.claudioed.adapter.http.utils.FormatFinanceCondition;
import tech.claudioed.domain.financecondition.services.FinanceConditionService;
import tech.claudioed.port.inputs.financecondition.NewFinanceCondition;
import tech.claudioed.port.outputs.financecondition.FinanceConditionData;

@Path("/finance-conditions")
@Tag(name = "Finance conditions BO", description = "Finance conditions for back office operations")
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

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<FinanceConditionData> financeConditions() {
    return this.financeConditionService.financeConditions().stream().map(FormatFinanceCondition::from).toList();
  }

}
