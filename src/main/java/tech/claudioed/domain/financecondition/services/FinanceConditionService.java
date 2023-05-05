package tech.claudioed.domain.financecondition.services;

import java.util.List;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.money.Monetary;
import javax.transaction.Transactional;
import tech.claudioed.domain.financecondition.CreditDeliveryQuery;
import tech.claudioed.domain.financecondition.DealerQuery;
import tech.claudioed.domain.financecondition.FinanceCondition;
import tech.claudioed.domain.financecondition.FinanceConditionBuilder;
import tech.claudioed.domain.financecondition.repositories.FinanceConditionRepository;
import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.flat.repositories.FlatRepository;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.domain.subsidy.SubsidyType;
import tech.claudioed.domain.subsidy.repositories.SubsidyRepository;
import tech.claudioed.port.inputs.financecondition.NewFinanceCondition;

@ApplicationScoped
public class FinanceConditionService {

  private final SubsidyRepository subsidyRepository;

  private final FlatRepository flatRepository;

  private final FinanceConditionRepository financeConditionRepository;

  public FinanceConditionService(SubsidyRepository subsidyRepository, FlatRepository flatRepository,
      FinanceConditionRepository financeConditionRepository) {
    this.subsidyRepository = subsidyRepository;
    this.flatRepository = flatRepository;
    this.financeConditionRepository = financeConditionRepository;
  }

  @Transactional
  public FinanceCondition newFinanceCondition(NewFinanceCondition request){
    var maxAmount = Monetary.getDefaultAmountFactory()
        .setCurrency(Monetary.getCurrency(request.getMaxAmount().getCurrency()))
        .setNumber(request.getMaxAmount().getAmount()).create();
    var builder = new FinanceConditionBuilder().name(request.getName()).maxTimeLoan(request.getMaxTimeLoan()).interval(request.getPeriod())
        .oneTimeUsage(request.isOneTimeUsage()).targets(request.getTargets()).interestRate(request.getInterestRate())
        .downPaymentRequirements(request.getDownPaymentRequirements()).monetaryAmount(maxAmount).contractingLimit(request.getContractingLimit())
        .segment(request.getSegment()).financingLineId(request.getFinancingLine());
    if (request.isCampaign()){
      builder.utm(UUID.randomUUID().toString());
    }
    var financeCondition = builder.newFinanceCondition();

    if (!request.preRegisteredFlat()){
      var flat = new Flat(request.getFlat().getName(),request.getTargets(),request.getFlat().getRate(),request.getPeriod(),request.getSegment());
      financeCondition.configFlat(flat);
    }else {
      var flat = this.flatRepository.get(request.getFlat().getFlatId());
      financeCondition.configFlat(flat.get());
    }

    if (!request.preRegisteredFactorySubsidy()){
      var subsidy = new Subsidy(request.getPeriod(),request.getFactorySubsidy().getRate(),request.getTargets(),request.getMaxTimeLoan(),request.getFactorySubsidy().getName(), SubsidyType.FACTORY,request.getSegment());
      financeCondition.configFactorySubsidy(subsidy);
    }else {
      var subsidy = this.subsidyRepository.get(request.getFactorySubsidy().getId());
      financeCondition.configFactorySubsidy(subsidy.get());
    }
    var dealerSubsidy = new Subsidy(request.getPeriod(),request.getDealerSubsidy().getRate(),request.getTargets(),request.getMaxTimeLoan(),request.getDealerSubsidy().getName(), SubsidyType.DEALER,request.getSegment());
    financeCondition.configDealerSubsidy(dealerSubsidy);
    this.financeConditionRepository.persist(financeCondition);
    return financeCondition;
  }

  public List<FinanceCondition> dealersQuery(DealerQuery dealerQuery){
    return this.financeConditionRepository.forDealers(dealerQuery);
  }

  public List<FinanceCondition> creditDeliveryQuery(CreditDeliveryQuery query){
    return this.financeConditionRepository.forCreditDelivery(query);
  }

  public List<FinanceCondition> financeConditions(){
    return this.financeConditionRepository.listAll();
  }

}
