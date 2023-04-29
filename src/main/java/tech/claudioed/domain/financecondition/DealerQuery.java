package tech.claudioed.domain.financecondition;

import java.time.LocalDate;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.port.inputs.finance.CultureId;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

public record DealerQuery(DealerId dealerId, ProductFamilyId productFamilyId, ProductId productId,
                          CustomerId customerId, CultureId cultureId, RatingId ratingId,
                          MarketSegment segment, LocalDate queriedAt) {

}
