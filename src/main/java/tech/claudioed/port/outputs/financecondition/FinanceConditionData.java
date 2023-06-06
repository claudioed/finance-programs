package tech.claudioed.port.outputs.financecondition;

import java.math.BigDecimal;
import tech.claudioed.domain.shared.Amount;
import tech.claudioed.domain.shared.Interval;
import tech.claudioed.port.outputs.flat.FlatData;
import tech.claudioed.port.outputs.subsidy.SubsidyData;

public class FinanceConditionData {

  private String id;

  private String name;

  private BigDecimal interestRate;

  private Amount maxAmount;

  private SubsidyData dealerSubsidy;

  private SubsidyData factorySubsidy;

  private FlatData flat;

  private String utm;

  public Interval validUntil;

  public Interval contractingLimit;

  public FinanceConditionData(){}

  public FinanceConditionData(String id,String name, BigDecimal interestRate, Amount maxAmount,
      SubsidyData dealerSubsidy,SubsidyData factorySubsidy, FlatData flat,String utm,Interval validUntil,Interval contractingLimit) {
    this.id = id;
    this.interestRate = interestRate;
    this.maxAmount = maxAmount;
    this.dealerSubsidy = dealerSubsidy;
    this.flat = flat;
    this.name = name;
    this.utm = utm;
    this.factorySubsidy = factorySubsidy;
    this.validUntil = validUntil;
    this.contractingLimit = contractingLimit;
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

  public SubsidyData getFactorySubsidy() {
    return factorySubsidy;
  }

  public Interval getContractingLimit() {
    return contractingLimit;
  }

  public Interval getValidUntil() {
    return validUntil;
  }
}
