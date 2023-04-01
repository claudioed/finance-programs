package tech.claudioed.domain.flat.specification;

import java.util.Objects;
import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.shared.nullable.NullableLoanTime;
import tech.claudioed.port.inputs.FinanceProgramQuery;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

public class CreditDeliveryFlatValidationContext {

  private final FinanceProgramQuery request;

  private final Flat flat;

  private final DealerAllowedToUseFlat dealerAllowed;

  private final LoanAllowedToUseFlat loanAllowed;

  private final CustomerAllowedToUseFlat customerAllowed;

  private final ProductAllowedToUseFlat productAllowed;

  private final ProductFamilyAllowedToUseFlat productFamilyAllowed;

  public CreditDeliveryFlatValidationContext(FinanceProgramQuery request, Flat flat) {
    this.request = request;
    this.flat = flat;
    this.dealerAllowed = new DealerAllowedToUseFlat(new DealerId(this.request.getDealer()));
    this.loanAllowed = new LoanAllowedToUseFlat(Objects.isNull(request.getLoanTime()) ? new NullableLoanTime() : this.request.getLoanTime());
    this.customerAllowed = new CustomerAllowedToUseFlat(new CustomerId(this.request.getCustomer()));
    this.productAllowed = new ProductAllowedToUseFlat(new ProductId(this.request.getProduct()));
    this.productFamilyAllowed = new ProductFamilyAllowedToUseFlat(new ProductFamilyId(this.request.getProductFamily()));
  }

  public boolean isSatisfied() {
    var products = this.productFamilyAllowed.or(this.productAllowed).isSatisfiedBy(flat);
    var actors = this.dealerAllowed.and(this.loanAllowed).and(this.customerAllowed).isSatisfiedBy(flat);
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
