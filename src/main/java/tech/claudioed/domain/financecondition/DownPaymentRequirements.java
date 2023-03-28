package tech.claudioed.domain.financecondition;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Embeddable;

@Embeddable
public class DownPaymentRequirements {

  private BigDecimal percent;

  private LocalDate maxDate;

  public BigDecimal getPercent() {
    return percent;
  }

  public void setPercent(BigDecimal percent) {
    this.percent = percent;
  }

  public LocalDate getMaxDate() {
    return maxDate;
  }

  public void setMaxDate(LocalDate maxDate) {
    this.maxDate = maxDate;
  }

}
