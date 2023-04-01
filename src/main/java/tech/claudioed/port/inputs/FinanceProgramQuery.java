package tech.claudioed.port.inputs;

import java.math.BigDecimal;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.validation.constraints.NotEmpty;

import tech.claudioed.domain.shared.Amount;
import tech.claudioed.domain.shared.LoanTime;

public class FinanceProgramQuery {

  @NotEmpty
  private String dealer;

  private String productFamily;

  private String product;

  private LoanTime loanTime;

  @NotEmpty
  private BigDecimal targetRate;

  @NotEmpty
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

  public void setDealer(String dealer) {
    this.dealer = dealer;
  }

  public void setProductFamily(String productFamily) {
    this.productFamily = productFamily;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public void setLoanTime(LoanTime loanTime) {
    this.loanTime = loanTime;
  }

  public void setTargetRate(BigDecimal targetRate) {
    this.targetRate = targetRate;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public void setDownPayment(DownPayment downPayment) {
    this.downPayment = downPayment;
  }

  public void setLoanAmount(Amount loanAmount) {
    this.loanAmount = loanAmount;
  }

  public MonetaryAmount amount(){
    return Monetary.getDefaultAmountFactory()
        .setCurrency(Monetary.getCurrency(this.loanAmount.getCurrency()))
        .setNumber(this.loanAmount.getAmount()).create();
  }

}
