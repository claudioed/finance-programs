package tech.claudioed.domain.analysis;

import javax.persistence.Embeddable;
import tech.claudioed.port.inputs.analysis.CreditApplication;

@Embeddable
public class CreditApplicationId {

  private String id;

  public CreditApplicationId(){}

  public CreditApplicationId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}

