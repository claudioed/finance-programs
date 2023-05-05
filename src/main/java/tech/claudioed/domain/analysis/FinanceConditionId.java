package tech.claudioed.domain.analysis;

import javax.persistence.Embeddable;

@Embeddable
public class FinanceConditionId {

  private String id;

  public FinanceConditionId(){}

  public FinanceConditionId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}

