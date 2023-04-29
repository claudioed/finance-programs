package tech.claudioed.domain.request.services;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.transaction.Transactional;
import tech.claudioed.domain.request.FinanceConditionProposal;
import tech.claudioed.domain.request.FinanceConditionProposalId;
import tech.claudioed.domain.request.events.ApprovalRequested;
import tech.claudioed.domain.request.repositories.ApprovalUserRepository;
import tech.claudioed.domain.request.repositories.FinanceConditionApprovalsRepository;
import tech.claudioed.domain.request.repositories.FinanceConditionProposalRepository;
import tech.claudioed.port.inputs.request.FinanceConditionApprovalComment;
import tech.claudioed.port.inputs.request.FinanceConditionRequest;

@ApplicationScoped
public class FinanceConditionProposalRequestService {

  private final ApprovalUserRepository approvalUserRepository;

  private final FinanceConditionProposalRepository financeConditionProposalRepository;

  private final FinanceConditionApprovalsRepository financeConditionApprovalsRepository;

  private final Event<ApprovalRequested> approvals;

  public FinanceConditionProposalRequestService(ApprovalUserRepository approvalUserRepository,
      FinanceConditionProposalRepository financeConditionProposalRepository,
      FinanceConditionApprovalsRepository financeConditionApprovalsRepository, Event<ApprovalRequested> approvals) {
    this.approvalUserRepository = approvalUserRepository;
    this.financeConditionProposalRepository = financeConditionProposalRepository;
    this.financeConditionApprovalsRepository = financeConditionApprovalsRepository;
    this.approvals = approvals;
  }

  @Transactional
  public FinanceConditionProposal registerRequest(FinanceConditionRequest request){
    var proposal =  new FinanceConditionProposal(request.getName(),request.getNotes(),request.getFactoryRequest(),request.getDealerRequest(),request.getFlatRequest(),request.getMaxTimeLoan(),request.getTargets(),request.getPeriod(),request.getInterestRate());
    var approvers = this.approvalUserRepository.requiredApprovals(proposal);
    proposal.configApprovers(approvers.stream().map(ap -> ap.getId().toString()).collect(Collectors.toSet()));
    this.financeConditionProposalRepository.persist(proposal);
    approvers.stream().map(ap -> new ApprovalRequested(ap,proposal, LocalDateTime.now())).forEach(this.approvals::fire);
    return proposal;
  }

  public void approve(String id , FinanceConditionApprovalComment comment){
    var proposal = this.financeConditionApprovalsRepository.get(new FinanceConditionProposalId(id));
    proposal.addApproval(comment);
  }

}
