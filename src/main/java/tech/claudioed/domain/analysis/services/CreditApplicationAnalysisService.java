package tech.claudioed.domain.analysis.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import tech.claudioed.domain.analysis.AnalysisResult;
import tech.claudioed.domain.analysis.CreditApplicationAnalysis;
import tech.claudioed.domain.analysis.CreditApplicationId;
import tech.claudioed.domain.analysis.FinanceConditionId;
import tech.claudioed.domain.analysis.repositories.CreditApplicationAnalysisRepository;
import tech.claudioed.domain.financecondition.CreditDeliveryQuery;
import tech.claudioed.domain.financecondition.repositories.FinanceConditionRepository;
import tech.claudioed.domain.financecondition.specification.validation.CreditDeliveryFinanceConditionValidationContextBuilder;
import tech.claudioed.domain.flat.specification.validation.CreditDeliveryFlatValidationContextBuilder;
import tech.claudioed.domain.subsidy.specification.validation.CreditDeliverySubsidyValidationContextBuilder;
import tech.claudioed.port.inputs.analysis.CreditApplicationAnalysisRequest;

@ApplicationScoped
public class CreditApplicationAnalysisService {

  private final FinanceConditionRepository financeConditionRepository;

  private final CreditApplicationAnalysisRepository creditApplicationAnalysisRepository;

  public CreditApplicationAnalysisService(FinanceConditionRepository financeConditionRepository,
      CreditApplicationAnalysisRepository creditApplicationAnalysisRepository) {
    this.financeConditionRepository = financeConditionRepository;
    this.creditApplicationAnalysisRepository = creditApplicationAnalysisRepository;
  }

  @Transactional
  public AnalysisResult analyze(CreditApplicationAnalysisRequest request){
    var condition = this.financeConditionRepository.get(request.getFinanceCondition());
    var query  = new CreditDeliveryQuery(request.dealerId(),request.productFamilyId(),request.productId(),request.customerId(),request.cultureId(),request.ratingId(),request.getApplication()
        .getLoanTime(),request.getSegment(),LocalDate.now(),request.getApplication()
        .getDownPayment(),request.getApplication().amount(),request.getUtm());
    var subsidyValidationContext = new CreditDeliverySubsidyValidationContextBuilder().dealerId(query.dealerId()).customerId(query.customerId()).cultureId(query.cultureId()).productFamilyId(query.productFamilyId()).productId(query.productId()).loanTime(query.loanTime()).segment(query.segment()).subsidy(condition.getFactorySubsidy()).build();
    var flatValidationContext = new CreditDeliveryFlatValidationContextBuilder().dealerId(query.dealerId()).customerId(query.customerId()).loanTime(query.loanTime()).productFamilyId(query.productFamilyId()).productId(query.productId()).segment(query.segment()).flat(condition.getFlat()).build();
    var financeConditionValidationContext = new CreditDeliveryFinanceConditionValidationContextBuilder().amount(query.amount()).downPayment(query.downPaymentRequirements()).financeCondition(condition).build();
    if (subsidyValidationContext.isSatisfied() && flatValidationContext.isSatisfied() && financeConditionValidationContext.isSatisfied()){
      var analysis = CreditApplicationAnalysis.newApproved(new CreditApplicationId(request.getApplication().getId()),new FinanceConditionId(request.getFinanceCondition()));
      this.creditApplicationAnalysisRepository.persist(analysis);
      return new AnalysisResult(analysis, List.of());
    }else {
      var options = this.financeConditionRepository.forCreditDelivery(query);
      var messages = new ArrayList<String>();
      messages.addAll(financeConditionValidationContext.messages());
      messages.addAll(subsidyValidationContext.messages());
      messages.addAll(flatValidationContext.messages());
      var analysis = CreditApplicationAnalysis.newDeclined(new CreditApplicationId(request.getApplication().getId()),new FinanceConditionId(request.getFinanceCondition()),messages);
      this.creditApplicationAnalysisRepository.persist(analysis);
      return new AnalysisResult(analysis, options);
    }
  }

  public List<CreditApplicationAnalysis> analysisFromApplication(CreditApplicationId applicationId){
    return this.creditApplicationAnalysisRepository.analysisFromApplication(applicationId.getId());
  }

}
