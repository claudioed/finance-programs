package tech.claudioed.domain.subsidy.specification;

import tech.claudioed.domain.shared.LoanTime;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.domain.subsidy.Subsidy;

public class LoanAllowedToUseSubsidy extends AbstractSpecification<Subsidy> {

  private final LoanTime duration;

  public LoanAllowedToUseSubsidy(LoanTime duration) {
    this.duration = duration;
  }

  @Override
  public boolean isSatisfiedBy(Subsidy subsidy) {
    return subsidy.getMaxTimeLoan().withinRange(this.duration);
  }

}
