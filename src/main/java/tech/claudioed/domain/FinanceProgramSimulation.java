package tech.claudioed.domain;

import tech.claudioed.port.inputs.FinanceProgramRequest;

public class FinanceProgramSimulation {

  private Rate subsidy;

  private Rate flat;

  private Rate required;

  private FinanceProgramRequest request;

  public FinanceProgramSimulation(){}

  public FinanceProgramSimulation(Rate subsidy, Rate flat, Rate required,
      FinanceProgramRequest request) {
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

  public FinanceProgramRequest getRequest() {
    return request;
  }

  public void setRequest(FinanceProgramRequest request) {
    this.request = request;
  }
}
