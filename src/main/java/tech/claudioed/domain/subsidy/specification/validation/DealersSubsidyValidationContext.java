package tech.claudioed.domain.subsidy.specification.validation;

import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.domain.subsidy.specification.CultureAllowedToUseSubsidy;
import tech.claudioed.domain.subsidy.specification.CustomerAllowedToUseSubsidy;
import tech.claudioed.domain.subsidy.specification.DealerAllowedToUseSubsidy;
import tech.claudioed.domain.subsidy.specification.MarketSegmentAllowedToUseSubsidy;
import tech.claudioed.domain.subsidy.specification.ProductAllowedToUseSubsidy;
import tech.claudioed.domain.subsidy.specification.ProductFamilyAllowedToUseSubsidy;
import tech.claudioed.port.inputs.finance.CultureId;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

public class DealersSubsidyValidationContext {

  private final Subsidy subsidy;

  private final CustomerAllowedToUseSubsidy customerAllowedToUseSubsidy;

  private final DealerAllowedToUseSubsidy dealerAllowedToUseSubsidy;

  private final ProductAllowedToUseSubsidy productAllowedToUseSubsidy;

  private final ProductFamilyAllowedToUseSubsidy productFamilyAllowedToUseSubsidy;

  private final CultureAllowedToUseSubsidy cultureAllowedToUseSubsidy;

  private final MarketSegmentAllowedToUseSubsidy marketSegmentAllowedToUseSubsidy;

   public DealersSubsidyValidationContext(DealerId dealerId,CustomerId customerId,ProductId productId,ProductFamilyId productFamilyId,CultureId cultureId,
      MarketSegment segment, Subsidy subsidy) {
    this.subsidy = subsidy;
    this.dealerAllowedToUseSubsidy = new DealerAllowedToUseSubsidy(dealerId);
    this.customerAllowedToUseSubsidy = new CustomerAllowedToUseSubsidy(customerId);
    this.productAllowedToUseSubsidy = new ProductAllowedToUseSubsidy(productId);
    this.productFamilyAllowedToUseSubsidy = new ProductFamilyAllowedToUseSubsidy(productFamilyId);
    this.cultureAllowedToUseSubsidy = new CultureAllowedToUseSubsidy(cultureId);
    this.marketSegmentAllowedToUseSubsidy = new MarketSegmentAllowedToUseSubsidy(segment);
  }

  public boolean isSatisfied() {
    var products = this.productFamilyAllowedToUseSubsidy.or(this.productAllowedToUseSubsidy).isSatisfiedBy(this.subsidy);
    var actors = this.dealerAllowedToUseSubsidy.and(this.customerAllowedToUseSubsidy)
        .and(this.cultureAllowedToUseSubsidy).and(this.marketSegmentAllowedToUseSubsidy).isSatisfiedBy(this.subsidy);
    return products && actors;
  }

  public int points(){
    int points = 0;
    points+= this.dealerAllowedToUseSubsidy.isSatisfiedBy(this.subsidy) ? 1 : 0;
    points+= this.customerAllowedToUseSubsidy.isSatisfiedBy(this.subsidy) ? 1 : 0;
    points+= this.productAllowedToUseSubsidy.isSatisfiedBy(this.subsidy) ? 1 : 0;
    points+= this.productFamilyAllowedToUseSubsidy.isSatisfiedBy(this.subsidy) ? 1 : 0;
    return points;
  }

  public Subsidy getSubsidy() {
    return subsidy;
  }

}
