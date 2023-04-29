package tech.claudioed.domain.flat.services;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.flat.repositories.FlatRepository;
import tech.claudioed.port.inputs.CreateFlat;

@ApplicationScoped
public class FlatService {

  private final FlatRepository flatRepository;

  public FlatService(FlatRepository flatRepository) {
    this.flatRepository = flatRepository;
  }

  @Transactional
  public Flat createFlat(CreateFlat request){
    var flat = new Flat(request.getName(),request.getTargets(),request.getRate(),request.getPeriod(),request.getSegment());
    this.flatRepository.persist(flat);
    return flat;
  }


}
