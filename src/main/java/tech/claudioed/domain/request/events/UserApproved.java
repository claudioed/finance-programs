package tech.claudioed.domain.request.events;

import java.time.LocalDateTime;
import tech.claudioed.domain.shared.event.DomainEvent;

public record UserApproved(String userId, String email, String notes, LocalDateTime at) implements
    DomainEvent { }
