package tech.claudioed.domain.financecondition;

import java.time.LocalDate;
import javax.money.MonetaryAmount;
import tech.claudioed.domain.shared.LoanTime;
import tech.claudioed.domain.shared.MarketSegment;
import tech.claudioed.port.inputs.DownPayment;
import tech.claudioed.domain.shared.ids.CultureId;
import tech.claudioed.domain.shared.ids.CustomerId;
import tech.claudioed.domain.shared.ids.DealerId;
import tech.claudioed.domain.shared.ids.ProductFamilyId;
import tech.claudioed.domain.shared.ids.ProductId;

public record CreditDeliveryQuery(DealerId dealerId, ProductFamilyId productFamilyId, ProductId productId,
                                  CustomerId customerId, CultureId cultureId, RatingId ratingId,
                                  LoanTime loanTime, MarketSegment segment, LocalDate queriedAt,
                                  DownPayment downPaymentRequirements, MonetaryAmount amount,String utm) {
}
