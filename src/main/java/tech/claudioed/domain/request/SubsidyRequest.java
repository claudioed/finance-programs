package tech.claudioed.domain.request;

import java.math.BigDecimal;
import javax.persistence.Embeddable;
import tech.claudioed.domain.subsidy.SubsidyType;

@Embeddable
public class SubsidyRequest {

  private BigDecimal rate;

  private String name;

  private SubsidyType type;

  public SubsidyRequest(){}

}
