package tech.claudioed.adapter.http;

import io.smallrye.common.constraint.NotNull;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tech.claudioed.domain.Flat;
import tech.claudioed.domain.aggregates.FlatAggregate;
import tech.claudioed.port.inputs.CreateFlat;

@Path("/flats")
public class FlatController {

  private final FlatAggregate flatAggregate;

  public FlatController(FlatAggregate flatAggregate) {
    this.flatAggregate = flatAggregate;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Flat createReference(@Valid @NotNull CreateFlat request) {
    return this.flatAggregate.createFlat(request);
  }


}
