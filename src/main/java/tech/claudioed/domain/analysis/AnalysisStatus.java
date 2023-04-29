package tech.claudioed.domain.analysis;

import java.util.List;
import javax.persistence.Embeddable;

@Embeddable
public class AnalysisStatus {

  private boolean success;

  private String notes;

}
