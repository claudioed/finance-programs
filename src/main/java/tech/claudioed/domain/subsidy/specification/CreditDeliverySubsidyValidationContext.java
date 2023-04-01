package tech.claudioed.domain.subsidy.specification;

import tech.claudioed.domain.shared.nullable.NullableLoanTime;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.port.inputs.FinanceProgramQuery;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

import java.util.Objects;

public class CreditDeliverySubsidyValidationContext {

  private final FinanceProgramQuery request;

  private final Subsidy subsidy;

  private final CustomerAllowedToUseSubsidy customerAllowedToUseSubsidy;

  private final DealerAllowedToUseSubsidy dealerAllowedToUseSubsidy;

  private final LoanAllowedToUseSubsidy loanAllowedToUseSubsidy;

  private final ProductAllowedToUseSubsidy productAllowedToUseSubsidy;

  private final ProductFamilyAllowedToUseSubsidy productFamilyAllowedToUseSubsidy;


  public CreditDeliverySubsidyValidationContext(FinanceProgramQuery request, Subsidy subsidy) {
    this.request = request;
    this.subsidy = subsidy;
    this.dealerAllowedToUseSubsidy = new DealerAllowedToUseSubsidy(new DealerId(this.request.getDealer()));
    this.loanAllowedToUseSubsidy = new LoanAllowedToUseSubsidy(Objects.isNull(request.getLoanTime()) ? new NullableLoanTime() : this.request.getLoanTime());
    this.customerAllowedToUseSubsidy = new CustomerAllowedToUseSubsidy(new CustomerId(this.request.getCustomer()));
    this.productAllowedToUseSubsidy = new ProductAllowedToUseSubsidy(new ProductId(this.request.getProduct()));
    this.productFamilyAllowedToUseSubsidy = new ProductFamilyAllowedToUseSubsidy(new ProductFamilyId(this.request.getProductFamily()));
  }

  public boolean isSatisfied() {
    var products = this.productFamilyAllowedToUseSubsidy.or(this.productAllowedToUseSubsidy).isSatisfiedBy(this.subsidy);
    var actors = this.dealerAllowedToUseSubsidy.and(this.loanAllowedToUseSubsidy).and(this.customerAllowedToUseSubsidy).isSatisfiedBy(this.subsidy);
    return products && actors;
  }

  public int points(){
    int points = 0;
    points+= this.dealerAllowedToUseSubsidy.isSatisfiedBy(this.subsidy) ? 1 : 0;
    points+= this.loanAllowedToUseSubsidy.isSatisfiedBy(this.subsidy) ? 1 : 0;
    points+= this.customerAllowedToUseSubsidy.isSatisfiedBy(this.subsidy) ? 1 : 0;
    points+= this.productAllowedToUseSubsidy.isSatisfiedBy(this.subsidy) ? 1 : 0;
    points+= this.productFamilyAllowedToUseSubsidy.isSatisfiedBy(this.subsidy) ? 1 : 0;
    return points;
  }

  public Subsidy getSubsidy() {
    return subsidy;
  }

}
