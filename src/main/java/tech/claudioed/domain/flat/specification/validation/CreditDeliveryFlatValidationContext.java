package tech.claudioed.domain.flat.specification.validation;

import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.flat.specification.CustomerAllowedToUseFlat;
import tech.claudioed.domain.flat.specification.DealerAllowedToUseFlat;
import tech.claudioed.domain.flat.specification.LoanAllowedToUseFlat;
import tech.claudioed.domain.flat.specification.MarketSegmentAllowedToUseFlat;
import tech.claudioed.domain.flat.specification.ProductAllowedToUseFlat;
import tech.claudioed.domain.flat.specification.ProductFamilyAllowedToUseFlat;
import tech.claudioed.domain.shared.LoanTime;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

public class CreditDeliveryFlatValidationContext {

  private final Flat flat;

  private final DealerAllowedToUseFlat dealerAllowed;

  private final LoanAllowedToUseFlat loanAllowed;

  private final CustomerAllowedToUseFlat customerAllowed;

  private final ProductAllowedToUseFlat productAllowed;

  private final ProductFamilyAllowedToUseFlat productFamilyAllowed;

  private final MarketSegmentAllowedToUseFlat marketSegmentAllowedToUseFlat;

  CreditDeliveryFlatValidationContext(DealerId dealerId,CustomerId customerId,ProductId productId, ProductFamilyId productFamilyId,
      MarketSegment segment, LoanTime loanTime, Flat flat) {
    this.flat = flat;
    this.dealerAllowed = new DealerAllowedToUseFlat(dealerId);
    this.loanAllowed = new LoanAllowedToUseFlat(loanTime);
    this.customerAllowed = new CustomerAllowedToUseFlat(customerId);
    this.productAllowed = new ProductAllowedToUseFlat(productId);
    this.productFamilyAllowed = new ProductFamilyAllowedToUseFlat(productFamilyId);
    this.marketSegmentAllowedToUseFlat = new MarketSegmentAllowedToUseFlat(segment);
  }

  public boolean isSatisfied() {
    var products = this.productFamilyAllowed.or(this.productAllowed).isSatisfiedBy(flat);
    var actors = this.dealerAllowed.and(this.loanAllowed).and(this.marketSegmentAllowedToUseFlat)
        .and(this.customerAllowed).isSatisfiedBy(flat);
    return products && actors;
  }

  public int points(){
    int points = 0;
    points+= this.dealerAllowed.isSatisfiedBy(flat) ? 1 : 0;
    points+= this.loanAllowed.isSatisfiedBy(flat) ? 1 : 0;
    points+= this.customerAllowed.isSatisfiedBy(flat) ? 1 : 0;
    points+= this.productAllowed.isSatisfiedBy(flat) ? 1 : 0;
    points+= this.productFamilyAllowed.isSatisfiedBy(flat) ? 1 : 0;
    return points;
  }

  public Flat getFlat() {
    return flat;
  }

}
