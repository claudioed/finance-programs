package tech.claudioed.port.outputs.subsidy;

import java.math.BigDecimal;

public class SubsidyData {

  private String id;

  private String name;

  private BigDecimal rate;

  private String maxLoanTime;

  public SubsidyData() {}

  public SubsidyData(String id, String name, BigDecimal rate, String subsidyType,
      String maxLoanTime) {
    this.id = id;
    this.name = name;
    this.rate = rate;
    this.maxLoanTime = maxLoanTime;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public String getMaxLoanTime() {
    return maxLoanTime;
  }
}
