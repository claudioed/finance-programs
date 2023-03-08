package tech.claudioed.domain;

import java.math.BigDecimal;

public class SubsidiesRequired {

  private BigDecimal rate;

  public SubsidiesRequired(BigDecimal rate) {
    this.rate = rate;
  }

  public BigDecimal getRate() {
    return rate;
  }
  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

}
