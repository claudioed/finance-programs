package tech.claudioed.domain.financecondition.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.financecondition.FinanceCondition;

@ApplicationScoped
public class FinanceConditionRepository implements PanacheRepository<FinanceCondition> {

  public List<FinanceCondition> currents(LocalDate current){
    //find("start_date <= :current and end_date >= :current ", Parameters.with("current", current).and("current",current)).stream().toList();
    return findAll().stream().toList();
  }

}
