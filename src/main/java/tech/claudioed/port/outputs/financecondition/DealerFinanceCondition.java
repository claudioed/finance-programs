package tech.claudioed.port.outputs.financecondition;

import java.math.BigDecimal;
import tech.claudioed.domain.shared.Amount;
import tech.claudioed.port.outputs.flat.FlatData;
import tech.claudioed.port.outputs.subsidy.SubsidyData;

public class DealerFinanceCondition {

  private String id;

  private String name;

  private BigDecimal interestRate;

  private Amount maxAmount;

  private SubsidyData dealerSubsidy;

  private FlatData flat;

  private String utm;

  public DealerFinanceCondition(){}

  public DealerFinanceCondition(String id,String name, BigDecimal interestRate, Amount maxAmount,
      SubsidyData dealerSubsidy, FlatData flat,String utm) {
    this.id = id;
    this.interestRate = interestRate;
    this.maxAmount = maxAmount;
    this.dealerSubsidy = dealerSubsidy;
    this.flat = flat;
    this.name = name;
    this.utm = utm;
  }

  public String getId() {
    return id;
  }

  public BigDecimal getInterestRate() {
    return interestRate;
  }

  public Amount getMaxAmount() {
    return maxAmount;
  }

  public SubsidyData getDealerSubsidy() {
    return dealerSubsidy;
  }

  public FlatData getFlat() {
    return flat;
  }

  public String getName() {
    return name;
  }

  public String getUtm() {
    return utm;
  }

}
