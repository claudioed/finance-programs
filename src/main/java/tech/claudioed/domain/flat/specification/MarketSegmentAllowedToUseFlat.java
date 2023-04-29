package tech.claudioed.domain.flat.specification;

import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.domain.shared.specification.AbstractSpecification;

public class MarketSegmentAllowedToUseFlat extends AbstractSpecification<Flat> {

  private final MarketSegment segment;

  public MarketSegmentAllowedToUseFlat(MarketSegment segment) {
    this.segment = segment;
  }

  @Override
  public boolean isSatisfiedBy(Flat flat) {
    return flat.getSegment().equals(this.segment);
  }

}
