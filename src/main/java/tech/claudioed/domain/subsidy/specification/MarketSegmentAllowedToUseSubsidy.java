package tech.claudioed.domain.subsidy.specification;

import java.util.Objects;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.domain.shared.helper.Constants;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.port.inputs.finance.CultureId;

public class MarketSegmentAllowedToUseSubsidy extends AbstractSpecification<Subsidy> {

  private final MarketSegment segment;

  public MarketSegmentAllowedToUseSubsidy(MarketSegment segment) {
    this.segment = segment;
  }

  @Override
  public boolean isSatisfiedBy(Subsidy subsidy) {
    return subsidy.getSegment().equals(this.segment);
  }

}
