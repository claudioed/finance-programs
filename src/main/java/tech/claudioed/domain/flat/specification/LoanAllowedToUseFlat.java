package tech.claudioed.domain.flat.specification;

import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.shared.Duration;
import tech.claudioed.domain.shared.LoanTime;
import tech.claudioed.domain.shared.specification.AbstractSpecification;

public class LoanAllowedToUseFlat extends AbstractSpecification<Flat> {

  private final LoanTime duration;

  public LoanAllowedToUseFlat(LoanTime duration) {
    this.duration = duration;
  }


  @Override
  public boolean isSatisfiedBy(Flat flat) {
    return true;
  }

}
