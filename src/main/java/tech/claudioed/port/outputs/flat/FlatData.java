package tech.claudioed.port.outputs.flat;

import java.math.BigDecimal;

public class FlatData {

  private String id;

  private String name;

  private BigDecimal rate;

  public FlatData(){}

  public FlatData(String id, String name, BigDecimal rate) {
    this.id = id;
    this.name = name;
    this.rate = rate;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getRate() {
    return rate;
  }
}
