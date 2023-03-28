package tech.claudioed.domain.shared;

import javax.validation.Valid;

public class Amount {

  private @Valid String currency;
  private @Valid Double amount;

  public Amount(){}

  public Amount(String currency, Double amount) {
    this.currency = currency;
    this.amount = amount;
  }
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }
}
