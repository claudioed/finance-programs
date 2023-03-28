package tech.claudioed.adapter.http;

import io.smallrye.common.constraint.NotNull;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.flat.services.FlatService;
import tech.claudioed.port.inputs.CreateFlat;

@Path("/flats")
public class FlatController {

  private final FlatService flatService;

  public FlatController(FlatService flatService) {
    this.flatService = flatService;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Flat createFlat(@Valid @NotNull CreateFlat request) {
    return this.flatService.createFlat(request);
  }


}
