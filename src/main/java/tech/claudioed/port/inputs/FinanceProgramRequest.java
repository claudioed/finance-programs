package tech.claudioed.port.inputs;

import java.math.BigDecimal;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import tech.claudioed.domain.shared.Amount;
import tech.claudioed.domain.shared.Duration;
import tech.claudioed.domain.shared.LoanTime;

public class FinanceProgramRequest {

  private String dealer;

  private String productFamily;

  private String product;

  private LoanTime loanTime;

  private BigDecimal targetRate;

  private String customer;

  private DownPayment downPayment;

  private Amount loanAmount;

  public String getDealer() {
    return dealer;
  }

  public String getProductFamily() {
    return productFamily;
  }

  public String getProduct() {
    return product;
  }

  public LoanTime getLoanTime() {
    return loanTime;
  }

  public BigDecimal getTargetRate() {
    return targetRate;
  }

  public String getCustomer() {
    return customer;
  }

  public DownPayment getDownPayment() {
    return downPayment;
  }

  public Amount getLoanAmount() {
    return loanAmount;
  }

  public MonetaryAmount amount(){
    return Monetary.getDefaultAmountFactory()
        .setCurrency(Monetary.getCurrency(this.loanAmount.getCurrency()))
        .setNumber(this.loanAmount.getAmount()).create();
  }

}
