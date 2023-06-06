package tech.claudioed.adapter.http.utils;

import tech.claudioed.domain.financecondition.FinanceCondition;
import tech.claudioed.port.outputs.financecondition.CreditDeliveryFinanceCondition;
import tech.claudioed.port.outputs.financecondition.FinanceConditionData;
import tech.claudioed.port.outputs.flat.FlatData;
import tech.claudioed.port.outputs.subsidy.SubsidyData;

public class FormatFinanceCondition {

  public static CreditDeliveryFinanceCondition forCreditDelivery(FinanceCondition fc){
    var dlSubsidy = new SubsidyData(fc.getDealerSubsidy().getId().toString(),fc.getDealerSubsidy().getName(),fc.getDealerSubsidy().getRate(),fc.getDealerSubsidy().getType().name(),fc.getDealerSubsidy().getMaxTimeLoan().toString());
    var fd = new FlatData(fc.getFlat().getId(),fc.getFlat().getName(),fc.getFlat().getRate());
    return new CreditDeliveryFinanceCondition(fc.getId().toString(),fc.getName(),fc.getInterestRate(),fc.toAmount(),dlSubsidy,fd,fc.getUtm(),fc.getValidity(),fc.getContractingLimit());
  }


  public static FinanceConditionData from(FinanceCondition fc){
    var dlSubsidy = new SubsidyData(fc.getDealerSubsidy().getId().toString(),fc.getDealerSubsidy().getName(),fc.getDealerSubsidy().getRate(),fc.getDealerSubsidy().getType().name(),fc.getDealerSubsidy().getMaxTimeLoan().toString());
    var fcSubsidy = new SubsidyData(fc.getFactorySubsidy().getId().toString(),fc.getFactorySubsidy().getName(),fc.getFactorySubsidy().getRate(),fc.getFactorySubsidy().getType().name(),fc.getFactorySubsidy().getMaxTimeLoan().toString());
    var fd = new FlatData(fc.getFlat().getId(),fc.getFlat().getName(),fc.getFlat().getRate());
    return new FinanceConditionData(fc.getId().toString(),fc.getName(),fc.getInterestRate(),fc.toAmount(),dlSubsidy,fcSubsidy,fd,fc.getUtm(),fc.getValidity(),fc.getContractingLimit());
  }

}
