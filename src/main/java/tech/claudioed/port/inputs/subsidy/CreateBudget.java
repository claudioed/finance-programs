package tech.claudioed.port.inputs.subsidy;

import tech.claudioed.domain.shared.Amount;

public class CreateBudget {

  private Amount budget;

  public void setBudget(Amount budget) {
    this.budget = budget;
  }
  public Amount getBudget() {
    return budget;
  }

}
