package tech.claudioed.domain.transaction;

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
import tech.claudioed.domain.analysis.FinanceConditionId;

@Entity
@Table(name = "transactions")
public class Transaction {

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="id",column=@Column(name="finance_condition_id")),
  })
  private FinanceConditionId financeCondition;
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="id",column=@Column(name="subsidy_id")),
  })
  private SubsidyId subsidy;
  @Column(name = "registered_at")
  private LocalDateTime registeredAt;
  private Status status;
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="id",column=@Column(name="application_id")),
  })
  private CreditApplication application;
  public Transaction(){}

  private Transaction(FinanceConditionId financeCondition, SubsidyId subsidy,
      CreditApplication application,Status status) {
    this.financeCondition = financeCondition;
    this.subsidy = subsidy;
    this.application = application;
    this.registeredAt = LocalDateTime.now();
    this.status = status;
  }

  public static Transaction newCompleted(FinanceConditionId financeCondition, SubsidyId subsidy,
      CreditApplication application){
    return new Transaction(financeCondition,subsidy,application,Status.COMPLETED);
  }
  public static Transaction newRegistered(FinanceConditionId financeCondition, SubsidyId subsidy,
      CreditApplication application){
    return new Transaction(financeCondition,subsidy,application,Status.REGISTERED);
  }

  public UUID getId() {
    return id;
  }

  public FinanceConditionId getFinanceCondition() {
    return financeCondition;
  }

  public SubsidyId getSubsidy() {
    return subsidy;
  }

  public LocalDateTime getRegisteredAt() {
    return registeredAt;
  }

  public Status getStatus() {
    return status;
  }

  public CreditApplication getApplication() {
    return application;
  }

}
