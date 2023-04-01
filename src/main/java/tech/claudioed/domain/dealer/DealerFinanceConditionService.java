package tech.claudioed.domain.dealer;

import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.dealer.specification.DealerFlatValidationContext;
import tech.claudioed.domain.dealer.specification.DealerSubsidyValidationContext;
import tech.claudioed.domain.financecondition.FinanceCondition;
import tech.claudioed.domain.financecondition.repositories.FinanceConditionRepository;
import tech.claudioed.port.inputs.dealer.DealerFinanceConditionQuery;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

@ApplicationScoped
public class DealerFinanceConditionService {

  private final FinanceConditionRepository financeConditionRepository;

  public DealerFinanceConditionService(FinanceConditionRepository financeConditionRepository) {
    this.financeConditionRepository = financeConditionRepository;
  }

  public List<FinanceCondition> find(DealerFinanceConditionQuery request){
    List<FinanceCondition> conditions = this.financeConditionRepository.currents(LocalDate.now());
    var productId = new ProductId(request.productId());
    var productFamilyId = new ProductFamilyId(request.productLineId());
    var customerId = new CustomerId(request.customerId());
    var dealerId = new DealerId(request.dealerId());
    return conditions.stream()
        .filter(cnd -> new DealerFlatValidationContext(dealerId,customerId,productId,productFamilyId).isSatisfiedBy(cnd.getFlat()))
        .filter(cnd -> new DealerSubsidyValidationContext(dealerId,customerId,productId,productFamilyId).isSatisfiedBy(cnd.getFactorySubsidy())).toList();
  }

}
