package tech.claudioed.domain.dealer.specification;

import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.domain.subsidy.specification.CustomerAllowedToUseSubsidy;
import tech.claudioed.domain.subsidy.specification.DealerAllowedToUseSubsidy;
import tech.claudioed.domain.subsidy.specification.ProductAllowedToUseSubsidy;
import tech.claudioed.domain.subsidy.specification.ProductFamilyAllowedToUseSubsidy;
import tech.claudioed.domain.shared.ids.CustomerId;
import tech.claudioed.domain.shared.ids.DealerId;
import tech.claudioed.domain.shared.ids.ProductFamilyId;
import tech.claudioed.domain.shared.ids.ProductId;

public class DealerSubsidyValidationContext extends AbstractSpecification<Subsidy> {

  private final CustomerAllowedToUseSubsidy customerAllowedToUseSubsidy;

  private final DealerAllowedToUseSubsidy dealerAllowedToUseSubsidy;

  private final ProductAllowedToUseSubsidy productAllowedToUseSubsidy;

  private final ProductFamilyAllowedToUseSubsidy productFamilyAllowedToUseSubsidy;


  public DealerSubsidyValidationContext(DealerId dealerId,CustomerId customerId, ProductId productId,ProductFamilyId productFamilyId) {
    this.dealerAllowedToUseSubsidy = new DealerAllowedToUseSubsidy(dealerId);
    this.customerAllowedToUseSubsidy = new CustomerAllowedToUseSubsidy(customerId);
    this.productAllowedToUseSubsidy = new ProductAllowedToUseSubsidy(productId);
    this.productFamilyAllowedToUseSubsidy = new ProductFamilyAllowedToUseSubsidy(productFamilyId);
  }
  @Override
  public boolean isSatisfiedBy(Subsidy subsidy) {
    var optional = this.productFamilyAllowedToUseSubsidy.or(this.productAllowedToUseSubsidy).or(this.customerAllowedToUseSubsidy).isSatisfiedBy(subsidy);
    var mandatory = this.dealerAllowedToUseSubsidy.isSatisfiedBy(subsidy);
    return optional && mandatory;
  }

}
