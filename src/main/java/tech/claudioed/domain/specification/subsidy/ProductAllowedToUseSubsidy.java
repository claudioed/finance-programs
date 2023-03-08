package tech.claudioed.domain.specification.subsidy;

import java.util.Objects;
import tech.claudioed.domain.Subsidy;
import tech.claudioed.domain.helper.Constants;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.port.inputs.finance.ProductId;

public class ProductAllowedToUseSubsidy extends AbstractSpecification<Subsidy> {

  private final ProductId productId;

  public ProductAllowedToUseSubsidy(ProductId productId) {
    this.productId = productId;
  }

  @Override
  public boolean isSatisfiedBy(Subsidy subsidy) {
    if (Objects.isNull(subsidy.getTarget().getProducts())){
      return false;
    }

    return subsidy.getTarget().getProducts().contains(Constants.WILDCARD) ||
        subsidy.getTarget().getProducts().contains(productId.value());
  }

}
