package tech.claudioed.domain.request;

import javax.persistence.Embeddable;

@Embeddable
public class FinanceConditionProposalId {

  private String id;

  public FinanceConditionProposalId(){}

  public FinanceConditionProposalId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}
