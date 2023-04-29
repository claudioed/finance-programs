package tech.claudioed.domain.analysis;

import java.time.LocalDate;
import java.time.LocalDateTime;
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



}
