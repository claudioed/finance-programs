package tech.claudioed.domain.referencerate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import tech.claudioed.domain.shared.Interval;

@Entity
@Table(name = "reference_rates")
public class ReferenceRate {

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private String id;

  private LocalDateTime releasedOn;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="start",column=@Column(name="start_date")),
      @AttributeOverride(name="end",column=@Column(name="end_date"))
  })
  private Interval validPeriod;

  private BigDecimal rate;

  public ReferenceRate(){}

  public ReferenceRate(LocalDateTime releasedOn, Interval validPeriod, BigDecimal rate) {
    this.releasedOn = releasedOn;
    this.validPeriod = validPeriod;
    this.rate = rate;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public String getId() {
    return id;
  }

  public LocalDateTime getReleasedOn() {
    return releasedOn;
  }

  public Interval getValidPeriod() {
    return validPeriod;
  }

}
