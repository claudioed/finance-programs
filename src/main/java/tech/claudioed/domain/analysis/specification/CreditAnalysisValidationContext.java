package tech.claudioed.domain.analysis.specification;

import tech.claudioed.domain.financecondition.FinanceCondition;
import tech.claudioed.port.inputs.analysis.CreditApplicationAnalysisRequest;

public class CreditAnalysisValidationContext {

  private final CreditApplicationAnalysisRequest query;

  private final FinanceCondition financeCondition;

  private final ContractDateIsValid contractDateIsValid;


  public CreditAnalysisValidationContext(CreditApplicationAnalysisRequest query,
      FinanceCondition financeCondition) {
    this.query = query;
    this.financeCondition = financeCondition;
    this.contractDateIsValid = new ContractDateIsValid(this.query.getContractDate());
  }

  public boolean isSatisfied() {
    return this.contractDateIsValid.isSatisfiedBy(this.financeCondition);
  }

}
