package tech.claudioed.domain.specification.subsidy;

import tech.claudioed.domain.Subsidy;
import tech.claudioed.domain.shared.specification.AbstractSpecification;
import tech.claudioed.port.inputs.FinanceProgramRequest;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

public class ValidSubsidyForFinanceRequest extends AbstractSpecification<Subsidy> {

  private final FinanceProgramRequest request;

  public ValidSubsidyForFinanceRequest(FinanceProgramRequest request) {
    this.request = request;
  }

  @Override
  public boolean isSatisfiedBy(Subsidy subsidy) {
    return new CustomerAllowedToUseSubsidy(new CustomerId(this.request.getCustomer()))
        .and(new DealerAllowedToUseSubsidy(new DealerId(this.request.getDealer())))
        .and(new LoanAllowedToUseSubsidy(this.request.getLoanTime()))
        .and(new ProductAllowedToUseSubsidy(new ProductId(this.request.getProduct())))
        .and(new ProductFamilyAllowedToUseSubsidy(new ProductFamilyId(this.request.getProductFamily())))
        .isSatisfiedBy(subsidy);
  }

}
