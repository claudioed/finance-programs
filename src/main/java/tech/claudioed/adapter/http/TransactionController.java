package tech.claudioed.adapter.http;

import io.smallrye.common.constraint.NotNull;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import tech.claudioed.domain.analysis.CreditApplicationId;
import tech.claudioed.domain.transaction.CreditApplication;
import tech.claudioed.domain.transaction.ProvisioningSubsidy;
import tech.claudioed.domain.transaction.services.TransactionService;
import tech.claudioed.port.inputs.transaction.ProvisioningSubsidyCommand;

@Path("/transactions")
@Tag(name = "Transactions", description = "Handle transactions by finance conditions")
public class TransactionController {

  private final TransactionService transactionService;

  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public void registerTransaction(@Valid @NotNull ProvisioningSubsidyCommand command){
    var transaction = this.transactionService.register(new ProvisioningSubsidy(new CreditApplication(new CreditApplicationId(command.getApplication().getId()),command.getApplication().getAmount().toMonetary()),command.getFinanceCondition()));
  }

}
