package tech.claudioed.domain.subsidy.services;

import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.money.MonetaryAmount;
import javax.transaction.Transactional;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.domain.subsidy.SubsidyBudget;
import tech.claudioed.domain.subsidy.SubsidyType;
import tech.claudioed.domain.subsidy.repositories.SubsidyRepository;
import tech.claudioed.port.inputs.subsidy.CreateSubsidy;

@ApplicationScoped
public class SubsidyService {

  private final SubsidyRepository subsidyRepository;

  public SubsidyService(SubsidyRepository subsidyRepository) {
    this.subsidyRepository = subsidyRepository;
  }

  @Transactional
  public Subsidy createSubsidy(CreateSubsidy request){
    var subsidy = new Subsidy(request.getPeriod(),request.getRate(),request.getTargets(),request.getMaxTimeLoan(),request.getName(),
        SubsidyType.FACTORY,request.getSegment());
    this.subsidyRepository.persist(subsidy);
    return subsidy;
  }

  @Transactional
  public SubsidyBudget registerBudget(String subsidyId,MonetaryAmount budget){
    Optional<Subsidy> optionalSubsidy = this.subsidyRepository.get(subsidyId);
    var newBudget = new SubsidyBudget(budget);
    optionalSubsidy.ifPresent(subsidy -> {
      subsidy.registerBudget(newBudget);
      this.subsidyRepository.persist(subsidy);
    });
    return newBudget;
  }

  public List<Subsidy> subsidies(){
    return this.subsidyRepository.listAll();
  }

}
