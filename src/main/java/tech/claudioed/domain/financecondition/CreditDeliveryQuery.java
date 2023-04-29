package tech.claudioed.domain.financecondition;

import java.time.LocalDate;
import javax.money.MonetaryAmount;
import tech.claudioed.domain.shared.LoanTime;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.port.inputs.DownPayment;
import tech.claudioed.port.inputs.finance.CultureId;
import tech.claudioed.port.inputs.finance.CustomerId;
import tech.claudioed.port.inputs.finance.DealerId;
import tech.claudioed.port.inputs.finance.ProductFamilyId;
import tech.claudioed.port.inputs.finance.ProductId;

public record CreditDeliveryQuery(DealerId dealerId, ProductFamilyId productFamilyId, ProductId productId,
                                  CustomerId customerId, CultureId cultureId, RatingId ratingId,
                                  LoanTime loanTime, MarketSegment segment, LocalDate queriedAt,
                                  DownPayment downPaymentRequirements, MonetaryAmount amount,String utm) {
}
