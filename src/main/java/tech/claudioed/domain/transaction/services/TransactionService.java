package tech.claudioed.domain.transaction.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.transaction.Transactional;
import tech.claudioed.domain.financecondition.repositories.FinanceConditionRepository;
import tech.claudioed.domain.transaction.ProvisioningSubsidy;
import tech.claudioed.domain.transaction.SubsidyId;
import tech.claudioed.domain.transaction.Transaction;
import tech.claudioed.domain.transaction.events.SubsidyProvisioned;
import tech.claudioed.domain.transaction.repositories.TransactionRepository;

@ApplicationScoped
public class TransactionService {

  private final TransactionRepository transactionRepository;

  private final FinanceConditionRepository financeConditionRepository;

  private final Event<SubsidyProvisioned> subsidyTrigger;

  public TransactionService(TransactionRepository transactionRepository,
      FinanceConditionRepository financeConditionRepository,
      Event<SubsidyProvisioned> subsidyTrigger) {
    this.transactionRepository = transactionRepository;
    this.financeConditionRepository = financeConditionRepository;
    this.subsidyTrigger = subsidyTrigger;
  }
  @Transactional
  public Transaction register(ProvisioningSubsidy provisioning){
    var fc = this.financeConditionRepository.get(provisioning.getFinanceConditionId().getId());
    var transaction = Transaction.newRegistered(provisioning.getFinanceConditionId(),new SubsidyId(fc.getFactorySubsidy().getId().toString()),provisioning.getApplication());
    this.transactionRepository.persist(transaction);
    this.subsidyTrigger.fire(new SubsidyProvisioned(provisioning.getFinanceConditionId(),new SubsidyId(fc.getFactorySubsidy().getId().toString()),provisioning.getApplication()));
    return transaction;
  }

}
