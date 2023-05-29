package tech.claudioed.domain.transaction;

import io.hypersistence.utils.hibernate.type.money.MonetaryAmountType;
import javax.money.MonetaryAmount;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.TypeDef;
import tech.claudioed.domain.analysis.CreditApplicationId;

@Embeddable
@TypeDef(typeClass = MonetaryAmountType.class, defaultForType = MonetaryAmount.class)
public class CreditApplication {

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="id",column=@Column(name="application_id")),
  })
  private CreditApplicationId id;

  @Columns(columns = {
      @Column(name = "application_amount"),
      @Column(name = "application_currency")
  })
  private MonetaryAmount amount;

  public CreditApplicationId getId() {
    return id;
  }

  public MonetaryAmount getAmount() {
    return amount;
  }

}
