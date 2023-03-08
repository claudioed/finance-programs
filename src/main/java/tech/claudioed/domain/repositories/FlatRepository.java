package tech.claudioed.domain.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.Flat;
@ApplicationScoped
public class FlatRepository implements PanacheRepository<Flat> {

  public List<Flat> currentFlats(LocalDate current){
    //find("start_date <= :current and end_date >= :current ", Parameters.with("current", current).and("current",current)).stream().toList();
    return findAll().stream().toList();
  }

}
