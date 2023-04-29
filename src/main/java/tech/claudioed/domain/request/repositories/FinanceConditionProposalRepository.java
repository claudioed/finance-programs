package tech.claudioed.domain.request.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.request.FinanceConditionProposal;

@ApplicationScoped
public class FinanceConditionProposalRepository implements PanacheRepository<FinanceConditionProposal> {

  public FinanceConditionProposal get(String id){
    return null;
  }

}
