package tech.claudioed.domain.shared;

import javax.persistence.Embeddable;

@Embeddable
public class Duration {

  private Integer min;

  private Integer max;

  private PeriodUnit unit;

  public Duration(){}

  public Duration(Integer min, Integer max, PeriodUnit unit) {
    this.min = min;
    this.max = max;
    this.unit = unit;
  }

  public Integer getMin() {
    return min;
  }

  public void setMin(Integer min) {
    this.min = min;
  }

  public Integer getMax() {
    return max;
  }

  public void setMax(Integer max) {
    this.max = max;
  }

  public PeriodUnit getUnit() {
    return unit;
  }

  public void setUnit(PeriodUnit unit) {
    this.unit = unit;
  }

  public boolean withinRange(LoanTime time){
    var loanMonths = time.getUnit().timeInMonths(time.getTime());
    var minMonths = unit.timeInMonths(this.min);
    var maxMonths = unit.timeInMonths(this.max);
    return minMonths < loanMonths && maxMonths > loanMonths;
  }

}
