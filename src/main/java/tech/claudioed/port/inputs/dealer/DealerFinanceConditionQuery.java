package tech.claudioed.port.inputs.dealer;

import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;

public record DealerFinanceConditionQuery(String dealerId, String customerId, String productLineId, String productId) { }
