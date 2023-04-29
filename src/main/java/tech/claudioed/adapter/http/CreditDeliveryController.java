package tech.claudioed.adapter.http;

import io.smallrye.common.constraint.NotNull;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import tech.claudioed.adapter.http.utils.FormatFinanceCondition;
import tech.claudioed.domain.financecondition.CreditDeliveryQuery;
import tech.claudioed.domain.financecondition.services.FinanceConditionService;
import tech.claudioed.port.inputs.FinanceProgramQuery;
import tech.claudioed.port.outputs.financecondition.FinanceConditionData;

@Path("/credit-delivery-finance-conditions")
@Tag(name = "Credit Delivery", description = "Finance conditions that are available for credit applications")
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
    var query  = new CreditDeliveryQuery(request.dealerId(),request.productFamilyId(),request.productId(),request.customerId(),request.cultureId(),request.ratingId(),request.getLoanTime(),request.getSegment(),
        LocalDate.now(),request.getDownPayment(),request.amount(),request.getUtm());
    return this.financeConditionService.creditDeliveryQuery(query).stream().map(FormatFinanceCondition::from).toList();
  }

}
