package tech.claudioed.domain.request.events;

import tech.claudioed.domain.request.ApprovalUser;
import tech.claudioed.domain.request.FinanceConditionProposal;

public record ApprovalRequest(ApprovalUser user, FinanceConditionProposal proposal) {}
