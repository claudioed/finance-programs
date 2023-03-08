package tech.claudioed.domain.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.Subsidy;

@ApplicationScoped
public class SubsidyRepository implements PanacheRepository<Subsidy> {

  public List<Subsidy> currentSubsidies(LocalDate current){
    //find("start_date <= :current and end_date >= :current ", Parameters.with("current", current).and("current",current)).stream().toList();
    return findAll().stream().toList();
  }

}
