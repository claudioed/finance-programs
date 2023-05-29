package tech.claudioed.port.inputs.transaction;

import tech.claudioed.domain.analysis.FinanceConditionId;

public class ProvisioningSubsidyCommand {

  private CreditApplicationData application;

  private FinanceConditionId financeCondition;
  public CreditApplicationData getApplication() {
    return application;
  }

  public FinanceConditionId getFinanceCondition() {
    return financeCondition;
  }

}
