package tech.claudioed.domain.request.services;

import tech.claudioed.domain.request.events.ApprovalRequested;

public interface NotificationService {

  void triggerApproval(ApprovalRequested approvalRequested);

}
