package tech.claudioed.port.inputs.financecondition;

import java.math.BigDecimal;
import tech.claudioed.domain.financecondition.DownPaymentRequirements;
import tech.claudioed.domain.shared.Amount;
import tech.claudioed.domain.shared.Duration;
import tech.claudioed.domain.shared.Interval;
import tech.claudioed.domain.shared.Targets;

public class NewFinanceCondition {

  private String name;

  private SubsidyInformation factorySubsidy;

  private SubsidyInformation dealerSubsidy;

  private FlatInformation flat;

  private boolean oneTimeUsage;

  private Targets targets;

  private Duration maxTimeLoan;

  private Interval period;

  private BigDecimal interestRate;

  private Amount maxAmount;

  private DownPaymentRequirements downPaymentRequirements;

  public String getName() {
    return name;
  }

  public FlatInformation getFlat() {
    return flat;
  }

  public boolean isOneTimeUsage() {
    return oneTimeUsage;
  }

  public Targets getTargets() {
    return targets;
  }

  public Duration getMaxTimeLoan() {
    return maxTimeLoan;
  }

  public boolean preRegisteredFlat(){
    return this.flat.getFlat() != null;
  }

  public boolean preRegisteredFactorySubsidy(){
    return this.factorySubsidy.getSubsidy() != null;
  }

  public BigDecimal getInterestRate() {
    return interestRate;
  }

  public DownPaymentRequirements getDownPaymentRequirements() {
    return downPaymentRequirements;
  }

  public SubsidyInformation getFactorySubsidy() {
    return factorySubsidy;
  }

  public SubsidyInformation getDealerSubsidy() {
    return dealerSubsidy;
  }

  public Interval getPeriod() {
    return period;
  }

  public Amount getMaxAmount() {
    return maxAmount;
  }

}