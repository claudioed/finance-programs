package tech.claudioed.domain.simulation.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.simulation.FinanceProgramSimulation;
import tech.claudioed.domain.flat.picker.FlatPicker;
import tech.claudioed.domain.subsidy.picker.SubsidyPicker;
import tech.claudioed.domain.flat.repositories.FlatRepository;
import tech.claudioed.domain.referencerate.repositories.ReferenceRateRepository;
import tech.claudioed.domain.subsidy.repositories.SubsidyRepository;
import tech.claudioed.domain.flat.specification.FlatValidationContext;
import tech.claudioed.domain.subsidy.specification.SubsidyValidationContext;
import tech.claudioed.port.inputs.FinanceProgramRequest;

@ApplicationScoped
public class FinanceProgramSimulationService {

  private final FlatRepository flatRepository;

  private final SubsidyRepository subsidyRepository;

  private final ReferenceRateRepository referenceRateRepository;

  public FinanceProgramSimulationService(FlatRepository flatRepository, SubsidyRepository subsidyRepository,
      ReferenceRateRepository referenceRateRepository) {
    this.flatRepository = flatRepository;
    this.subsidyRepository = subsidyRepository;
    this.referenceRateRepository = referenceRateRepository;
  }

  public FinanceProgramSimulation financeProgram(FinanceProgramRequest request){
    var flats = this.flatRepository.currentFlats(LocalDate.now()).stream().map(flat -> new FlatValidationContext(request,
        flat)).filter(FlatValidationContext::isSatisfied).toList();
    var subsidies = this.subsidyRepository.currentSubsidies(LocalDate.now()).stream().map( su -> new SubsidyValidationContext(request,
            su))
        .filter(SubsidyValidationContext::isSatisfied).toList();
    var referenceRate = this.referenceRateRepository.currentReferenceRate(LocalDateTime.now());
    var flat = new FlatPicker(flats).pick();
    var subsidy = new SubsidyPicker(subsidies).pick();
    return new FinanceProgramSimulationCalculator(subsidy,flat,referenceRate, request).program();
  }

}
