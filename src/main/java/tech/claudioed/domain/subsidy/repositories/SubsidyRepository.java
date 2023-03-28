package tech.claudioed.domain.subsidy.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.subsidy.Subsidy;

@ApplicationScoped
public class SubsidyRepository implements PanacheRepository<Subsidy> {

  public List<Subsidy> currentSubsidies(LocalDate current){
    //find("start_date <= :current and end_date >= :current ", Parameters.with("current", current).and("current",current)).stream().toList();
    return findAll().stream().toList();
  }

  public Optional<Subsidy> get(String id){
    return Optional.of(find("id = :id", Parameters.with("id", UUID.fromString(id))).firstResult());
  }

}
