package tech.claudioed.adapter.http;

import java.time.LocalDate;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import tech.claudioed.adapter.http.utils.FormatFinanceCondition;
import tech.claudioed.domain.dealer.DealerFinanceConditionService;
import tech.claudioed.domain.financecondition.DealerQuery;
import tech.claudioed.domain.financecondition.RatingId;
import tech.claudioed.port.inputs.dealer.DealerFinanceConditionQuery;
import tech.claudioed.port.inputs.finance.CultureId;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;
import tech.claudioed.port.outputs.financecondition.FinanceConditionData;

@Path("/dealers")
@Tag(name = "Dealer's finance conditions", description = "Finance conditions that is available dealer usage")
public class DealerController {

  private final DealerFinanceConditionService dealerFinanceConditionService;

  public DealerController(DealerFinanceConditionService dealerFinanceConditionService) {
    this.dealerFinanceConditionService = dealerFinanceConditionService;
  }

  @POST
  @Path("/{id}/_search-finance-conditions")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public List<FinanceConditionData> dealerFinanceConditions(@PathParam("id")String id, DealerFinanceConditionQuery query) {
    var dealerQuery = new DealerQuery(new DealerId(id),new ProductFamilyId(query.productFamilyId()),new ProductId(query.productId()),new CustomerId(query.customerId()),new CultureId(query.cultureId()),new RatingId(query.ratingId()),
        query.segment(),LocalDate.now());
    return this.dealerFinanceConditionService.find(dealerQuery).stream().map(FormatFinanceCondition::from).toList();
  }


}
