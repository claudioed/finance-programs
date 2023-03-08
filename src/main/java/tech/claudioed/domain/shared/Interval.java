package tech.claudioed.domain.shared;

import java.time.LocalDate;
import javax.persistence.Embeddable;

@Embeddable
public class Interval {

  private LocalDate start;

  private LocalDate end;

  public Interval(){}
  public Interval(LocalDate start, LocalDate end) {
    this.start = start;
    this.end = end;
  }

  public boolean hasOverlap(Interval t2) {
    return !this.end.isBefore(t2.start) && !this.start.isAfter(t2.end);
  }

  public LocalDate getStart() {
    return start;
  }

  public void setStart(LocalDate start) {
    this.start = start;
  }

  public LocalDate getEnd() {
    return end;
  }

  public void setEnd(LocalDate end) {
    this.end = end;
  }

}
