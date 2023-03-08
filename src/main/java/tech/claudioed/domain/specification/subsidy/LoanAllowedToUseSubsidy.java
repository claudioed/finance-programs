package tech.claudioed.domain.specification.subsidy;

import tech.claudioed.domain.Subsidy;
import tech.claudioed.domain.shared.Duration;
import tech.claudioed.domain.shared.specification.AbstractSpecification;

public class LoanAllowedToUseSubsidy extends AbstractSpecification<Subsidy> {

  private final Duration duration;

  public LoanAllowedToUseSubsidy(Duration duration) {
    this.duration = duration;
  }

  @Override
  public boolean isSatisfiedBy(Subsidy subsidy) {
    return true;
  }

}
