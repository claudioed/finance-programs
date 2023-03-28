package tech.claudioed.adapter.http;

import io.smallrye.common.constraint.NotNull;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.domain.subsidy.services.SubsidyService;
import tech.claudioed.port.inputs.CreateSubsidy;

@Path("/subsidies")
public class SubsidyController {

  private final SubsidyService subsidyService;

  public SubsidyController(SubsidyService subsidyService) {
    this.subsidyService = subsidyService;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Subsidy createReference(@Valid @NotNull CreateSubsidy request) {
    return this.subsidyService.createSubsidy(request);
  }

}
