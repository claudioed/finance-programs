package tech.claudioed.domain.request.events;

import java.time.LocalDateTime;
import tech.claudioed.domain.request.ApprovalUser;
import tech.claudioed.domain.request.FinanceConditionProposal;

public record ApprovalRequested(ApprovalUser user, FinanceConditionProposal proposal, LocalDateTime at) {}
