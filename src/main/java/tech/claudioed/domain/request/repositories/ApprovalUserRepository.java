package tech.claudioed.domain.request.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.request.ApprovalUser;
import tech.claudioed.domain.request.FinanceConditionProposal;

@ApplicationScoped
public class ApprovalUserRepository implements PanacheRepository<ApprovalUser> {

  public List<ApprovalUser> requiredApprovals(FinanceConditionProposal proposal){
    return List.of();
  }

}
