package tech.claudioed.domain.analysis.specification;

import java.time.LocalDate;
import tech.claudioed.domain.financecondition.FinanceCondition;
import tech.claudioed.domain.shared.specification.AbstractSpecification;

public class ContractDateIsValid extends AbstractSpecification<FinanceCondition> {

  private final LocalDate creditApplicationContractDate;

  public ContractDateIsValid(LocalDate creditApplicationContractDate) {
    this.creditApplicationContractDate = creditApplicationContractDate;
  }
  @Override
  public boolean isSatisfiedBy(FinanceCondition financeCondition) {
    return financeCondition.getContractingLimit().isBetween(this.creditApplicationContractDate);
  }

}
