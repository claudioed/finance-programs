package tech.claudioed.domain.financecondition;

import io.hypersistence.utils.hibernate.type.money.MonetaryAmountType;
import java.math.BigDecimal;
import java.util.UUID;
import javax.money.MonetaryAmount;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.TypeDef;
import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.shared.Amount;
import tech.claudioed.domain.shared.Duration;
import tech.claudioed.domain.shared.FinancingLineId;
import tech.claudioed.domain.shared.Interval;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.domain.shared.Targets;
import tech.claudioed.domain.subsidy.Subsidy;

@Entity
@Table(name = "finance_condition")
@TypeDef(typeClass = MonetaryAmountType.class, defaultForType = MonetaryAmount.class)
public class FinanceCondition {

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;

  private String name;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private Subsidy factorySubsidy;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private Subsidy dealerSubsidy;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private Flat flat;

  @Embedded
  private Duration maxTimeLoan;

  private DownPaymentRequirements downPaymentRequirements;

  @OneToOne(cascade = CascadeType.ALL)
  private Targets targets;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="start",column=@Column(name="validity_start_date")),
      @AttributeOverride(name="end",column=@Column(name="validity_end_date"))
  })
  private Interval validity;

  @Column(name = "one_time_usage")
  private boolean oneTimeUsage;

  private BigDecimal interestRate;

  @Columns(columns = {
      @Column(name = "price_amount"),
      @Column(name = "price_currency")
  })
  private MonetaryAmount maxAmount;

  private String utm;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="id",column=@Column(name="financing_line_id"))
  })
  private FinancingLineId financingLineId;

  private MarketSegment segment;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="start",column=@Column(name="contracting_start_date")),
      @AttributeOverride(name="end",column=@Column(name="contracting_end_date"))
  })
  private Interval contractingLimit;

  public FinanceCondition(){}

  FinanceCondition(String name, Duration maxTimeLoan,
      Interval interval, boolean oneTimeUsage,Targets targets,BigDecimal interestRate,DownPaymentRequirements downPaymentRequirements,
      MonetaryAmount monetaryAmount,String utm,MarketSegment segment,FinancingLineId financingLineId,Interval contractingLimit) {
    this.name = name;
    this.maxTimeLoan = maxTimeLoan;
    this.validity = interval;
    this.oneTimeUsage = oneTimeUsage;
    this.targets = targets;
    this.interestRate = interestRate;
    this.downPaymentRequirements = downPaymentRequirements;
    this.maxAmount= monetaryAmount;
    this.utm = utm;
    this.segment = segment;
    this.financingLineId = financingLineId;
    this.contractingLimit = contractingLimit;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Subsidy getFactorySubsidy() {
    return factorySubsidy;
  }

  public Flat getFlat() {
    return flat;
  }

  public Duration getMaxTimeLoan() {
    return maxTimeLoan;
  }

  public Interval getValidity() {
    return validity;
  }

  public boolean isOneTimeUsage() {
    return oneTimeUsage;
  }

  public FinanceCondition configFlat(Flat flat){
    this.flat = flat;
    return this;
  }

  public FinanceCondition configFactorySubsidy(Subsidy subsidy){
    this.factorySubsidy = subsidy;
    return this;
  }

  public FinanceCondition configDealerSubsidy(Subsidy subsidy){
    this.dealerSubsidy = subsidy;
    return this;
  }

  public Targets getTargets() {
    return targets;
  }

  public BigDecimal getInterestRate() {
    return interestRate;
  }

  public DownPaymentRequirements getDownPaymentRequirements() {
    return downPaymentRequirements;
  }

  public Subsidy getDealerSubsidy() {
    return dealerSubsidy;
  }

  public MonetaryAmount getMaxAmount() {
    return maxAmount;
  }

  public Amount toAmount(){
    return new Amount(this.getMaxAmount().getCurrency().getCurrencyCode(),this.getMaxAmount().getNumber().doubleValueExact());
  }

  public String getUtm() {
    return utm;
  }

  public FinancingLineId getFinancingLineId() {
    return financingLineId;
  }

  public MarketSegment getSegment() {
    return segment;
  }

  public Interval getContractingLimit() {
    return contractingLimit;
  }

}
