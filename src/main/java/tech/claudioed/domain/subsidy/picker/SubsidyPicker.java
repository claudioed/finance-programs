package tech.claudioed.domain.subsidy.picker;

import java.util.Comparator;
import java.util.List;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.domain.subsidy.specification.validation.CreditDeliverySubsidyValidationContext;

public class SubsidyPicker {

  private final List<CreditDeliverySubsidyValidationContext> subsidies;

  public SubsidyPicker(List<CreditDeliverySubsidyValidationContext> subsidies) {
    this.subsidies = subsidies;
  }

  public Subsidy pick(){
    return this.subsidies.stream().min(Comparator.comparing(CreditDeliverySubsidyValidationContext::points)).get().getSubsidy();
  }

}
