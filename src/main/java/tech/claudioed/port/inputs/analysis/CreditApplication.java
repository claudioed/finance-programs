package tech.claudioed.port.inputs.analysis;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import tech.claudioed.domain.shared.LoanTime;
import tech.claudioed.port.inputs.DownPayment;

public class CreditApplication {

  private String id;

  private DownPayment downPayment;

  private CreditApplicationAmount amount;

  private LoanTime loanTime;

  public String getId() {
    return id;
  }

  public DownPayment getDownPayment() {
    return downPayment;
  }

  public CreditApplicationAmount getAmount() {
    return amount;
  }

  public LoanTime getLoanTime() {
    return loanTime;
  }

  public MonetaryAmount amount(){
    return Monetary.getDefaultAmountFactory()
        .setCurrency(Monetary.getCurrency(this.amount.getCurrency()))
        .setNumber(this.amount.getAmount()).create();
  }
}
