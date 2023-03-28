package tech.claudioed.port.outputs.subsidy;

import java.math.BigDecimal;
import tech.claudioed.domain.subsidy.SubsidyType;

public class SubsidyData {

  private String id;

  private String name;

  private BigDecimal rate;

  private String subsidyType;

  private String maxLoanTime;

  public SubsidyData() {}

  public SubsidyData(String id, String name, BigDecimal rate, String subsidyType,
      String maxLoanTime) {
    this.id = id;
    this.name = name;
    this.rate = rate;
    this.subsidyType = subsidyType;
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

  public String getSubsidyType() {
    return subsidyType;
  }

  public String getMaxLoanTime() {
    return maxLoanTime;
  }
}
