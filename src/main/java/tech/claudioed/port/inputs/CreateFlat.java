package tech.claudioed.port.inputs;

import java.math.BigDecimal;
import tech.claudioed.domain.shared.Interval;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.domain.shared.Targets;

public class CreateFlat {

  private Targets targets;

  private String name;

  private Interval period;

  private BigDecimal rate;

  private MarketSegment segment;

  public Targets getTargets() {
    return targets;
  }

  public String getName() {
    return name;
  }

  public Interval getPeriod() {
    return period;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public void setTargets(Targets targets) {
    this.targets = targets;
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

  public MarketSegment getSegment() {
    return segment;
  }

  public void setSegment(MarketSegment segment) {
    this.segment = segment;
  }
}
