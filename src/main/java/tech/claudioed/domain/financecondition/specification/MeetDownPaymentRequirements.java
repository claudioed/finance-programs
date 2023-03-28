package tech.claudioed.domain.financecondition.specification;

import java.math.BigDecimal;
import java.time.LocalDate;
import tech.claudioed.domain.financecondition.FinanceCondition;
import tech.claudioed.domain.shared.specification.AbstractSpecification;

public class MeetDownPaymentRequirements extends AbstractSpecification<FinanceCondition> {

  private final BigDecimal downPaymentPercent;
  private final LocalDate firstInstallment;

  public MeetDownPaymentRequirements(BigDecimal downPaymentPercent, LocalDate firstInstallment) {
    this.downPaymentPercent = downPaymentPercent;
    this.firstInstallment = firstInstallment;
  }

  @Override
  public boolean isSatisfiedBy(FinanceCondition financeCondition) {
    var dr = financeCondition.getDownPaymentRequirements();
    return dr.getMaxDate().isAfter(this.firstInstallment)
        && dr.getPercent().compareTo(this.downPaymentPercent) < 0;
  }

}
