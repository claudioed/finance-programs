package tech.claudioed.domain.shared;

import javax.persistence.Embeddable;

@Embeddable
public class Duration {

  private Double min;

  private Double max;

  private String unit;

  public Duration(){}

  public Duration(Double min, Double max, String unit) {
    this.min = min;
    this.max = max;
    this.unit = unit;
  }

  public Double getMin() {
    return min;
  }

  public void setMin(Double min) {
    this.min = min;
  }

  public Double getMax() {
    return max;
  }

  public void setMax(Double max) {
    this.max = max;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

}
