package tech.claudioed.domain.specification.flat;

import tech.claudioed.domain.Flat;
import tech.claudioed.domain.shared.Duration;
import tech.claudioed.domain.shared.specification.AbstractSpecification;

public class LoanAllowedToUseFlat extends AbstractSpecification<Flat> {

  private final Duration duration;

  public LoanAllowedToUseFlat(Duration duration) {
    this.duration = duration;
  }


  @Override
  public boolean isSatisfiedBy(Flat flat) {
    return true;
  }

}
