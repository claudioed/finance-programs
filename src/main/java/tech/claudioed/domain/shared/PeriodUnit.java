package tech.claudioed.domain.shared;

public enum PeriodUnit {

  MONTH(1),

  YEAR(12) ;

  private final Integer months;
  PeriodUnit(Integer months) {
    this.months = months;
  }

  public Integer timeInMonths(Integer value){
    return this.months * value;
  }

}
