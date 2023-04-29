package tech.claudioed.domain.financecondition.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.financecondition.CreditDeliveryQuery;
import tech.claudioed.domain.financecondition.DealerQuery;
import tech.claudioed.domain.financecondition.FinanceCondition;
import tech.claudioed.domain.financecondition.specification.validation.CreditDeliveryFinanceConditionValidationContextBuilder;
import tech.claudioed.domain.flat.specification.validation.CreditDeliveryFlatValidationContextBuilder;
import tech.claudioed.domain.flat.specification.validation.DealersFlatValidationContextBuilder;
import tech.claudioed.domain.subsidy.specification.validation.CreditDeliverySubsidyValidationContextBuilder;
import tech.claudioed.domain.subsidy.specification.validation.DealersSubsidyValidationContextBuilder;

@ApplicationScoped
public class FinanceConditionRepository implements PanacheRepository<FinanceCondition> {

  private List<FinanceCondition> currents(LocalDate current){
    //find("start_date <= :current and end_date >= :current ", Parameters.with("current", current).and("current",current)).stream().toList();
    return findAll().stream().toList();
  }

  public FinanceCondition get(String id){
    return null;
  }

  public List<FinanceCondition> forDealers(DealerQuery query){
    var conditions = this.currents(query.queriedAt());
    var subsidyValidationContext = new DealersSubsidyValidationContextBuilder().dealerId(query.dealerId()).customerId(query.customerId()).cultureId(query.cultureId()).productFamilyId(query.productFamilyId()).productId(query.productId()).segment(query.segment());
    var flatValidationContext = new DealersFlatValidationContextBuilder().dealerId(query.dealerId()).customerId(query.customerId()).productFamilyId(query.productFamilyId()).productId(query.productId()).segment(query.segment());

    return conditions.stream()
        //.filter(cnd -> new FinanceConditionValidationContext(arguments,cnd).isSatisfied())
        .filter(cnd -> subsidyValidationContext.subsidy(cnd.getFactorySubsidy()).build().isSatisfied())
        .filter(cnd -> flatValidationContext.flat(cnd.getFlat()).build().isSatisfied())
        .toList();

  }

  public List<FinanceCondition> forCreditDelivery(CreditDeliveryQuery query){
    var conditions = this.currents(query.queriedAt());
    var subsidyValidationContext = new CreditDeliverySubsidyValidationContextBuilder().dealerId(query.dealerId()).customerId(query.customerId()).cultureId(query.cultureId()).productFamilyId(query.productFamilyId()).productId(query.productId()).loanTime(query.loanTime()).segment(query.segment());
    var flatValidationContext = new CreditDeliveryFlatValidationContextBuilder().dealerId(query.dealerId()).customerId(query.customerId()).loanTime(query.loanTime()).productFamilyId(query.productFamilyId()).productId(query.productId()).segment(query.segment());
    var financeConditionValidationContext = new CreditDeliveryFinanceConditionValidationContextBuilder().amount(query.amount()).downPayment(query.downPaymentRequirements());
    return conditions.stream()
        .filter(cnd -> financeConditionValidationContext.financeCondition(cnd).build().isSatisfied())
        .filter(cnd -> subsidyValidationContext.subsidy(cnd.getFactorySubsidy()).build().isSatisfied())
        .filter(cnd -> flatValidationContext.flat(cnd.getFlat()).build().isSatisfied())
        .toList();

  }



}
