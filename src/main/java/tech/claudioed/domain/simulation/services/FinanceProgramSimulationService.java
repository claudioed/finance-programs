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
import tech.claudioed.domain.flat.specification.CreditDeliveryFlatValidationContext;
import tech.claudioed.domain.subsidy.specification.CreditDeliverySubsidyValidationContext;
import tech.claudioed.port.inputs.FinanceProgramQuery;

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

  public FinanceProgramSimulation financeProgram(FinanceProgramQuery request){
    var flats = this.flatRepository.currentFlats(LocalDate.now()).stream().map(flat -> new CreditDeliveryFlatValidationContext(request,
        flat)).filter(CreditDeliveryFlatValidationContext::isSatisfied).toList();
    var subsidies = this.subsidyRepository.currentSubsidies(LocalDate.now()).stream().map( su -> new CreditDeliverySubsidyValidationContext(request,
            su))
        .filter(CreditDeliverySubsidyValidationContext::isSatisfied).toList();
    var referenceRate = this.referenceRateRepository.currentReferenceRate(LocalDateTime.now());
    var flat = new FlatPicker(flats).pick();
    var subsidy = new SubsidyPicker(subsidies).pick();
    return new FinanceProgramSimulationCalculator(subsidy,flat,referenceRate, request).program();
  }

}
