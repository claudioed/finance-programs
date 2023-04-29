package tech.claudioed.domain.flat.specification.validation;

import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.shared.LoanTime;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

public class CreditDeliveryFlatValidationContextBuilder {

  private DealerId dealerId;
  private CustomerId customerId;
  private ProductId productId;
  private ProductFamilyId productFamilyId;
  private MarketSegment segment;
  private LoanTime loanTime;
  private Flat flat;

  public CreditDeliveryFlatValidationContextBuilder dealerId(DealerId dealerId) {
    this.dealerId = dealerId;
    return this;
  }

  public CreditDeliveryFlatValidationContextBuilder customerId(CustomerId customerId) {
    this.customerId = customerId;
    return this;
  }

  public CreditDeliveryFlatValidationContextBuilder productId(ProductId productId) {
    this.productId = productId;
    return this;
  }

  public CreditDeliveryFlatValidationContextBuilder productFamilyId(
      ProductFamilyId productFamilyId) {
    this.productFamilyId = productFamilyId;
    return this;
  }

  public CreditDeliveryFlatValidationContextBuilder segment(MarketSegment segment) {
    this.segment = segment;
    return this;
  }

  public CreditDeliveryFlatValidationContextBuilder loanTime(LoanTime loanTime) {
    this.loanTime = loanTime;
    return this;
  }

  public CreditDeliveryFlatValidationContextBuilder flat(Flat flat) {
    this.flat = flat;
    return this;
  }

  public CreditDeliveryFlatValidationContext build() {
    return new CreditDeliveryFlatValidationContext(dealerId, customerId, productId, productFamilyId,
        segment, loanTime, flat);
  }
}
