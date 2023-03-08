package tech.claudioed.domain.aggregates;

import java.time.LocalDateTime;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import tech.claudioed.domain.ReferenceRate;
import tech.claudioed.domain.repositories.ReferenceRateRepository;
import tech.claudioed.port.inputs.CreateReferenceRate;

@ApplicationScoped
public class ReferenceRateAggregate {

  private final ReferenceRateRepository referenceRateRepository;

  public ReferenceRateAggregate(ReferenceRateRepository referenceRateRepository) {
    this.referenceRateRepository = referenceRateRepository;
  }

  @Transactional
  public ReferenceRate createRate(CreateReferenceRate request){
      var rr = new ReferenceRate(LocalDateTime.now(),request.getPeriod(),request.getRate());
      this.referenceRateRepository.persist(rr);
      return rr;
  }

}
