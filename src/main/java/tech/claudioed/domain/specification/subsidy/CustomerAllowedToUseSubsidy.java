package tech.claudioed.domain.specification.subsidy;

import java.util.Objects;
import tech.claudioed.domain.Subsidy;
import tech.claudioed.domain.helper.Constants;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.port.inputs.finance.CustomerId;

public class CustomerAllowedToUseSubsidy extends AbstractSpecification<Subsidy> {

  private final CustomerId customerId;

  public CustomerAllowedToUseSubsidy(CustomerId customerId) {
    this.customerId = customerId;
  }

  @Override
  public boolean isSatisfiedBy(Subsidy subsidy) {
    if (Objects.isNull(subsidy.getTarget().getCustomers())){
      return false;
    }
    return subsidy.getTarget().getCustomers().contains(Constants.WILDCARD) ||
        subsidy.getTarget().getCustomers().contains(customerId.value());
  }

}
