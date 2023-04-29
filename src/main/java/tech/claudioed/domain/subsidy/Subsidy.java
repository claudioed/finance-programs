package tech.claudioed.domain.subsidy;


import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import tech.claudioed.domain.shared.Duration;
import tech.claudioed.domain.shared.Interval;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.domain.shared.Targets;

@Entity
@Table(name = "subsidies")
public class Subsidy {

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private String id;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="start",column=@Column(name="start_date")),
      @AttributeOverride(name="end",column=@Column(name="end_date"))
  })
  private Interval validPeriod;

  private BigDecimal rate;

  @OneToOne(cascade = CascadeType.ALL)
  private Targets target;

  @Embedded
  private Duration maxTimeLoan;

  private String name;

  private SubsidyType type;

  private MarketSegment segment;

  public Subsidy(){}
  public Subsidy(Interval validPeriod, BigDecimal rate, Targets target, Duration maxTimeLoan,String name,SubsidyType type,MarketSegment segment) {
    this.validPeriod = validPeriod;
    this.rate = rate;
    this.target = target;
    this.maxTimeLoan = maxTimeLoan;
    this.name =  name;
    this.type = type;
    this.segment = segment;
  }

  public Targets getTarget() {
    return target;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public String getId() {
    return id;
  }

  public Interval getValidPeriod() {
    return validPeriod;
  }

  public Duration getMaxTimeLoan() {
    return maxTimeLoan;
  }

  public String getName() {
    return name;
  }

  public SubsidyType getType() {
    return type;
  }

  public MarketSegment getSegment() {
    return segment;
  }

}
