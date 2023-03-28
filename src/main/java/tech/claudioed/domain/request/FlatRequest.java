package tech.claudioed.domain.request;

import java.math.BigDecimal;
import javax.persistence.Embeddable;

@Embeddable
public class FlatRequest {

  private BigDecimal rate;

  private String name;

  public FlatRequest(){}

}
