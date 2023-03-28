package tech.claudioed.domain.flat.specification;

import java.util.Objects;
import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.shared.helper.Constants;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.port.inputs.finance.CustomerId;

public class CustomerAllowedToUseFlat extends AbstractSpecification<Flat> {

  private final CustomerId customerId;

  public CustomerAllowedToUseFlat(CustomerId customerId) {
    this.customerId = customerId;
  }

  @Override
  public boolean isSatisfiedBy(Flat flat) {
    if (Objects.isNull(flat.getTargets())){
      return false;
    }
    return flat.getTargets().getCustomers().contains(Constants.WILDCARD)
        || flat.getTargets().getCustomers().contains(this.customerId.value());
  }

}
