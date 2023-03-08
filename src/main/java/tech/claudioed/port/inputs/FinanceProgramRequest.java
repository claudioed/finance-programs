package tech.claudioed.port.inputs;

import java.math.BigDecimal;
import tech.claudioed.domain.shared.Duration;

public class FinanceProgramRequest {

  private String dealer;

  private String productFamily;

  private String product;

  private Duration loanTime;

  private BigDecimal targetRate;

  private String customer;

  public String getDealer() {
    return dealer;
  }

  public String getProductFamily() {
    return productFamily;
  }

  public String getProduct() {
    return product;
  }

  public Duration getLoanTime() {
    return loanTime;
  }

  public BigDecimal getTargetRate() {
    return targetRate;
  }

  public String getCustomer() {
    return customer;
  }
}
