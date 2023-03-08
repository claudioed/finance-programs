package tech.claudioed.domain.aggregates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.FinanceProgramSimulation;
import tech.claudioed.domain.picker.FlatPicker;
import tech.claudioed.domain.picker.SubsidyPicker;
import tech.claudioed.domain.repositories.FlatRepository;
import tech.claudioed.domain.repositories.ReferenceRateRepository;
import tech.claudioed.domain.repositories.SubsidyRepository;
import tech.claudioed.domain.specification.flat.FlatValidationContext;
import tech.claudioed.domain.specification.subsidy.ValidSubsidyForFinanceRequest;
import tech.claudioed.port.inputs.FinanceProgramRequest;

@ApplicationScoped
public class FinanceProgramSimulationAggregate {

  private final FlatRepository flatRepository;

  private final SubsidyRepository subsidyRepository;

  private final ReferenceRateRepository referenceRateRepository;

  public FinanceProgramSimulationAggregate(FlatRepository flatRepository, SubsidyRepository subsidyRepository,
      ReferenceRateRepository referenceRateRepository) {
    this.flatRepository = flatRepository;
    this.subsidyRepository = subsidyRepository;
    this.referenceRateRepository = referenceRateRepository;
  }

  public FinanceProgramSimulation financeProgram(FinanceProgramRequest request){
    var flats = this.flatRepository.currentFlats(LocalDate.now()).stream().map(flat -> new FlatValidationContext(request,
        flat)).filter(FlatValidationContext::isSatisfied).toList();
    var subsidies = this.subsidyRepository.currentSubsidies(LocalDate.now()).stream().filter(sub -> new ValidSubsidyForFinanceRequest(request).isSatisfiedBy(sub)).toList();
    var referenceRate = this.referenceRateRepository.currentReferenceRate(LocalDateTime.now());
    var flat = new FlatPicker(flats).pick();
    var subsidy = new SubsidyPicker(subsidies).pick();
    return new FinanceProgramSimulationCalculator(subsidy,flat,referenceRate, request).program();
  }

}
