package tech.claudioed.adapter.http;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tech.claudioed.domain.request.FinanceConditionProposal;
import tech.claudioed.domain.request.services.FinanceConditionProposalRequestService;
import tech.claudioed.port.inputs.request.FinanceConditionApprovalComment;
import tech.claudioed.port.inputs.request.FinanceConditionRequest;

@Path("/finance-condition-requests")
public class FinanceConditionRequestController {

  private final FinanceConditionProposalRequestService financeConditionProposalRequestService;

  public FinanceConditionRequestController(
      FinanceConditionProposalRequestService financeConditionProposalRequestService) {
    this.financeConditionProposalRequestService = financeConditionProposalRequestService;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public FinanceConditionProposal register(FinanceConditionRequest request){
    return this.financeConditionProposalRequestService.registerRequest(request);
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/{id}/approvals")
  public void approve(@PathParam("id")String id ,FinanceConditionApprovalComment comment){

  }

}
