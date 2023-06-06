package tech.claudioed.domain.financecondition;

import java.time.LocalDate;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.domain.shared.ids.CultureId;
import tech.claudioed.domain.shared.ids.CustomerId;
import tech.claudioed.domain.shared.ids.DealerId;
import tech.claudioed.domain.shared.ids.ProductFamilyId;
import tech.claudioed.domain.shared.ids.ProductId;

public record DealerQuery(DealerId dealerId, ProductFamilyId productFamilyId, ProductId productId,
                          CustomerId customerId, CultureId cultureId, RatingId ratingId,
                          MarketSegment segment, LocalDate queriedAt) {

}
