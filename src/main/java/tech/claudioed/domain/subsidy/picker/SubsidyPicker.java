package tech.claudioed.domain.subsidy.picker;

import java.util.Comparator;
import java.util.List;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.domain.subsidy.specification.SubsidyValidationContext;

public class SubsidyPicker {

  private final List<SubsidyValidationContext> subsidies;

  public SubsidyPicker(List<SubsidyValidationContext> subsidies) {
    this.subsidies = subsidies;
  }

  public Subsidy pick(){
    return this.subsidies.stream().min(Comparator.comparing(SubsidyValidationContext::points)).get().getSubsidy();
  }

}
