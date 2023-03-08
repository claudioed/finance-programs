package tech.claudioed.domain.specification.flat;

import tech.claudioed.domain.Flat;
import tech.claudioed.port.inputs.FinanceProgramRequest;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

public class FlatValidationContext {

  private final FinanceProgramRequest request;

  private final Flat flat;

  private final DealerAllowedToUseFlat dealerAllowed;

  private final LoanAllowedToUseFlat loanAllowed;

  private final CustomerAllowedToUseFlat customerAllowed;

  private final ProductAllowedToUseFlat productAllowed;

  private final ProductFamilyAllowedToUseFlat productFamilyAllowed;

  public FlatValidationContext(FinanceProgramRequest request, Flat flat) {
    this.request = request;
    this.flat = flat;
    this.dealerAllowed = new DealerAllowedToUseFlat(new DealerId(this.request.getDealer()));
    this.loanAllowed = new LoanAllowedToUseFlat(this.request.getLoanTime());
    this.customerAllowed = new CustomerAllowedToUseFlat(new CustomerId(this.request.getCustomer()));
    this.productAllowed = new ProductAllowedToUseFlat(new ProductId(this.request.getProduct()));
    this.productFamilyAllowed = new ProductFamilyAllowedToUseFlat(new ProductFamilyId(this.request.getProductFamily()));
  }

  public boolean isSatisfied() {
    var dealerAllowed = new DealerAllowedToUseFlat(new DealerId(this.request.getDealer()));
    var loanAllowed = new LoanAllowedToUseFlat(this.request.getLoanTime());
    var customerAllowed = new CustomerAllowedToUseFlat(new CustomerId(this.request.getCustomer()));
    var productAllowed = new ProductAllowedToUseFlat(new ProductId(this.request.getProduct()));
    var productFamilyAllowed = new ProductFamilyAllowedToUseFlat(new ProductFamilyId(this.request.getProductFamily()));
    var products = productFamilyAllowed.or(productAllowed).isSatisfiedBy(flat);
    var actors = dealerAllowed.and(loanAllowed).and(customerAllowed).isSatisfiedBy(flat);
    return products && actors;
  }

  public int points(){
    int points = 0;
    points+= dealerAllowed.isSatisfiedBy(flat) ? 1 : 0;
    points+= loanAllowed.isSatisfiedBy(flat) ? 1 : 0;
    points+= customerAllowed.isSatisfiedBy(flat) ? 1 : 0;
    points+= productAllowed.isSatisfiedBy(flat) ? 1 : 0;
    points+= productFamilyAllowed.isSatisfiedBy(flat) ? 1 : 0;
    return points;
  }

  public Flat getFlat() {
    return flat;
  }

}
