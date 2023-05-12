package tech.claudioed.domain.transaction;

import javax.persistence.Embeddable;

@Embeddable
public class SubsidyId {

  private String id;

  public SubsidyId(){}

  public SubsidyId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}

