package tech.claudioed.domain.shared;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
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
  @NotEmpty
  private Set<String> dealers = new HashSet<>();
  @ElementCollection
  @NotEmpty
  private Set<String> products = new HashSet<>();

  @ElementCollection
  @NotEmpty
  private Set<String> productFamilies =new HashSet<>();
  @ElementCollection
  @NotEmpty
  private Set<String> customers =new HashSet<>();

  @ElementCollection
  @NotEmpty
  private Set<String> cultures = new HashSet<>();

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
  public boolean addCulture(String culture){
    return this.cultures.add(culture);
  }

  public boolean addProductFamily(String productFamily){
    return this.productFamilies.add(productFamily);
  }

  public boolean addProduct(String product){
    return this.products.add(product);
  }

  public boolean addCustomer(String customer){
    return this.customers.add(customer);
  }

  public boolean addDealer(String dealer){
    return this.dealers.add(dealer);
  }

}
