package tech.claudioed.domain.request.services;

import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.transaction.Transactional;
import tech.claudioed.domain.request.FinanceConditionProposal;
import tech.claudioed.domain.request.events.ApprovalRequest;
import tech.claudioed.domain.request.repositories.ApprovalUserRepository;
import tech.claudioed.domain.request.repositories.FinanceConditionProposalRepository;
import tech.claudioed.port.inputs.request.FinanceConditionApprovalComment;
import tech.claudioed.port.inputs.request.FinanceConditionRequest;

@ApplicationScoped
public class FinanceConditionProposalRequestService {

  private final ApprovalUserRepository approvalUserRepository;

  private final FinanceConditionProposalRepository financeConditionProposalRepository;

  private final Event<ApprovalRequest> approvals;

  public FinanceConditionProposalRequestService(ApprovalUserRepository approvalUserRepository,
      FinanceConditionProposalRepository financeConditionProposalRepository,
      Event<ApprovalRequest> approvals) {
    this.approvalUserRepository = approvalUserRepository;
    this.financeConditionProposalRepository = financeConditionProposalRepository;
    this.approvals = approvals;
  }

  @Transactional
  public FinanceConditionProposal registerRequest(FinanceConditionRequest request){
    var proposal =  new FinanceConditionProposal(request.getName(),request.getNotes(),request.getFactoryRequest(),request.getDealerRequest(),request.getFlatRequest(),request.getMaxTimeLoan(),request.getTargets(),request.getPeriod(),request.getInterestRate());
    var approvers = this.approvalUserRepository.requiredApprovals(proposal);
    proposal.configApprovers(approvers.stream().map(ap -> ap.getId().toString()).collect(Collectors.toSet()));
    this.financeConditionProposalRepository.persist(proposal);
    approvers.stream().map(ap -> new ApprovalRequest(ap,proposal)).forEach(this.approvals::fire);
    return proposal;
  }

  public void approve(String id , FinanceConditionApprovalComment comment){

  }

}
