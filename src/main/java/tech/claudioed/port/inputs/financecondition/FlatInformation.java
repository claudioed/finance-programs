package tech.claudioed.port.inputs.financecondition;

import java.math.BigDecimal;

public class FlatInformation {
  private String name;
  private BigDecimal rate;
  private FlatId flat;

  public String getName() {
    return name;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public String getFlatId() {
    return flat.id();
  }
  public FlatId getFlat() {
    return flat;
  }

}
