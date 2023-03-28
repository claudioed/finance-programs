package tech.claudioed.port.inputs.request;

import java.math.BigDecimal;
import tech.claudioed.domain.request.FlatRequest;
import tech.claudioed.domain.request.SubsidyRequest;
import tech.claudioed.domain.shared.Duration;
import tech.claudioed.domain.shared.Interval;
import tech.claudioed.domain.shared.Targets;

public class FinanceConditionRequest {

  private String name;

  private String notes;

  private Duration maxTimeLoan;

  private Targets targets;

  private Interval period;

  private BigDecimal interestRate;

  private SubsidyRequest factoryRequest;

  private SubsidyRequest dealerRequest;

  private FlatRequest flatRequest;

  public String getName() {
    return name;
  }

  public String getNotes() {
    return notes;
  }

  public Duration getMaxTimeLoan() {
    return maxTimeLoan;
  }

  public Targets getTargets() {
    return targets;
  }

  public Interval getPeriod() {
    return period;
  }

  public BigDecimal getInterestRate() {
    return interestRate;
  }

  public SubsidyRequest getFactoryRequest() {
    return factoryRequest;
  }

  public SubsidyRequest getDealerRequest() {
    return dealerRequest;
  }

  public FlatRequest getFlatRequest() {
    return flatRequest;
  }

}
