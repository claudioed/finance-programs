package tech.claudioed.domain.financecondition.events;

import java.time.LocalDateTime;
import tech.claudioed.domain.analysis.FinanceConditionId;

public record FinanceConditionCreated(FinanceConditionId financeConditionId, LocalDateTime at) { }
