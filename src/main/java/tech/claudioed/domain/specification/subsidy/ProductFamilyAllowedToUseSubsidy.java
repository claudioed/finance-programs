package tech.claudioed.domain.specification.subsidy;

import java.util.Objects;
import tech.claudioed.domain.Subsidy;
import tech.claudioed.domain.helper.Constants;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.port.inputs.finance.ProductFamilyId;

public class ProductFamilyAllowedToUseSubsidy extends AbstractSpecification<Subsidy> {

  private final ProductFamilyId productFamilyId;

  public ProductFamilyAllowedToUseSubsidy(ProductFamilyId productFamilyId) {
    this.productFamilyId = productFamilyId;
  }

  @Override
  public boolean isSatisfiedBy(Subsidy subsidy) {
    if (Objects.isNull(subsidy.getTarget().getProductFamilies())){
      return false;
    }
    return subsidy.getTarget().getProductFamilies().contains(Constants.WILDCARD) ||
        subsidy.getTarget().getProductFamilies().contains(productFamilyId.value());
  }

}
