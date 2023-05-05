package tech.claudioed.domain.analysis.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.analysis.CreditApplicationAnalysis;
import tech.claudioed.domain.financecondition.FinanceCondition;

@ApplicationScoped
public class CreditApplicationAnalysisRepository implements PanacheRepository<CreditApplicationAnalysis> {

  public List<CreditApplicationAnalysis> analysisFromApplication(String id){
    return find("creditApplicationId.id",id).stream().toList();
  }

}
