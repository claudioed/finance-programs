package tech.claudioed.domain.simulation;

import tech.claudioed.domain.Rate;
import tech.claudioed.port.inputs.FinanceProgramQuery;

public class FinanceProgramSimulation {

  private Rate subsidy;

  private Rate flat;

  private Rate required;

  private FinanceProgramQuery request;

  public FinanceProgramSimulation(){}

  public FinanceProgramSimulation(Rate subsidy, Rate flat, Rate required,
      FinanceProgramQuery request) {
    this.subsidy = subsidy;
    this.flat = flat;
    this.required = required;
    this.request = request;
  }

  public Rate getSubsidy() {
    return subsidy;
  }

  public void setSubsidy(Rate subsidy) {
    this.subsidy = subsidy;
  }

  public Rate getFlat() {
    return flat;
  }

  public void setFlat(Rate flat) {
    this.flat = flat;
  }

  public Rate getRequired() {
    return required;
  }

  public void setRequired(Rate required) {
    this.required = required;
  }

  public FinanceProgramQuery getRequest() {
    return request;
  }

  public void setRequest(FinanceProgramQuery request) {
    this.request = request;
  }
}
