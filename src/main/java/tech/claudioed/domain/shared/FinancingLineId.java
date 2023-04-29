package tech.claudioed.domain.shared;

import javax.persistence.Embeddable;

@Embeddable
public class FinancingLineId {

  private String id;

  public FinancingLineId(){}

  public FinancingLineId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

}
