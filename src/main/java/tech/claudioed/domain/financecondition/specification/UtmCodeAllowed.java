package tech.claudioed.domain.financecondition.specification;

import io.quarkus.runtime.util.StringUtil;
import java.util.Optional;
import tech.claudioed.domain.financecondition.FinanceCondition;
import tech.claudioed.domain.shared.specification.AbstractSpecification;

public class UtmCodeAllowed extends AbstractSpecification<FinanceCondition> {

  private final Optional<String> utm;

  public UtmCodeAllowed(Optional<String> utm) {
    this.utm = utm;
  }

  @Override
  public boolean isSatisfiedBy(FinanceCondition financeCondition) {
    return this.utm.map(s -> financeCondition.getUtm().equals(s))
        .orElseGet(() -> StringUtil.isNullOrEmpty(financeCondition.getUtm()));
  }

}
