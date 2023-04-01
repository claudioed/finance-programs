package tech.claudioed.adapter.http;

import io.smallrye.common.constraint.NotNull;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tech.claudioed.domain.simulation.FinanceProgramSimulation;
import tech.claudioed.domain.simulation.services.FinanceProgramSimulationService;
import tech.claudioed.port.inputs.FinanceProgramQuery;

@Path("/finance-program-simulation")
public class FinanceProgramSimulationController {

  private final FinanceProgramSimulationService financeProgramSimulationService;

  public FinanceProgramSimulationController(
      FinanceProgramSimulationService financeProgramSimulationService) {
    this.financeProgramSimulationService = financeProgramSimulationService;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public FinanceProgramSimulation createReference(@Valid @NotNull FinanceProgramQuery request) {
    return this.financeProgramSimulationService.financeProgram(request);
  }

}
