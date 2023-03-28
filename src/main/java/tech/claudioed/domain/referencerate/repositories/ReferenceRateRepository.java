package tech.claudioed.domain.referencerate.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.time.LocalDateTime;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.referencerate.ReferenceRate;
@ApplicationScoped
public class ReferenceRateRepository implements PanacheRepository<ReferenceRate> {

  public ReferenceRate currentReferenceRate(LocalDateTime current){
    return findAll().stream().findFirst().get();
  }

}
