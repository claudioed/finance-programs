package tech.claudioed.domain.subsidy.specification;

import java.util.Objects;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.domain.shared.helper.Constants;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.domain.shared.ids.ProductId;

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
