package tech.claudioed.domain.shared;

public class LoanTime {

  private Integer time;

  private PeriodUnit unit;

  public Integer getTime() {
    return time;
  }
  public void setTime(Integer time) {
    this.time = time;
  }

  public PeriodUnit getUnit() {
    return unit;
  }

  public void setUnit(PeriodUnit unit) {
    this.unit = unit;
  }

}
