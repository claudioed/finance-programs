package tech.claudioed.domain.flat.specification.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import tech.claudioed.domain.financecondition.specification.validation.CreditDeliveryFinanceConditionValidationMessages;
import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.flat.specification.CustomerAllowedToUseFlat;
import tech.claudioed.domain.flat.specification.DealerAllowedToUseFlat;
import tech.claudioed.domain.flat.specification.LoanAllowedToUseFlat;
import tech.claudioed.domain.flat.specification.MarketSegmentAllowedToUseFlat;
import tech.claudioed.domain.flat.specification.ProductAllowedToUseFlat;
import tech.claudioed.domain.flat.specification.ProductFamilyAllowedToUseFlat;
import tech.claudioed.domain.shared.LoanTime;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.domain.shared.context.EvaluationContext;
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

  private final Set<EvaluationContext> evaluationContexts = new HashSet<>();

  CreditDeliveryFlatValidationContext(DealerId dealerId,CustomerId customerId,ProductId productId, ProductFamilyId productFamilyId,
      MarketSegment segment, LoanTime loanTime, Flat flat) {
    this.flat = flat;
    this.dealerAllowed = new DealerAllowedToUseFlat(dealerId);
    this.loanAllowed = new LoanAllowedToUseFlat(loanTime);
    this.customerAllowed = new CustomerAllowedToUseFlat(customerId);
    this.productAllowed = new ProductAllowedToUseFlat(productId);
    this.productFamilyAllowed = new ProductFamilyAllowedToUseFlat(productFamilyId);
    this.marketSegmentAllowedToUseFlat = new MarketSegmentAllowedToUseFlat(segment);
    evaluationContexts.add(new EvaluationContext("dealer-allowed",this.dealerAllowed.isSatisfiedBy(this.flat),CreditDeliveryFinanceConditionValidationMessages.DEALER_NOT_ALLOWED.message(), this.dealerAllowed.isSatisfiedBy(this.flat) ? 1 : 0));
    evaluationContexts.add(new EvaluationContext("customer-allowed",this.customerAllowed.isSatisfiedBy(this.flat),CreditDeliveryFinanceConditionValidationMessages.CUSTOMER_NOT_ALLOWED.message(), this.customerAllowed.isSatisfiedBy(this.flat) ? 1 : 0));
    evaluationContexts.add(new EvaluationContext("product-allowed",this.productAllowed.isSatisfiedBy(this.flat),CreditDeliveryFinanceConditionValidationMessages.PRODUCT_NOT_ALLOWED.message(), this.productAllowed.isSatisfiedBy(this.flat) ? 1 : 0));
    evaluationContexts.add(new EvaluationContext("product-family-allowed",this.productFamilyAllowed.isSatisfiedBy(this.flat),CreditDeliveryFinanceConditionValidationMessages.PRODUCT_FAMILY_NOT_ALLOWED.message(), this.productFamilyAllowed.isSatisfiedBy(this.flat) ? 1 : 0));
    evaluationContexts.add(new EvaluationContext("market-segment",this.marketSegmentAllowedToUseFlat.isSatisfiedBy(this.flat),CreditDeliveryFinanceConditionValidationMessages.MARKET_SEGMENT_NOT_ALLOWED.message(), this.marketSegmentAllowedToUseFlat.isSatisfiedBy(this.flat) ? 1 : 0));

  }

  public boolean isSatisfied() {
    var products = this.productFamilyAllowed.or(this.productAllowed).isSatisfiedBy(flat);
    var actors = this.dealerAllowed.and(this.loanAllowed).and(this.marketSegmentAllowedToUseFlat)
        .and(this.customerAllowed).isSatisfiedBy(flat);
    return products && actors;
  }

  public int points(){
    return this.evaluationContexts.stream().flatMapToInt(ec -> IntStream.of(ec.point())).sum();
  }

  public List<String> messages(){
    return this.evaluationContexts.stream().filter(ec -> !ec.success()).map(
        EvaluationContext::message).toList();
  }

  public Flat getFlat() {
    return flat;
  }

}
