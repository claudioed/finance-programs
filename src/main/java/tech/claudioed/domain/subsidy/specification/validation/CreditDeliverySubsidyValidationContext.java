package tech.claudioed.domain.subsidy.specification.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import tech.claudioed.domain.financecondition.specification.validation.CreditDeliveryFinanceConditionValidationMessages;
import tech.claudioed.domain.shared.LoanTime;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.domain.shared.context.EvaluationContext;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.domain.subsidy.specification.CultureAllowedToUseSubsidy;
import tech.claudioed.domain.subsidy.specification.CustomerAllowedToUseSubsidy;
import tech.claudioed.domain.subsidy.specification.DealerAllowedToUseSubsidy;
import tech.claudioed.domain.subsidy.specification.LoanAllowedToUseSubsidy;
import tech.claudioed.domain.subsidy.specification.MarketSegmentAllowedToUseSubsidy;
import tech.claudioed.domain.subsidy.specification.ProductAllowedToUseSubsidy;
import tech.claudioed.domain.subsidy.specification.ProductFamilyAllowedToUseSubsidy;
import tech.claudioed.port.inputs.finance.CultureId;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

public class CreditDeliverySubsidyValidationContext {

  private final Subsidy subsidy;

  private final CustomerAllowedToUseSubsidy customerAllowedToUseSubsidy;

  private final DealerAllowedToUseSubsidy dealerAllowedToUseSubsidy;

  private final LoanAllowedToUseSubsidy loanAllowedToUseSubsidy;

  private final ProductAllowedToUseSubsidy productAllowedToUseSubsidy;

  private final ProductFamilyAllowedToUseSubsidy productFamilyAllowedToUseSubsidy;

  private final CultureAllowedToUseSubsidy cultureAllowedToUseSubsidy;

  private final MarketSegmentAllowedToUseSubsidy marketSegmentAllowedToUseSubsidy;

  private final Set<EvaluationContext> evaluationContexts = new HashSet<>();

   CreditDeliverySubsidyValidationContext(DealerId dealerId,CustomerId customerId,ProductId productId,ProductFamilyId productFamilyId,CultureId cultureId,
      MarketSegment segment, LoanTime loanTime,Subsidy subsidy) {
    this.subsidy = subsidy;
    this.dealerAllowedToUseSubsidy = new DealerAllowedToUseSubsidy(dealerId);
    this.loanAllowedToUseSubsidy = new LoanAllowedToUseSubsidy(loanTime);
    this.customerAllowedToUseSubsidy = new CustomerAllowedToUseSubsidy(customerId);
    this.productAllowedToUseSubsidy = new ProductAllowedToUseSubsidy(productId);
    this.productFamilyAllowedToUseSubsidy = new ProductFamilyAllowedToUseSubsidy(productFamilyId);
    this.cultureAllowedToUseSubsidy = new CultureAllowedToUseSubsidy(cultureId);
    this.marketSegmentAllowedToUseSubsidy = new MarketSegmentAllowedToUseSubsidy(segment);
    evaluationContexts.add(new EvaluationContext("dealer-allowed",this.dealerAllowedToUseSubsidy.isSatisfiedBy(this.subsidy),CreditDeliveryFinanceConditionValidationMessages.DEALER_NOT_ALLOWED.message(), this.dealerAllowedToUseSubsidy.isSatisfiedBy(this.subsidy) ? 1 : 0));
    evaluationContexts.add(new EvaluationContext("customer-allowed",this.customerAllowedToUseSubsidy.isSatisfiedBy(this.subsidy),CreditDeliveryFinanceConditionValidationMessages.CUSTOMER_NOT_ALLOWED.message(), this.customerAllowedToUseSubsidy.isSatisfiedBy(this.subsidy) ? 1 : 0));
    evaluationContexts.add(new EvaluationContext("loan-time-allowed",this.loanAllowedToUseSubsidy.isSatisfiedBy(this.subsidy),CreditDeliveryFinanceConditionValidationMessages.LOAN_TIME_NOT_ALLOWED.message(), this.loanAllowedToUseSubsidy.isSatisfiedBy(this.subsidy) ? 1 : 0));
    evaluationContexts.add(new EvaluationContext("product-allowed",this.productAllowedToUseSubsidy.isSatisfiedBy(this.subsidy),CreditDeliveryFinanceConditionValidationMessages.PRODUCT_NOT_ALLOWED.message(), this.productAllowedToUseSubsidy.isSatisfiedBy(this.subsidy) ? 1 : 0));
    evaluationContexts.add(new EvaluationContext("product-family-allowed",this.productFamilyAllowedToUseSubsidy.isSatisfiedBy(this.subsidy),CreditDeliveryFinanceConditionValidationMessages.PRODUCT_FAMILY_NOT_ALLOWED.message(), this.productFamilyAllowedToUseSubsidy.isSatisfiedBy(this.subsidy) ? 1 : 0));
    evaluationContexts.add(new EvaluationContext("culture-allowed",this.cultureAllowedToUseSubsidy.isSatisfiedBy(this.subsidy),CreditDeliveryFinanceConditionValidationMessages.CULTURE_NOT_ALLOWED.message(), this.cultureAllowedToUseSubsidy.isSatisfiedBy(this.subsidy) ? 1 : 0));
    evaluationContexts.add(new EvaluationContext("market-segment",this.marketSegmentAllowedToUseSubsidy.isSatisfiedBy(this.subsidy),CreditDeliveryFinanceConditionValidationMessages.MARKET_SEGMENT_NOT_ALLOWED.message(), this.marketSegmentAllowedToUseSubsidy.isSatisfiedBy(this.subsidy) ? 1 : 0));

   }

  public boolean isSatisfied() {
    var products = this.productFamilyAllowedToUseSubsidy.or(this.productAllowedToUseSubsidy).isSatisfiedBy(this.subsidy);
    var actors = this.dealerAllowedToUseSubsidy.and(this.loanAllowedToUseSubsidy).and(this.customerAllowedToUseSubsidy)
        .and(this.cultureAllowedToUseSubsidy).and(this.marketSegmentAllowedToUseSubsidy).isSatisfiedBy(this.subsidy);
    return products && actors;
  }

  public int points(){
    return this.evaluationContexts.stream().flatMapToInt(ec -> IntStream.of(ec.point())).sum();
  }

  public List<String> messages(){
    return this.evaluationContexts.stream().filter(ec -> !ec.success()).map(
        EvaluationContext::message).toList();
  }

  public Subsidy getSubsidy() {
    return subsidy;
  }

}
