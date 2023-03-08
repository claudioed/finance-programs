package tech.claudioed.domain;


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
import tech.claudioed.domain.shared.Interval;
import tech.claudioed.domain.shared.Targets;

@Entity
@Table(name = "flats")
public class Flat {
  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private String id;

  private String name;
  @OneToOne(cascade = CascadeType.ALL)
  private Targets targets;
  private BigDecimal rate;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="start",column=@Column(name="start_date")),
      @AttributeOverride(name="end",column=@Column(name="end_date"))
  })
  private Interval period;

  public Flat(){}

  public Flat(String name, Targets targets, BigDecimal rate,Interval period) {
    this.name = name;
    this.targets = targets;
    this.rate = rate;
    this.period = period;
  }
  public Targets getTargets() {
    return targets;
  }
  public BigDecimal getRate() {
    return rate;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Interval getPeriod() {
    return period;
  }

}
