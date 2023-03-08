package tech.claudioed.port.inputs;

import java.math.BigDecimal;
import tech.claudioed.domain.shared.Duration;
import tech.claudioed.domain.shared.Interval;
import tech.claudioed.domain.shared.Targets;

public class CreateSubsidy {

  private String name;
  private Interval period;
  private BigDecimal rate;
  private Targets targets;
  private Duration maxTimeLoan;

  public Interval getPeriod() {
    return period;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public Targets getTargets() {
    return targets;
  }

  public Duration getMaxTimeLoan() {
    return maxTimeLoan;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPeriod(Interval period) {
    this.period = period;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  public void setTargets(Targets targets) {
    this.targets = targets;
  }

  public void setMaxTimeLoan(Duration maxTimeLoan) {
    this.maxTimeLoan = maxTimeLoan;
  }

}
