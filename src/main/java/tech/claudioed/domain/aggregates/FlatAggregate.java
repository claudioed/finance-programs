package tech.claudioed.domain.aggregates;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import tech.claudioed.domain.Flat;
import tech.claudioed.domain.repositories.FlatRepository;
import tech.claudioed.port.inputs.CreateFlat;

@ApplicationScoped
public class FlatAggregate {

  private final FlatRepository flatRepository;

  public FlatAggregate(FlatRepository flatRepository) {
    this.flatRepository = flatRepository;
  }

  @Transactional
  public Flat createFlat(CreateFlat request){
    var flat = new Flat(request.getName(),request.getTargets(),request.getRate(),request.getPeriod());
    this.flatRepository.persist(flat);
    return flat;
  }


}
