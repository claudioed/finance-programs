package tech.claudioed.port.inputs.analysis;

import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import tech.claudioed.domain.financecondition.RatingId;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.port.inputs.finance.CultureId;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

public class CreditApplicationAnalysisRequest {

  private CreditApplication application;

  @NotEmpty
  private String productFamily;

  @NotEmpty
  private String product;

  @NotEmpty
  private String customer;

  @NotEmpty
  private LocalDate contractDate;

  @NotEmpty
  private String dealer;

  @NotEmpty
  private String financeCondition;

  private String rating;

  @NotEmpty
  private String culture;

  private String utm;

  @NotEmpty
  private MarketSegment segment;

  public String getProductFamily() {
    return productFamily;
  }

  public String getProduct() {
    return product;
  }

  public String getCustomer() {
    return customer;
  }

  public LocalDate getContractDate() {
    return contractDate;
  }

  public String getDealer() {
    return dealer;
  }

  public String getFinanceCondition() {
    return financeCondition;
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

  public ProductFamilyId productFamilyId(){
    return new ProductFamilyId(this.productFamily);
  }

  public RatingId ratingId(){
    return new RatingId(this.rating);
  }

  public CultureId cultureId(){
    return new CultureId(this.culture);
  }

  public String getUtm() {
    return utm;
  }

  public CreditApplication getApplication() {
    return application;
  }

  public MarketSegment getSegment() {
    return segment;
  }

  public String getCulture() {
    return culture;
  }

  public String getRating() {
    return rating;
  }

}
