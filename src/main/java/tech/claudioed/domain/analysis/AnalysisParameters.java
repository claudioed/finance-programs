package tech.claudioed.domain.analysis;

import java.time.LocalDate;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class AnalysisParameters {

  private String productFamilyId;

  private String productId;

  private String customerId;

  private LocalDate contractDate;

}
