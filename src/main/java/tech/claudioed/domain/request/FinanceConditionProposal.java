package tech.claudioed.domain.request;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import tech.claudioed.domain.shared.Duration;
import tech.claudioed.domain.shared.Interval;
import tech.claudioed.domain.shared.Targets;


@Entity
@Table(name = "finance_condition_proposal")
public class FinanceConditionProposal {

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;

  private String name;

  private String notes;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="rate",column=@Column(name="factory_subsidy_rate")),
      @AttributeOverride(name="name",column=@Column(name="factory_subsidy_name")),
      @AttributeOverride(name="type",column=@Column(name="factory_subsidy_type"))
  })
  private SubsidyRequest factoryRequest;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="rate",column=@Column(name="dealer_subsidy_rate")),
      @AttributeOverride(name="name",column=@Column(name="dealer_subsidy_name")),
      @AttributeOverride(name="type",column=@Column(name="dealer_subsidy_type"))
  })
  private SubsidyRequest dealerRequest;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="rate",column=@Column(name="flat_rate")),
      @AttributeOverride(name="name",column=@Column(name="flat_name")),
  })
  private FlatRequest flatRequest;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="min",column=@Column(name="duration_min")),
      @AttributeOverride(name="max",column=@Column(name="duration_max")),
      @AttributeOverride(name="unit",column=@Column(name="duration_unit"))
  })
  private Duration maxTimeLoan;

  @OneToOne(cascade = CascadeType.ALL)
  private Targets targets;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="start",column=@Column(name="start_date")),
      @AttributeOverride(name="end",column=@Column(name="end_date"))
  })
  private Interval period;

  private BigDecimal interestRate;

  @ElementCollection
  @CollectionTable(name = "finance_condition_required_approvals")
  private Set<String> requiredApprovals;

  public FinanceConditionProposal(){}

  public FinanceConditionProposal(String name, String notes, SubsidyRequest factoryRequest,
      SubsidyRequest dealerRequest, FlatRequest flatRequest, Duration maxTimeLoan, Targets targets,
      Interval period, BigDecimal interestRate) {
    this.name = name;
    this.notes = notes;
    this.factoryRequest = factoryRequest;
    this.dealerRequest = dealerRequest;
    this.flatRequest = flatRequest;
    this.maxTimeLoan = maxTimeLoan;
    this.targets = targets;
    this.period = period;
    this.interestRate = interestRate;
  }

  public FinanceConditionProposal configApprovers(Set<String> ids){
    this.requiredApprovals = ids;
    return this;
  }

}
