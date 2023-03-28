package tech.claudioed.adapter.http;

import io.smallrye.common.constraint.NotNull;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tech.claudioed.domain.referencerate.ReferenceRate;
import tech.claudioed.domain.referencerate.services.ReferenceRateService;
import tech.claudioed.port.inputs.CreateReferenceRate;

@Path("/reference-rates")
public class ReferenceRateController {

  private final ReferenceRateService referenceRateService;

  public ReferenceRateController(ReferenceRateService referenceRateService) {
    this.referenceRateService = referenceRateService;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ReferenceRate createReference(@Valid @NotNull CreateReferenceRate request) {
    return this.referenceRateService.createRate(request);
  }


}
