package tech.claudioed.adapter.http;

import io.smallrye.common.constraint.NotNull;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tech.claudioed.domain.FinanceProgramSimulation;
import tech.claudioed.domain.aggregates.FinanceProgramSimulationAggregate;
import tech.claudioed.port.inputs.FinanceProgramRequest;

@Path("/finance-program-simulation")
public class FinanceProgramSimulationController {

  private final FinanceProgramSimulationAggregate financeProgramSimulationAggregate;

  public FinanceProgramSimulationController(
      FinanceProgramSimulationAggregate financeProgramSimulationAggregate) {
    this.financeProgramSimulationAggregate = financeProgramSimulationAggregate;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public FinanceProgramSimulation createReference(@Valid @NotNull FinanceProgramRequest request) {
    return this.financeProgramSimulationAggregate.financeProgram(request);
  }

}
