package tech.claudioed.domain.specification.flat;

import java.util.Objects;
import tech.claudioed.domain.Flat;
import tech.claudioed.domain.helper.Constants;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.port.inputs.finance.ProductId;

public class ProductAllowedToUseFlat extends AbstractSpecification<Flat> {

  private final ProductId productId;

  public ProductAllowedToUseFlat(ProductId productId) {
    this.productId = productId;
  }

  @Override
  public boolean isSatisfiedBy(Flat flat) {
    if (Objects.isNull(flat.getTargets().getProducts())){
      return false;
    }
    return flat.getTargets().getProducts().contains(Constants.WILDCARD) ||
        flat.getTargets().getProducts().contains(productId.value());
  }

}
