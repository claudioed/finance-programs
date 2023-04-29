package tech.claudioed.port.outputs.analysis;

import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step;

public class EvaluationResult {

  private boolean success;

  private String notes;

  public EvaluationResult(){}

  public EvaluationResult(boolean success, String notes) {
    this.success = success;
    this.notes = notes;
  }

  public String getNotes() {
    return notes;
  }

  public boolean isSuccess() {
    return success;
  }

}
