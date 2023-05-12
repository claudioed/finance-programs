package tech.claudioed.domain.subsidy;

import io.hypersistence.utils.hibernate.type.money.MonetaryAmountType;
import javax.money.MonetaryAmount;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.TypeDef;

@Embeddable
@TypeDef(typeClass = MonetaryAmountType.class, defaultForType = MonetaryAmount.class)
public class SubsidyBudget {

  @Columns(columns = {
      @Column(name = "subsidy_budget_amount"),
      @Column(name = "subsidy_budget_currency")
  })
  private MonetaryAmount budget;

  public SubsidyBudget(){}

  public SubsidyBudget(MonetaryAmount budget) {
    this.budget = budget;
  }

  public MonetaryAmount getBudget() {
    return budget;
  }

  public void setBudget(MonetaryAmount budget) {
    this.budget = budget;
  }

}
