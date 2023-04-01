package tech.claudioed.port.outputs.request;

import io.quarkus.logging.Log;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import tech.claudioed.domain.request.events.ApprovalRequest;
import tech.claudioed.domain.request.services.NotificationService;

@ApplicationScoped
public class LogNotificationService implements NotificationService {

  @Override
  public void triggerApproval(@Observes ApprovalRequest approvalRequest) {
    Log.info("New approval request" + approvalRequest.user().getId());
  }

}
