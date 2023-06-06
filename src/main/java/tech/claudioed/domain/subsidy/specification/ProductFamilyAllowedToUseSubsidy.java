package tech.claudioed.domain.subsidy.specification;

import java.util.Objects;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.domain.shared.helper.Constants;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.domain.shared.ids.ProductFamilyId;

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
