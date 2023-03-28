package tech.claudioed.domain.subsidy.services;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.domain.subsidy.SubsidyType;
import tech.claudioed.domain.subsidy.repositories.SubsidyRepository;
import tech.claudioed.port.inputs.CreateSubsidy;

@ApplicationScoped
public class SubsidyService {

  private final SubsidyRepository subsidyRepository;

  public SubsidyService(SubsidyRepository subsidyRepository) {
    this.subsidyRepository = subsidyRepository;
  }

  @Transactional
  public Subsidy createSubsidy(CreateSubsidy request){
    var subsidy = new Subsidy(request.getPeriod(),request.getRate(),request.getTargets(),request.getMaxTimeLoan(),request.getName(),
        SubsidyType.FACTORY);
    this.subsidyRepository.persist(subsidy);
    return subsidy;
  }

}
