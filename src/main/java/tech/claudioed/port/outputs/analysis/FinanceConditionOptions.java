package tech.claudioed.port.outputs.analysis;

import java.util.Set;

public class FinanceConditionOptions {

  private Set<String> financeConditionIds;

  public FinanceConditionOptions(){}

  public FinanceConditionOptions(Set<String> financeConditionIds) {
    this.financeConditionIds = financeConditionIds;
  }

  public Set<String> getFinanceConditionIds() {
    return financeConditionIds;
  }

}
