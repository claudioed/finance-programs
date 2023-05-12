package tech.claudioed.port.inputs.financecondition;

import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import tech.claudioed.domain.financecondition.DownPaymentRequirements;
import tech.claudioed.domain.shared.Amount;
import tech.claudioed.domain.shared.Duration;
import tech.claudioed.domain.shared.FinancingLineId;
import tech.claudioed.domain.shared.Interval;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.domain.shared.Targets;

public class NewFinanceCondition {

  @NotEmpty
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

  private boolean campaign;

  private DownPaymentRequirements downPaymentRequirements;

  @NotNull
  private MarketSegment segment;

  private FinancingLineId financingLine;

  private Interval contractingLimit;

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

  public MarketSegment getSegment() {
    return segment;
  }

  public FinancingLineId getFinancingLine() {
    return financingLine;
  }

  public boolean isCampaign() {
    return campaign;
  }

  public Interval getContractingLimit() {
    return contractingLimit;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setFactorySubsidy(
      SubsidyInformation factorySubsidy) {
    this.factorySubsidy = factorySubsidy;
  }

  public void setDealerSubsidy(
      SubsidyInformation dealerSubsidy) {
    this.dealerSubsidy = dealerSubsidy;
  }

  public void setFlat(FlatInformation flat) {
    this.flat = flat;
  }

  public void setOneTimeUsage(boolean oneTimeUsage) {
    this.oneTimeUsage = oneTimeUsage;
  }

  public void setTargets(Targets targets) {
    this.targets = targets;
  }

  public void setMaxTimeLoan(Duration maxTimeLoan) {
    this.maxTimeLoan = maxTimeLoan;
  }

  public void setPeriod(Interval period) {
    this.period = period;
  }

  public void setInterestRate(BigDecimal interestRate) {
    this.interestRate = interestRate;
  }

  public void setMaxAmount(Amount maxAmount) {
    this.maxAmount = maxAmount;
  }

  public void setCampaign(boolean campaign) {
    this.campaign = campaign;
  }

  public void setDownPaymentRequirements(
      DownPaymentRequirements downPaymentRequirements) {
    this.downPaymentRequirements = downPaymentRequirements;
  }

  public void setSegment(MarketSegment segment) {
    this.segment = segment;
  }

  public void setFinancingLine(FinancingLineId financingLine) {
    this.financingLine = financingLine;
  }

  public void setContractingLimit(Interval contractingLimit) {
    this.contractingLimit = contractingLimit;
  }

}
