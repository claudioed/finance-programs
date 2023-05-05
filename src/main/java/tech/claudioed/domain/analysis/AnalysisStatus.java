package tech.claudioed.domain.analysis;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

@Embeddable
public class AnalysisStatus {

  private boolean success;

  @ElementCollection
  private List<String> notes;

  public AnalysisStatus(){}

  public AnalysisStatus(boolean success, List<String> notes) {
    this.success = success;
    this.notes = notes;
  }

  public boolean isSuccess() {
    return success;
  }

  public List<String> getNotes() {
    return notes;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public void setNotes(List<String> notes) {
    this.notes = notes;
  }

}
