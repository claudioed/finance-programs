package tech.claudioed.domain.financecondition;

import java.math.BigDecimal;
import javax.money.MonetaryAmount;
import tech.claudioed.domain.shared.Duration;
import tech.claudioed.domain.shared.FinancingLineId;
import tech.claudioed.domain.shared.Interval;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.domain.shared.Targets;

public class FinanceConditionBuilder {

  private String name;
  private Duration maxTimeLoan;
  private Interval validity;
  private boolean oneTimeUsage;
  private Targets targets;
  private BigDecimal interestRate;
  private DownPaymentRequirements downPaymentRequirements;
  private MonetaryAmount monetaryAmount;
  private String utm;
  private MarketSegment segment;
  private FinancingLineId financingLineId;

  private Interval contractingLimit;

  public FinanceConditionBuilder name(String name) {
    this.name = name;
    return this;
  }

  public FinanceConditionBuilder maxTimeLoan(Duration maxTimeLoan) {
    this.maxTimeLoan = maxTimeLoan;
    return this;
  }

  public FinanceConditionBuilder interval(Interval interval) {
    this.validity = interval;
    return this;
  }

  public FinanceConditionBuilder oneTimeUsage(boolean oneTimeUsage) {
    this.oneTimeUsage = oneTimeUsage;
    return this;
  }

  public FinanceConditionBuilder targets(Targets targets) {
    this.targets = targets;
    return this;
  }

  public FinanceConditionBuilder interestRate(BigDecimal interestRate) {
    this.interestRate = interestRate;
    return this;
  }

  public FinanceConditionBuilder downPaymentRequirements(
      DownPaymentRequirements downPaymentRequirements) {
    this.downPaymentRequirements = downPaymentRequirements;
    return this;
  }

  public FinanceConditionBuilder monetaryAmount(MonetaryAmount monetaryAmount) {
    this.monetaryAmount = monetaryAmount;
    return this;
  }

  public FinanceConditionBuilder utm(String utm) {
    this.utm = utm;
    return this;
  }

  public FinanceConditionBuilder segment(MarketSegment segment) {
    this.segment = segment;
    return this;
  }

  public FinanceConditionBuilder contractingLimit(Interval interval) {
    this.contractingLimit = contractingLimit;
    return this;
  }

  public FinanceConditionBuilder financingLineId(FinancingLineId financingLineId) {
    this.financingLineId = financingLineId;
    return this;
  }

  public FinanceCondition newFinanceCondition() {
    return new FinanceCondition(name, maxTimeLoan, validity, oneTimeUsage, targets, interestRate,
        downPaymentRequirements, monetaryAmount, utm, segment, financingLineId,this.contractingLimit);
  }
}
