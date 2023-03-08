package tech.claudioed.domain.picker;

import java.util.Comparator;
import java.util.List;
import tech.claudioed.domain.Subsidy;

public class SubsidyPicker {

  private final List<Subsidy> subsidies;

  public SubsidyPicker(List<Subsidy> subsidies) {
    this.subsidies = subsidies;
  }

  public Subsidy pick(){
    return this.subsidies.stream().min(Comparator.comparing(Subsidy::getRate)).get();
  }

}
