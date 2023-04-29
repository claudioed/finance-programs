package tech.claudioed.domain.request.events;

import java.time.LocalDateTime;

public record UserApproved(String userId, String email, String notes, LocalDateTime at) { }
