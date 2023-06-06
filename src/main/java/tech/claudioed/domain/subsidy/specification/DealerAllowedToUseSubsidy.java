package tech.claudioed.domain.subsidy.specification;

import java.util.Objects;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.domain.shared.helper.Constants;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.domain.shared.ids.DealerId;

public class DealerAllowedToUseSubsidy extends AbstractSpecification<Subsidy> {

  private final DealerId dealerId;

  public DealerAllowedToUseSubsidy(DealerId dealerId) {
    this.dealerId = dealerId;
  }

  @Override
  public boolean isSatisfiedBy(Subsidy subsidy) {
    if (Objects.isNull(subsidy.getTarget().getDealers())){
      return false;
    }
    return subsidy.getTarget().getDealers().contains(Constants.WILDCARD) ||
        subsidy.getTarget().getDealers().contains(dealerId.value());
  }

}
