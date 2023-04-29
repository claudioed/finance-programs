package tech.claudioed.domain.request.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import tech.claudioed.domain.request.events.ApprovalRequested;

@ApplicationScoped
public class ApprovalService {

  private final NotificationService notificationService;

  public ApprovalService(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  void triggerApproval(@Observes ApprovalRequested task) {
    this.notificationService.triggerApproval(task);
  }

}
