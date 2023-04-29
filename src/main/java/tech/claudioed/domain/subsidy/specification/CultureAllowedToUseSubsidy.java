package tech.claudioed.domain.subsidy.specification;

import java.util.Objects;
import tech.claudioed.domain.shared.helper.Constants;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.port.inputs.finance.CultureId;

public class CultureAllowedToUseSubsidy extends AbstractSpecification<Subsidy> {

  private final CultureId cultureId;

  public CultureAllowedToUseSubsidy(CultureId cultureId) {
    this.cultureId = cultureId;
  }

  @Override
  public boolean isSatisfiedBy(Subsidy subsidy) {
    if (Objects.isNull(subsidy.getTarget().getCultures())){
      return false;
    }
    return subsidy.getTarget().getCultures().contains(Constants.WILDCARD) ||
        subsidy.getTarget().getCultures().contains(cultureId.value());
  }

}
