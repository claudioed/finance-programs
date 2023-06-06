package tech.claudioed.domain.financecondition;

import java.time.LocalDateTime;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import tech.claudioed.domain.analysis.CreditApplicationId;

@Embeddable
public class FinanceConditionProvisioned {

  private LocalDateTime at;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="id",column=@Column(name="credit_application_id"))
  })
  private CreditApplicationId applicationId;

  public FinanceConditionProvisioned() {
  }

  public FinanceConditionProvisioned(LocalDateTime at, CreditApplicationId applicationId) {
    this.at = at;
    this.applicationId = applicationId;
  }

  public LocalDateTime getAt() {
    return at;
  }

  public CreditApplicationId getApplicationId() {
    return applicationId;
  }

}
