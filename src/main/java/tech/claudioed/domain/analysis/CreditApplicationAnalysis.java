package tech.claudioed.domain.analysis;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "credit_application_analysis")
public class CreditApplicationAnalysis {

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="id",column=@Column(name="credit_application_id"))
  })
  private CreditApplicationId creditApplicationId;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="id",column=@Column(name="finance_condition_id"))
  })
  private FinanceConditionId financeConditionId;

  private LocalDateTime analyzedAt;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="success",column=@Column(name="status_success")),
      @AttributeOverride(name="notes",column=@Column(name="status_notes"))
  })
  private AnalysisStatus status;

  public CreditApplicationAnalysis(){}

  private CreditApplicationAnalysis(CreditApplicationId creditApplicationId,
      FinanceConditionId financeConditionId, AnalysisStatus status) {
    this.creditApplicationId = creditApplicationId;
    this.financeConditionId = financeConditionId;
    this.status = status;
    this.analyzedAt = LocalDateTime.now();
  }

  public static CreditApplicationAnalysis newApproved(CreditApplicationId creditApplicationId,
      FinanceConditionId financeConditionId){
    return new CreditApplicationAnalysis(creditApplicationId,financeConditionId,new AnalysisStatus(true, List.of()));
  }

  public static CreditApplicationAnalysis newDeclined(CreditApplicationId creditApplicationId,
      FinanceConditionId financeConditionId,List<String> notes){
    return new CreditApplicationAnalysis(creditApplicationId,financeConditionId,new AnalysisStatus(false,notes));
  }

  public UUID getId() {
    return id;
  }

  public CreditApplicationId getCreditApplicationId() {
    return creditApplicationId;
  }

  public FinanceConditionId getFinanceConditionId() {
    return financeConditionId;
  }

  public LocalDateTime getAnalyzedAt() {
    return analyzedAt;
  }

  public AnalysisStatus getStatus() {
    return status;
  }
}
