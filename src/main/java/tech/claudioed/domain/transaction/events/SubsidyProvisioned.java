package tech.claudioed.domain.transaction.events;

import java.time.LocalDateTime;
import tech.claudioed.domain.analysis.FinanceConditionId;
import tech.claudioed.domain.shared.event.DomainEvent;
import tech.claudioed.domain.transaction.CreditApplication;
import tech.claudioed.domain.transaction.SubsidyId;

public record SubsidyProvisioned(FinanceConditionId financeCondition, SubsidyId subsidy, CreditApplication application,
                                 LocalDateTime at) implements
    DomainEvent {}
