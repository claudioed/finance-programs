package tech.claudioed.port.inputs.financecondition;

import java.math.BigDecimal;

public class SubsidyInformation {
  private String name;
  private BigDecimal rate;

  private SubsidyId subsidy;

  public String getName() {
    return name;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public SubsidyId getSubsidy() {
    return subsidy;
  }

  public String getId(){
    return this.subsidy.getId();
  }

}
