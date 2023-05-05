package tech.claudioed.domain.financecondition.specification.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import javax.money.MonetaryAmount;
import tech.claudioed.domain.financecondition.FinanceCondition;
import tech.claudioed.domain.financecondition.specification.AmountAllowed;
import tech.claudioed.domain.financecondition.specification.MeetDownPaymentRequirements;
import tech.claudioed.domain.financecondition.specification.UtmCodeAllowed;
import tech.claudioed.domain.shared.context.EvaluationContext;
import tech.claudioed.port.inputs.DownPayment;

public class CreditDeliveryFinanceConditionValidationContext {

  private final FinanceCondition condition;

  private final MeetDownPaymentRequirements downPaymentRequirements;

  private final AmountAllowed amountAllowed;

  private final UtmCodeAllowed utmCodeAllowed;

  private final Set<EvaluationContext> evaluationContexts = new HashSet<>();

  public CreditDeliveryFinanceConditionValidationContext(MonetaryAmount amount, DownPayment downPayment, FinanceCondition financeCondition) {
    this.condition = financeCondition;
    this.downPaymentRequirements = new MeetDownPaymentRequirements(downPayment.getPercent(),downPayment.getFirstInstallment());
    this.amountAllowed = new AmountAllowed(amount);
    this.utmCodeAllowed = new UtmCodeAllowed(Optional.ofNullable(financeCondition.getUtm()));
    evaluationContexts.add(new EvaluationContext("down-payment",this.downPaymentRequirements.isSatisfiedBy(this.condition),CreditDeliveryFinanceConditionValidationMessages.DOWN_PAYMENT_REQUIREMENTS.message(), this.downPaymentRequirements.isSatisfiedBy(this.condition) ? 1 : 0));
    evaluationContexts.add(new EvaluationContext("amount-allowed",this.amountAllowed.isSatisfiedBy(this.condition),CreditDeliveryFinanceConditionValidationMessages.AMOUNT_NOT_ALLOWED.message(), this.amountAllowed.isSatisfiedBy(this.condition) ? 1 : 0));
    evaluationContexts.add(new EvaluationContext("utm-code-allowed",this.utmCodeAllowed.isSatisfiedBy(this.condition),CreditDeliveryFinanceConditionValidationMessages.UTM_CODE_NOT_ALLOWED.message(), this.utmCodeAllowed.isSatisfiedBy(this.condition) ? 1 : 0));
  }

  public boolean isSatisfied() {
    return this.downPaymentRequirements.isSatisfiedBy(this.condition) && this.utmCodeAllowed.isSatisfiedBy(this.condition) &&
        this.amountAllowed.isSatisfiedBy(this.condition);
  }

  public int points(){
    return this.evaluationContexts.stream().flatMapToInt(ec -> IntStream.of(ec.point())).sum();
  }

  public List<String> messages(){
    return this.evaluationContexts.stream().filter(ec -> !ec.success()).map(
        EvaluationContext::message).toList();
  }

}
