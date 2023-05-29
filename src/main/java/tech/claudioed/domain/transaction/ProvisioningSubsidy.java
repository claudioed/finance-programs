package tech.claudioed.domain.transaction;

import tech.claudioed.domain.analysis.FinanceConditionId;

public class ProvisioningSubsidy {

   private CreditApplication application;

   private FinanceConditionId financeConditionId;

  public ProvisioningSubsidy() {
  }

  public CreditApplication getApplication() {
    return application;
  }

  public FinanceConditionId getFinanceConditionId() {
    return financeConditionId;
  }
}
