package tech.claudioed.domain.request.events;

import java.time.LocalDateTime;
import tech.claudioed.domain.request.ApprovalUser;
import tech.claudioed.domain.request.FinanceConditionProposal;
import tech.claudioed.domain.shared.event.DomainEvent;

public record ApprovalRequested(ApprovalUser user, FinanceConditionProposal proposal, LocalDateTime at) implements
    DomainEvent {}
