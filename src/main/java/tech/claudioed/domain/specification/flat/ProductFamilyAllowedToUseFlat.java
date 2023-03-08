package tech.claudioed.domain.specification.flat;

import java.util.Objects;
import tech.claudioed.domain.Flat;
import tech.claudioed.domain.helper.Constants;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.port.inputs.finance.ProductFamilyId;

public class ProductFamilyAllowedToUseFlat extends AbstractSpecification<Flat> {

  private final ProductFamilyId productFamilyId;

  public ProductFamilyAllowedToUseFlat(ProductFamilyId productFamilyId) {
    this.productFamilyId = productFamilyId;
  }

  @Override
  public boolean isSatisfiedBy(Flat flat) {
    if (Objects.isNull(flat.getTargets().getProductFamilies())){
      return false;
    }
    return flat.getTargets().getProductFamilies().contains(Constants.WILDCARD) ||
        flat.getTargets().getProductFamilies().contains(productFamilyId.value());
  }

}
