package tech.claudioed.domain.flat.specification;

import java.util.Objects;
import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.shared.helper.Constants;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.domain.shared.ids.DealerId;

public class DealerAllowedToUseFlat extends AbstractSpecification<Flat> {

  private final DealerId dealerId;

  public DealerAllowedToUseFlat(DealerId dealerId) {
    this.dealerId = dealerId;
  }

  @Override
  public boolean isSatisfiedBy(Flat flat) {
    if (Objects.isNull(flat.getTargets().getDealers())){
      return false;
    }
    return flat.getTargets().getDealers().contains(Constants.WILDCARD)
        || flat.getTargets().getDealers().contains(dealerId.value());
  }

}
