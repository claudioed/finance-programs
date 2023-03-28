package tech.claudioed.domain.request.services;

import tech.claudioed.domain.request.events.ApprovalRequest;

public interface NotificationService {

  void triggerApproval(ApprovalRequest approvalRequest);

}
