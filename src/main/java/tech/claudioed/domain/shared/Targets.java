package tech.claudioed.domain.shared;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "targets")
public class Targets {

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private String id;

  @ElementCollection
  private Set<String> dealers;
  @ElementCollection
  private Set<String> products;

  @ElementCollection
  private Set<String> productFamilies;
  @ElementCollection
  private Set<String> customers;

  @ElementCollection
  private Set<String> cultures;

  public Set<String> getDealers() {
    return dealers;
  }

  public Set<String> getProductFamilies() {
    return productFamilies;
  }

  public Set<String> getProducts() {
    return products;
  }

  public Set<String> getCustomers() {
    return customers;
  }

  public String getId() {
    return id;
  }

  public Set<String> getCultures() {
    return cultures;
  }

}
