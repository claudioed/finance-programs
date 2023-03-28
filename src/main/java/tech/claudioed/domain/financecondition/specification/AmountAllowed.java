package tech.claudioed.domain.financecondition.specification;

import javax.money.MonetaryAmount;
import tech.claudioed.domain.financecondition.FinanceCondition;
import tech.claudioed.domain.shared.specification.AbstractSpecification;

public class AmountAllowed extends AbstractSpecification<FinanceCondition> {

  private final MonetaryAmount loanAmount;

  public AmountAllowed(MonetaryAmount loanAmount) {
    this.loanAmount = loanAmount;
  }

  @Override
  public boolean isSatisfiedBy(FinanceCondition financeCondition) {
    return financeCondition.getMaxAmount().compareTo(this.loanAmount) > 0;
  }

}
