package tech.claudioed.port.inputs.analysis;

import java.time.LocalDate;
import tech.claudioed.domain.financecondition.RatingId;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.port.inputs.finance.CultureId;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

public class CreditApplicationAnalysisRequest {

  private CreditApplication application;

  private String productFamily;

  private String product;

  private String customer;

  private LocalDate contractDate;

  private String dealer;

  private String financeCondition;

  private String rating;

  private String culture;

  private String utm;

  private MarketSegment marketSegment;

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

  public MarketSegment getMarketSegment() {
    return marketSegment;
  }

}
