package tech.claudioed.domain.dealer.specification;

import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.flat.specification.CustomerAllowedToUseFlat;
import tech.claudioed.domain.flat.specification.DealerAllowedToUseFlat;
import tech.claudioed.domain.flat.specification.ProductAllowedToUseFlat;
import tech.claudioed.domain.flat.specification.ProductFamilyAllowedToUseFlat;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

public class DealerFlatValidationContext extends AbstractSpecification<Flat> {

  private final DealerAllowedToUseFlat dealerAllowed;

  private final CustomerAllowedToUseFlat customerAllowed;

  private final ProductAllowedToUseFlat productAllowed;

  private final ProductFamilyAllowedToUseFlat productFamilyAllowed;

  public DealerFlatValidationContext(DealerId dealerId,CustomerId customerId, ProductId productId,ProductFamilyId productFamilyId) {
    this.dealerAllowed = new DealerAllowedToUseFlat(dealerId);
    this.customerAllowed = new CustomerAllowedToUseFlat(customerId);
    this.productAllowed = new ProductAllowedToUseFlat(productId);
    this.productFamilyAllowed = new ProductFamilyAllowedToUseFlat(productFamilyId);
  }

  @Override
  public boolean isSatisfiedBy(Flat flat) {
    var optional = this.productFamilyAllowed.or(this.productAllowed).or(this.customerAllowed).isSatisfiedBy(flat);
    var mandatory = this.dealerAllowed.isSatisfiedBy(flat);
    return optional && mandatory;
  }
}
