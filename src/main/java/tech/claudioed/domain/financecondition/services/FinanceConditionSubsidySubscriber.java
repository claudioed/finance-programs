package tech.claudioed.domain.financecondition.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;
import tech.claudioed.domain.financecondition.repositories.FinanceConditionRepository;
import tech.claudioed.domain.transaction.events.SubsidyProvisioned;

@ApplicationScoped
public class FinanceConditionSubsidySubscriber {

  private final FinanceConditionRepository financeConditionRepository;

  public FinanceConditionSubsidySubscriber(FinanceConditionRepository financeConditionRepository) {
    this.financeConditionRepository = financeConditionRepository;
  }

  public void handleSubsidyProvisioned(@ObservesAsync SubsidyProvisioned event){
    var fc = this.financeConditionRepository.get(event.financeCondition().getId());
    fc.handleProvisioning(event);
    this.financeConditionRepository.persist(fc);
  }

}
