package tech.claudioed.domain.referencerate.services;

import java.time.LocalDateTime;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import tech.claudioed.domain.referencerate.ReferenceRate;
import tech.claudioed.domain.referencerate.repositories.ReferenceRateRepository;
import tech.claudioed.port.inputs.CreateReferenceRate;

@ApplicationScoped
public class ReferenceRateService {

  private final ReferenceRateRepository referenceRateRepository;

  public ReferenceRateService(ReferenceRateRepository referenceRateRepository) {
    this.referenceRateRepository = referenceRateRepository;
  }

  @Transactional
  public ReferenceRate createRate(CreateReferenceRate request){
      var rr = new ReferenceRate(LocalDateTime.now(),request.getPeriod(),request.getRate());
      this.referenceRateRepository.persist(rr);
      return rr;
  }

}
