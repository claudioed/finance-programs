package tech.claudioed.domain.subsidy.specification;

import tech.claudioed.domain.shared.LoanTime;
import tech.claudioed.domain.shared.nullable.NullableLoanTime;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.domain.subsidy.Subsidy;

public class LoanAllowedToUseSubsidy extends AbstractSpecification<Subsidy> {

  private final LoanTime duration;

  public LoanAllowedToUseSubsidy(LoanTime duration) {
    this.duration = duration;
  }

  @Override
  public boolean isSatisfiedBy(Subsidy subsidy) {
    if (this.duration instanceof NullableLoanTime){
      return true;
    }
    return subsidy.getMaxTimeLoan().withinRange(this.duration);
  }

}
