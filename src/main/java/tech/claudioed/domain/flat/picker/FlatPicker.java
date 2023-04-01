package tech.claudioed.domain.flat.picker;

import java.util.Comparator;
import java.util.List;
import tech.claudioed.domain.flat.Flat;
import tech.claudioed.domain.flat.specification.CreditDeliveryFlatValidationContext;

public class FlatPicker {

  private final List<CreditDeliveryFlatValidationContext> flats;

  public FlatPicker(List<CreditDeliveryFlatValidationContext> flats) {
    this.flats = flats;
  }

  public Flat pick(){
    return this.flats.stream().max(Comparator.comparing(CreditDeliveryFlatValidationContext::points)).get().getFlat();
  }

}
