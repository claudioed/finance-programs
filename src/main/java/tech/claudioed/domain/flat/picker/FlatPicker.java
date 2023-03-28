package tech.claudioed.domain.flat.picker;

import java.util.Comparator;
import java.util.List;
import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.flat.specification.FlatValidationContext;

public class FlatPicker {

  private final List<FlatValidationContext> flats;

  public FlatPicker(List<FlatValidationContext> flats) {
    this.flats = flats;
  }

  public Flat pick(){
    return this.flats.stream().max(Comparator.comparing(FlatValidationContext::points)).get().getFlat();
  }

}
