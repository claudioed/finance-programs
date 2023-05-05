package tech.claudioed.domain.analysis;

import java.util.List;
import tech.claudioed.domain.financecondition.FinanceCondition;

public class AnalysisResult {

  private CreditApplicationAnalysis analysis;

  private List<FinanceCondition> options;

  public AnalysisResult(){}

  public AnalysisResult(CreditApplicationAnalysis analysis, List<FinanceCondition> options) {
    this.analysis = analysis;
    this.options = options;
  }

  public CreditApplicationAnalysis getAnalysis() {
    return analysis;
  }

  public List<FinanceCondition> getOptions() {
    return options;
  }

}
