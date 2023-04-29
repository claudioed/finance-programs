package tech.claudioed.port.inputs;

import java.math.BigDecimal;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.validation.constraints.NotEmpty;

import tech.claudioed.domain.financecondition.RatingId;
import tech.claudioed.domain.shared.Amount;
import tech.claudioed.domain.shared.LoanTime;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.port.inputs.finance.CultureId;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

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

  private String utm;

  private String culture;

  private String rating;

  private MarketSegment segment;

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

  public String getUtm() {
    return utm;
  }

  public String getCulture() {
    return culture;
  }

  public String getRating() {
    return rating;
  }

  public MarketSegment getSegment() {
    return segment;
  }

  public DealerId dealerId(){
    return new DealerId(this.dealer);
  }

  public ProductId productId(){
    return new ProductId(this.product);
  }

  public CustomerId customerId(){
    return new CustomerId(this.customer);
  }

  public CultureId cultureId(){
    return new CultureId(this.culture);
  }

  public ProductFamilyId productFamilyId(){
    return new ProductFamilyId(this.productFamily);
  }

  public RatingId ratingId(){
    return new RatingId(this.rating);
  }

}
