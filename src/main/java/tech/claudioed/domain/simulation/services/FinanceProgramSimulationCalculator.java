package tech.claudioed.domain.simulation.services;

import tech.claudioed.domain.simulation.FinanceProgramSimulation;
import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.Rate;
import tech.claudioed.domain.referencerate.ReferenceRate;
import tech.claudioed.domain.SubsidiesRequired;
import tech.claudioed.domain.subsidy.Subsidy;
import tech.claudioed.port.inputs.FinanceProgramQuery;

public class FinanceProgramSimulationCalculator {

  private final Subsidy subsidy;

  private final Flat flat;

  private final ReferenceRate referenceRate;

  private final FinanceProgramQuery request;

  public FinanceProgramSimulationCalculator(Subsidy subsidy, Flat flat, ReferenceRate referenceRate,
      FinanceProgramQuery request) {
    this.subsidy = subsidy;
    this.flat = flat;
    this.referenceRate = referenceRate;
    this.request = request;
  }

  public FinanceProgramSimulation program(){
    var missingRate = this.referenceRate.getRate().subtract(this.subsidy.getRate()).subtract(request.getTargetRate());
    var required = new SubsidiesRequired(missingRate);
    return new FinanceProgramSimulation(new Rate(subsidy.getId(),subsidy.getRate()),new Rate(flat.getId(),flat.getRate()),new Rate("required",required.getRate()),request);
  }

}
