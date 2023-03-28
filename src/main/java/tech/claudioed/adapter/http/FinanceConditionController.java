package tech.claudioed.adapter.http;

import io.smallrye.common.constraint.NotNull;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tech.claudioed.domain.financecondition.FinanceCondition;
import tech.claudioed.domain.financecondition.services.FinanceConditionService;
import tech.claudioed.port.inputs.FinanceProgramRequest;
import tech.claudioed.port.inputs.financecondition.NewFinanceCondition;
import tech.claudioed.port.outputs.financecondition.FinanceConditionData;
import tech.claudioed.port.outputs.flat.FlatData;
import tech.claudioed.port.outputs.subsidy.SubsidyData;

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
    return from(fc);
  }

  @POST
  @Path("/_search")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public List<FinanceConditionData> findFinanceCondition(@Valid @NotNull FinanceProgramRequest request) {
    return this.financeConditionService.find(request).stream().map(this::from).toList();
  }

  public FinanceConditionData from(FinanceCondition fc){
    var ftSubsidy = new SubsidyData(fc.getFactorySubsidy().getId(),fc.getFactorySubsidy().getName(),fc.getFactorySubsidy().getRate(),fc.getFactorySubsidy().getType().name(),fc.getFactorySubsidy().getMaxTimeLoan().toString());
    var dlSubsidy = new SubsidyData(fc.getDealerSubsidy().getId(),fc.getDealerSubsidy().getName(),fc.getDealerSubsidy().getRate(),fc.getDealerSubsidy().getType().name(),fc.getDealerSubsidy().getMaxTimeLoan().toString());
    var fd = new FlatData(fc.getFlat().getId(),fc.getFlat().getName(),fc.getFlat().getRate());
    return new FinanceConditionData(fc.getId().toString(),fc.getName(),fc.getInterestRate(),fc.toAmount(),ftSubsidy,dlSubsidy,fd);
  }

}
