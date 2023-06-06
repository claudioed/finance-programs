package tech.claudioed.domain.subsidy.specification.validation;

import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.domain.shared.ids.CultureId;
import tech.claudioed.domain.shared.ids.CustomerId;
import tech.claudioed.domain.shared.ids.DealerId;
import tech.claudioed.domain.shared.ids.ProductFamilyId;
import tech.claudioed.domain.shared.ids.ProductId;

public class DealersSubsidyValidationContextBuilder {

  private DealerId dealerId;
  private CustomerId customerId;
  private ProductId productId;
  private ProductFamilyId productFamilyId;
  private CultureId cultureId;
  private MarketSegment segment;
  private Subsidy subsidy;

  public DealersSubsidyValidationContextBuilder dealerId(DealerId dealerId) {
    this.dealerId = dealerId;
    return this;
  }

  public DealersSubsidyValidationContextBuilder customerId(CustomerId customerId) {
    this.customerId = customerId;
    return this;
  }

  public DealersSubsidyValidationContextBuilder productId(ProductId productId) {
    this.productId = productId;
    return this;
  }

  public DealersSubsidyValidationContextBuilder productFamilyId(
      ProductFamilyId productFamilyId) {
    this.productFamilyId = productFamilyId;
    return this;
  }

  public DealersSubsidyValidationContextBuilder cultureId(CultureId cultureId) {
    this.cultureId = cultureId;
    return this;
  }

  public DealersSubsidyValidationContextBuilder segment(MarketSegment segment) {
    this.segment = segment;
    return this;
  }

  public DealersSubsidyValidationContextBuilder subsidy(Subsidy subsidy) {
    this.subsidy = subsidy;
    return this;
  }

  public DealersSubsidyValidationContext build() {
    return new DealersSubsidyValidationContext(dealerId, customerId, productId, productFamilyId,
        cultureId, segment, subsidy);
  }
}
