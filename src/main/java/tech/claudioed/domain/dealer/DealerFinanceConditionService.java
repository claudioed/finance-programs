package tech.claudioed.domain.dealer;

import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.dealer.specification.DealerFlatValidationContext;
import tech.claudioed.domain.dealer.specification.DealerSubsidyValidationContext;
import tech.claudioed.domain.financecondition.DealerQuery;
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

  public List<FinanceCondition> find(DealerQuery query){
    List<FinanceCondition> conditions = this.financeConditionRepository.forDealers(query);
    return conditions.stream()
        .filter(cnd -> new DealerFlatValidationContext(query.dealerId(),query.customerId(),query.productId(),query.productFamilyId()).isSatisfiedBy(cnd.getFlat()))
        .filter(cnd -> new DealerSubsidyValidationContext(query.dealerId(),query.customerId(),query.productId(),query.productFamilyId()).isSatisfiedBy(cnd.getFactorySubsidy())).toList();
  }

}
