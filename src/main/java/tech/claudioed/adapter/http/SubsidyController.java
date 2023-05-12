package tech.claudioed.adapter.http;

import io.smallrye.common.constraint.NotNull;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.domain.subsidy.SubsidyBudget;
import tech.claudioed.domain.subsidy.services.SubsidyService;
import tech.claudioed.port.inputs.subsidy.CreateBudget;

@Path("/subsidies")
@Tag(name = "Subsidies", description = "Manages factories subsidies")
public class SubsidyController {

  private final SubsidyService subsidyService;

  public SubsidyController(SubsidyService subsidyService) {
    this.subsidyService = subsidyService;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/{id}/budget")
  public SubsidyBudget createReference(@PathParam ("id")String id,@Valid @NotNull CreateBudget newBudget) {
    return this.subsidyService.registerBudget(id,newBudget.getBudget().toMonetary());
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Subsidy> subsidies() {
    return this.subsidyService.subsidies();
  }

}
