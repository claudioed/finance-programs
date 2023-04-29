package tech.claudioed.domain.analysis.services;

import java.time.LocalDate;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.analysis.CreditApplicationAnalysis;
import tech.claudioed.domain.financecondition.CreditDeliveryQuery;
import tech.claudioed.domain.financecondition.repositories.FinanceConditionRepository;
import tech.claudioed.port.inputs.analysis.CreditApplicationAnalysisRequest;

@ApplicationScoped
public class CreditApplicationAnalysisService {

  private final FinanceConditionRepository financeConditionRepository;

  public CreditApplicationAnalysisService(FinanceConditionRepository financeConditionRepository) {
    this.financeConditionRepository = financeConditionRepository;
  }

  public CreditApplicationAnalysis analyze(CreditApplicationAnalysisRequest request){
    var condition = this.financeConditionRepository.get(request.getFinanceCondition());
    var query  = new CreditDeliveryQuery(request.dealerId(),request.productFamilyId(),request.productId(),request.customerId(),request.cultureId(),request.ratingId(),request.getApplication()
        .getLoanTime(),request.getMarketSegment(),LocalDate.now(),request.getApplication()
        .getDownPayment(),request.getApplication().amount(),request.getUtm());
    var conditions = this.financeConditionRepository.forCreditDelivery(query);

    return null;

  }


}
