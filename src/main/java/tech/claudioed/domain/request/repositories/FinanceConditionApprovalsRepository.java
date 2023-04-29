package tech.claudioed.domain.request.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.request.FinanceConditionApprovals;
import tech.claudioed.domain.request.FinanceConditionProposal;
import tech.claudioed.domain.request.FinanceConditionProposalId;

@ApplicationScoped
public class FinanceConditionApprovalsRepository implements PanacheRepository<FinanceConditionApprovals> {

  public FinanceConditionApprovals get(FinanceConditionProposalId id){
    return null;
  }

}
