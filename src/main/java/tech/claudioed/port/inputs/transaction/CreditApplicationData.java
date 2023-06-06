package tech.claudioed.port.inputs.transaction;

import tech.claudioed.domain.shared.Amount;

public class CreditApplicationData {

  private String id;

  private Amount amount;

  public CreditApplicationData() {
  }

  public String getId() {
    return id;
  }

  public Amount getAmount() {
    return amount;
  }

}
