package tech.claudioed.domain.subsidy.specification.validation;

import tech.claudioed.domain.shared.LoanTime;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.port.inputs.finance.CultureId;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

public class CreditDeliverySubsidyValidationContextBuilder {

  private DealerId dealerId;
  private CustomerId customerId;
  private ProductId productId;
  private ProductFamilyId productFamilyId;
  private CultureId cultureId;
  private MarketSegment segment;
  private LoanTime loanTime;
  private Subsidy subsidy;

  public CreditDeliverySubsidyValidationContextBuilder dealerId(DealerId dealerId) {
    this.dealerId = dealerId;
    return this;
  }

  public CreditDeliverySubsidyValidationContextBuilder customerId(CustomerId customerId) {
    this.customerId = customerId;
    return this;
  }

  public CreditDeliverySubsidyValidationContextBuilder productId(ProductId productId) {
    this.productId = productId;
    return this;
  }

  public CreditDeliverySubsidyValidationContextBuilder productFamilyId(
      ProductFamilyId productFamilyId) {
    this.productFamilyId = productFamilyId;
    return this;
  }

  public CreditDeliverySubsidyValidationContextBuilder cultureId(CultureId cultureId) {
    this.cultureId = cultureId;
    return this;
  }

  public CreditDeliverySubsidyValidationContextBuilder segment(MarketSegment segment) {
    this.segment = segment;
    return this;
  }

  public CreditDeliverySubsidyValidationContextBuilder loanTime(LoanTime loanTime) {
    this.loanTime = loanTime;
    return this;
  }

  public CreditDeliverySubsidyValidationContextBuilder subsidy(Subsidy subsidy) {
    this.subsidy = subsidy;
    return this;
  }

  public CreditDeliverySubsidyValidationContext build() {
    return new CreditDeliverySubsidyValidationContext(dealerId, customerId, productId,
        productFamilyId, cultureId, segment, loanTime, subsidy);
  }
}
