package tech.claudioed.port.inputs;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DownPayment {

  private BigDecimal percent;

  private LocalDate firstInstallment;

  public DownPayment(){}

  public DownPayment(BigDecimal percent, LocalDate firstInstallment) {
    this.percent = percent;
    this.firstInstallment = firstInstallment;
  }

  public BigDecimal getPercent() {
    return percent;
  }

  public LocalDate getFirstInstallment() {
    return firstInstallment;
  }

}
