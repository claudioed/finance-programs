package load.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import tech.claudioed.domain.financecondition.DownPaymentRequirements;
import tech.claudioed.domain.shared.Amount;
import tech.claudioed.domain.shared.Duration;
import tech.claudioed.domain.shared.Interval;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.domain.shared.PeriodUnit;
import tech.claudioed.domain.shared.Targets;
import tech.claudioed.port.inputs.financecondition.FlatInformation;
import tech.claudioed.port.inputs.financecondition.NewFinanceCondition;
import tech.claudioed.port.inputs.financecondition.SubsidyInformation;

public class FinanceConditionDataLoader {

  private static final Set<String> cultures = Set.of("corn","cotton","soy","sugar-cane");

  private static final Set<String> dealers = Set.of("1040","1050","1060");

  private static final Set<String> customers = Set.of("2040","2050","2060");

  private static final  Map<String, List<String>> catalog = Map.of(
      "5E Series" ,List.of("5055E", "5065E", "5075E", "5076E"),
      "3E Series",List.of("3038E"),
      "6B Series",List.of("6095B", "6120B", "6135B"),
      "7J Series" ,List.of("7200J", "7215J", "7230J")
  );

  public static List<NewFinanceCondition> loadProducts(){
    List<NewFinanceCondition> conditions = new ArrayList<>();
    for (String culture : cultures){
      for (int i = 0; i < 6; i++) {
        for(String family : catalog.keySet()){
          for(String product : catalog.get(family) ){
            var name = UUID.randomUUID().toString();
            var request = new NewFinanceCondition();
            var targets = new Targets();
            targets.addCulture(culture);
            targets.addCustomer("*");
            targets.addProduct(product);
            targets.addDealer("*");
            request.setTargets(targets);
            request.setName(name);
            request.setSegment(MarketSegment.AGRICULTURE);
            var target = generateRandomBigDecimalFromRange(BigDecimal.valueOf(10),BigDecimal.valueOf(20));
            var values = new Values(target);
            var factorySubsidy = new SubsidyInformation(name,values.factorySubsidy);
            var dealerSubsidy = new SubsidyInformation(name,values.dealerSubsidy);
            var flat = new FlatInformation(name,values.flat);
            request.setInterestRate(values.interestRate);
            request.setDealerSubsidy(dealerSubsidy);
            request.setFactorySubsidy(factorySubsidy);
            request.setFlat(flat);
            request.setCampaign(false);
            request.setOneTimeUsage(false);
            request.setMaxTimeLoan(random(1,60));
            request.setMaxAmount(newAmount());
            var dates = new Dates(LocalDate.now(),i);
            request.setContractingLimit(dates.contractLimiting);
            request.setPeriod(dates.period);
            request.setDownPaymentRequirements(requirements(dates.contractLimiting.getEnd()));
            targets.addProductFamily(family);
            conditions.add(request);
          }
        }
      }
    }
    return conditions;
  }


  public static List<NewFinanceCondition> loadProductFamilies(){
    List<NewFinanceCondition> conditions = new ArrayList<>();
    for (String culture : cultures){
      for (int i = 0; i < 6; i++) {
        for(String family : catalog.keySet()){
          var name = UUID.randomUUID().toString();
          var request = new NewFinanceCondition();
          var targets = new Targets();
          targets.addCulture(culture);
          targets.addCustomer("*");
          targets.addProduct("*");
          targets.addDealer("*");
          request.setTargets(targets);
          request.setName(name);
          request.setSegment(MarketSegment.AGRICULTURE);
          var target = generateRandomBigDecimalFromRange(BigDecimal.valueOf(10),BigDecimal.valueOf(20));
          var values = new Values(target);
          var factorySubsidy = new SubsidyInformation(name,values.factorySubsidy);
          var dealerSubsidy = new SubsidyInformation(name,values.dealerSubsidy);
          var flat = new FlatInformation(name,values.flat);
          request.setInterestRate(values.interestRate);
          request.setDealerSubsidy(dealerSubsidy);
          request.setFactorySubsidy(factorySubsidy);
          request.setFlat(flat);
          request.setCampaign(false);
          request.setOneTimeUsage(false);
          request.setMaxTimeLoan(random(1,60));
          request.setMaxAmount(newAmount());
          var dates = new Dates(LocalDate.now(),i);
          request.setContractingLimit(dates.contractLimiting);
          request.setPeriod(dates.period);
          request.setDownPaymentRequirements(requirements(dates.contractLimiting.getEnd()));
          targets.addProductFamily(family);
          conditions.add(request);
        }
      }
    }
    return conditions;
  }

  public static List<NewFinanceCondition> loadCustomers(){
    List<NewFinanceCondition> conditions = new ArrayList<>();
    for (String culture : cultures){
      for (int i = 0; i < 6; i++) {
        for(String family : catalog.keySet()){
          for(String customer : customers){
            var name = UUID.randomUUID().toString();
            var request = new NewFinanceCondition();
            var targets = new Targets();
            targets.addCulture(culture);
            targets.addCustomer(customer);
            targets.addProduct("*");
            targets.addDealer("*");
            request.setTargets(targets);
            request.setName(name);
            request.setSegment(MarketSegment.AGRICULTURE);
            var target = generateRandomBigDecimalFromRange(BigDecimal.valueOf(10),BigDecimal.valueOf(20));
            var values = new Values(target);
            var factorySubsidy = new SubsidyInformation(name,values.factorySubsidy);
            var dealerSubsidy = new SubsidyInformation(name,values.dealerSubsidy);
            var flat = new FlatInformation(name,values.flat);
            request.setInterestRate(values.interestRate);
            request.setDealerSubsidy(dealerSubsidy);
            request.setFactorySubsidy(factorySubsidy);
            request.setFlat(flat);
            request.setCampaign(false);
            request.setOneTimeUsage(false);
            request.setMaxTimeLoan(random(1,60));
            request.setMaxAmount(newAmount());
            var dates = new Dates(LocalDate.now(),i);
            request.setContractingLimit(dates.contractLimiting);
            request.setPeriod(dates.period);
            request.setDownPaymentRequirements(requirements(dates.contractLimiting.getEnd()));
            targets.addProductFamily(family);
            conditions.add(request);
          }
        }
      }
    }
    return conditions;
  }

  public static List<NewFinanceCondition> loadDealers(){
    List<NewFinanceCondition> conditions = new ArrayList<>();
    for (String culture : cultures){
      for (int i = 0; i < 6; i++) {
        for(String family : catalog.keySet()){
          for(String dealer : dealers){
            var name = UUID.randomUUID().toString();
            var request = new NewFinanceCondition();
            var targets = new Targets();
            targets.addCulture(culture);
            targets.addCustomer("*");
            targets.addProduct("*");
            targets.addDealer(dealer);
            request.setTargets(targets);
            request.setName(name);
            request.setSegment(MarketSegment.AGRICULTURE);
            var target = generateRandomBigDecimalFromRange(BigDecimal.valueOf(10),BigDecimal.valueOf(20));
            var values = new Values(target);
            var factorySubsidy = new SubsidyInformation(name,values.factorySubsidy);
            var dealerSubsidy = new SubsidyInformation(name,values.dealerSubsidy);
            var flat = new FlatInformation(name,values.flat);
            request.setInterestRate(values.interestRate);
            request.setDealerSubsidy(dealerSubsidy);
            request.setFactorySubsidy(factorySubsidy);
            request.setFlat(flat);
            request.setCampaign(false);
            request.setOneTimeUsage(false);
            request.setMaxTimeLoan(random(1,60));
            request.setMaxAmount(newAmount());
            var dates = new Dates(LocalDate.now(),i);
            request.setContractingLimit(dates.contractLimiting);
            request.setPeriod(dates.period);
            request.setDownPaymentRequirements(requirements(dates.contractLimiting.getEnd()));
            targets.addProductFamily(family);
            conditions.add(request);
          }
        }
      }
    }
    return conditions;
  }

  public static class Dates{

    private final Interval period;

    private final Interval contractLimiting;

    public Dates(LocalDate basis,int months){
      var period = basis.plusMonths(months);
      YearMonth month = YearMonth.from(period);
      this.period = new Interval(month.atDay(1),month.atEndOfMonth());
      this.contractLimiting =new Interval(month.atDay(1),month.atEndOfMonth());
    }

    public Interval getContractLimiting() {
      return contractLimiting;
    }

    public Interval getPeriod() {
      return period;
    }
  }


  public static class Values {

    private final BigDecimal factorySubsidy;

    private final BigDecimal dealerSubsidy;

    private final BigDecimal interestRate;

    private final BigDecimal flat;

    public Values(BigDecimal target) {
      var max = target.divide(BigDecimal.valueOf(4), RoundingMode.HALF_UP);
      this.factorySubsidy = generateRandomBigDecimalFromRange(BigDecimal.ONE,max);
      this.dealerSubsidy = generateRandomBigDecimalFromRange(BigDecimal.ONE,max);
      this.interestRate = generateRandomBigDecimalFromRange(BigDecimal.ONE,max);
      this.flat = generateRandomBigDecimalFromRange(BigDecimal.ONE,max);
    }

    public BigDecimal getFactorySubsidy() {
      return factorySubsidy;
    }

    public BigDecimal getDealerSubsidy() {
      return dealerSubsidy;
    }

    public BigDecimal getInterestRate() {
      return interestRate;
    }

    public BigDecimal getFlat() {
      return flat;
    }

  }

  public static BigDecimal generateRandomBigDecimalFromRange(BigDecimal min, BigDecimal max) {
    BigDecimal randomBigDecimal = min.add(BigDecimal.valueOf(Math.random()).multiply(max.subtract(min)));
    return randomBigDecimal.setScale(2, RoundingMode.HALF_UP);
  }

  public static Duration random(int min,int max){
    var minRan = new Random();
    int cMin = minRan.nextInt(min) + max;
    var maxRan = new Random();
    int cMax = maxRan.nextInt(cMin) + max;
    return new Duration(min,cMax, PeriodUnit.MONTH);
  }

  public static Amount newAmount(){
    return new Amount("BRL", 1000000000.0);
  }

  public static DownPaymentRequirements requirements(LocalDate date){
    return new DownPaymentRequirements(BigDecimal.TEN,date);
  }

}
