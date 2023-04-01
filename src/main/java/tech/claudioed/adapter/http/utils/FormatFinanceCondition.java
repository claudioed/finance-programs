package tech.claudioed.adapter.http.utils;

import tech.claudioed.domain.financecondition.FinanceCondition;
import tech.claudioed.port.outputs.financecondition.FinanceConditionData;
import tech.claudioed.port.outputs.flat.FlatData;
import tech.claudioed.port.outputs.subsidy.SubsidyData;

public class FormatFinanceCondition {

  public static FinanceConditionData from(FinanceCondition fc){
    var ftSubsidy = new SubsidyData(fc.getFactorySubsidy().getId(),fc.getFactorySubsidy().getName(),fc.getFactorySubsidy().getRate(),fc.getFactorySubsidy().getType().name(),fc.getFactorySubsidy().getMaxTimeLoan().toString());
    var dlSubsidy = new SubsidyData(fc.getDealerSubsidy().getId(),fc.getDealerSubsidy().getName(),fc.getDealerSubsidy().getRate(),fc.getDealerSubsidy().getType().name(),fc.getDealerSubsidy().getMaxTimeLoan().toString());
    var fd = new FlatData(fc.getFlat().getId(),fc.getFlat().getName(),fc.getFlat().getRate());
    return new FinanceConditionData(fc.getId().toString(),fc.getName(),fc.getInterestRate(),fc.toAmount(),ftSubsidy,dlSubsidy,fd);
  }

}
