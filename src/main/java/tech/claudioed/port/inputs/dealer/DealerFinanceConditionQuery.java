package tech.claudioed.port.inputs.dealer;

import tech.claudioed.domain.shared.MarketSegment;

public record DealerFinanceConditionQuery(String customerId, String productFamilyId, String productId, String cultureId, String ratingId,
                                          MarketSegment segment) {


}
