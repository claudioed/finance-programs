package tech.claudioed.domain.flat.specification.validation;

import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

public class DealersFlatValidationContextBuilder {

  private DealerId dealerId;
  private CustomerId customerId;
  private ProductId productId;
  private ProductFamilyId productFamilyId;
  private MarketSegment segment;
  private Flat flat;

  public DealersFlatValidationContextBuilder dealerId(DealerId dealerId) {
    this.dealerId = dealerId;
    return this;
  }

  public DealersFlatValidationContextBuilder customerId(CustomerId customerId) {
    this.customerId = customerId;
    return this;
  }

  public DealersFlatValidationContextBuilder productId(ProductId productId) {
    this.productId = productId;
    return this;
  }

  public DealersFlatValidationContextBuilder productFamilyId(ProductFamilyId productFamilyId) {
    this.productFamilyId = productFamilyId;
    return this;
  }

  public DealersFlatValidationContextBuilder segment(MarketSegment segment) {
    this.segment = segment;
    return this;
  }

  public DealersFlatValidationContextBuilder flat(Flat flat) {
    this.flat = flat;
    return this;
  }

  public DealersFlatValidationContext build() {
    return new DealersFlatValidationContext(dealerId, customerId, productId, productFamilyId,
        segment, flat);
  }
}
