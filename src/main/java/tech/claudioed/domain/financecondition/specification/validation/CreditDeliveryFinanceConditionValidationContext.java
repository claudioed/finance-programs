package tech.claudioed.domain.financecondition.specification.validation;

import java.util.Optional;
import javax.money.MonetaryAmount;
import tech.claudioed.domain.financecondition.FinanceCondition;
import tech.claudioed.domain.financecondition.specification.AmountAllowed;
import tech.claudioed.domain.financecondition.specification.MeetDownPaymentRequirements;
import tech.claudioed.domain.financecondition.specification.UtmCodeAllowed;
import tech.claudioed.port.inputs.DownPayment;

public class CreditDeliveryFinanceConditionValidationContext {

  private final FinanceCondition condition;

  private final MeetDownPaymentRequirements downPaymentRequirements;

  private final AmountAllowed amountAllowed;

  private final UtmCodeAllowed utmCodeAllowed;

  public CreditDeliveryFinanceConditionValidationContext(MonetaryAmount amount, DownPayment downPayment, FinanceCondition financeCondition) {
    this.condition = financeCondition;
    this.downPaymentRequirements = new MeetDownPaymentRequirements(downPayment.getPercent(),downPayment.getFirstInstallment());
    this.amountAllowed = new AmountAllowed(amount);
    this.utmCodeAllowed = new UtmCodeAllowed(Optional.ofNullable(financeCondition.getUtm()));
  }

  public boolean isSatisfied() {
    return this.downPaymentRequirements.isSatisfiedBy(this.condition) && this.utmCodeAllowed.isSatisfiedBy(this.condition) &&
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
