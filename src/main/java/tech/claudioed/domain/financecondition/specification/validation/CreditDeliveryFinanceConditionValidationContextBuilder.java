package tech.claudioed.domain.financecondition.specification.validation;

import javax.money.MonetaryAmount;
import tech.claudioed.domain.financecondition.FinanceCondition;
import tech.claudioed.port.inputs.DownPayment;

public class CreditDeliveryFinanceConditionValidationContextBuilder {

  private MonetaryAmount amount;
  private DownPayment downPayment;
  private FinanceCondition financeCondition;

  public CreditDeliveryFinanceConditionValidationContextBuilder amount(MonetaryAmount amount) {
    this.amount = amount;
    return this;
  }

  public CreditDeliveryFinanceConditionValidationContextBuilder downPayment(DownPayment downPayment) {
    this.downPayment = downPayment;
    return this;
  }

  public CreditDeliveryFinanceConditionValidationContextBuilder financeCondition(
      FinanceCondition financeCondition) {
    this.financeCondition = financeCondition;
    return this;
  }

  public CreditDeliveryFinanceConditionValidationContext build() {
    return new CreditDeliveryFinanceConditionValidationContext(amount, downPayment, financeCondition);
  }
}
