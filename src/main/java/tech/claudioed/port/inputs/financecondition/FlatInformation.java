package tech.claudioed.port.inputs.financecondition;

import java.math.BigDecimal;
import tech.claudioed.domain.shared.ids.FlatId;

public class FlatInformation {
  private String name;
  private BigDecimal rate;
  private FlatId flat;

  public FlatInformation(){}

  public FlatInformation(String name, BigDecimal rate) {
    this.name = name;
    this.rate = rate;
  }
  public String getName() {
    return name;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public String id() {
    return flat.id();
  }
  public FlatId getFlat() {
    return flat;
  }

}
