package tech.claudioed.port.inputs.dealer;

import tech.claudioed.domain.financecondition.RatingId;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;

public record DealerFinanceConditionQuery(String customerId, String productFamilyId, String productId, String cultureId, String ratingId,
                                          MarketSegment segment) {


}
