package tech.claudioed.domain.aggregates;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import tech.claudioed.domain.Subsidy;
import tech.claudioed.domain.repositories.SubsidyRepository;
import tech.claudioed.port.inputs.CreateSubsidy;

@ApplicationScoped
public class SubsidyAggregate {

  private final SubsidyRepository subsidyRepository;

  public SubsidyAggregate(SubsidyRepository subsidyRepository) {
    this.subsidyRepository = subsidyRepository;
  }

  @Transactional
  public Subsidy createSubsidy(CreateSubsidy request){
    var subsidy = new Subsidy(request.getPeriod(),request.getRate(),request.getTargets(),request.getMaxTimeLoan(),request.getName());
    this.subsidyRepository.persist(subsidy);
    return subsidy;
  }

}
