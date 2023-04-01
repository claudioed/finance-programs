package tech.claudioed.domain.financecondition.specification;

import tech.claudioed.domain.financecondition.FinanceCondition;
import tech.claudioed.port.inputs.FinanceProgramQuery;

public class FinanceConditionValidationContext {

  private final FinanceProgramQuery request;

  private final FinanceCondition condition;

  private final MeetDownPaymentRequirements downPaymentRequirements;

  private final AmountAllowed amountAllowed;

  public FinanceConditionValidationContext(FinanceProgramQuery request, FinanceCondition financeCondition) {
    this.request = request;
    this.condition = financeCondition;
    this.downPaymentRequirements = new MeetDownPaymentRequirements(request.getDownPayment().getPercent(),request.getDownPayment().getFirstInstallment());
    this.amountAllowed = new AmountAllowed(request.amount());
  }

  public boolean isSatisfied() {
    return this.downPaymentRequirements.isSatisfiedBy(this.condition) &&
        this.amountAllowed.isSatisfiedBy(this.condition);
  }

  public int points(){
    int points = 0;
    points+= this.downPaymentRequirements.isSatisfiedBy(this.condition) ? 1 : 0;
    return points;
  }

  public FinanceCondition getCondition() {
    return condition;
  }

}
