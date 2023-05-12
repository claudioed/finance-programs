package tech.claudioed.port.inputs.financecondition;

import java.math.BigDecimal;

public class SubsidyInformation {
  private String name;
  private BigDecimal rate;

  private SubsidyId subsidy;

  public SubsidyInformation(){}

  public SubsidyInformation(String name, BigDecimal rate) {
    this.name = name;
    this.rate = rate;
  }
  public String getName() {
    return name;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public SubsidyId getSubsidy() {
    return subsidy;
  }

  public String id(){
    return this.subsidy.getId();
  }

}
