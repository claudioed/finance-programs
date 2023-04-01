package tech.claudioed.domain.financecondition.services;

import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.money.Monetary;
import javax.transaction.Transactional;
import tech.claudioed.domain.financecondition.FinanceCondition;
import tech.claudioed.domain.financecondition.repositories.FinanceConditionRepository;
import tech.claudioed.domain.financecondition.specification.FinanceConditionValidationContext;
import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.flat.repositories.FlatRepository;
import tech.claudioed.domain.flat.specification.CreditDeliveryFlatValidationContext;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.domain.subsidy.SubsidyType;
import tech.claudioed.domain.subsidy.repositories.SubsidyRepository;
import tech.claudioed.domain.subsidy.specification.CreditDeliverySubsidyValidationContext;
import tech.claudioed.port.inputs.FinanceProgramQuery;
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
    var financeCondition = new FinanceCondition(request.getName(),request.getMaxTimeLoan(),request.getPeriod(),request.isOneTimeUsage(),
        request.getTargets(),request.getInterestRate(),request.getDownPaymentRequirements(),maxAmount);
    if (!request.preRegisteredFlat()){
      var flat = new Flat(request.getFlat().getName(),request.getTargets(),request.getFlat().getRate(),request.getPeriod());
      financeCondition.configFlat(flat);
    }else {
      var flat = this.flatRepository.get(request.getFlat().getFlatId());
      financeCondition.configFlat(flat.get());
    }

    if (!request.preRegisteredFactorySubsidy()){
      var subsidy = new Subsidy(request.getPeriod(),request.getFactorySubsidy().getRate(),request.getTargets(),request.getMaxTimeLoan(),request.getFactorySubsidy().getName(), SubsidyType.FACTORY);
      financeCondition.configFactorySubsidy(subsidy);
    }else {
      var subsidy = this.subsidyRepository.get(request.getFactorySubsidy().getId());
      financeCondition.configFactorySubsidy(subsidy.get());
    }
    var dealerSubsidy = new Subsidy(request.getPeriod(),request.getDealerSubsidy().getRate(),request.getTargets(),request.getMaxTimeLoan(),request.getDealerSubsidy().getName(), SubsidyType.DEALER);
    financeCondition.configDealerSubsidy(dealerSubsidy);
    this.financeConditionRepository.persist(financeCondition);
    return financeCondition;
  }

  public List<FinanceCondition> find(FinanceProgramQuery arguments){
    var conditions = this.financeConditionRepository.currents(LocalDate.now());
    return conditions.stream()
        .filter(cnd -> new FinanceConditionValidationContext(arguments,cnd).isSatisfied())
        .filter(cnd -> new CreditDeliverySubsidyValidationContext(arguments,cnd.getFactorySubsidy()).isSatisfied())
        .filter(cnd -> new CreditDeliveryFlatValidationContext(arguments,cnd.getFlat()).isSatisfied()).toList();
  }

  public List<FinanceCondition> findDealersConditions(FinanceProgramQuery arguments){
    return List.of();
  }

}
