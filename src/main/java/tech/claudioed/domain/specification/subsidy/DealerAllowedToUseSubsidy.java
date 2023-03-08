package tech.claudioed.domain.specification.subsidy;

import java.util.Objects;
import tech.claudioed.domain.Subsidy;
import tech.claudioed.domain.helper.Constants;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.port.inputs.finance.DealerId;

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
